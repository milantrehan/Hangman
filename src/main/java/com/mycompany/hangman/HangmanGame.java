/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman;

import com.mycompany.hangman.gui.PrintArea;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cory
 */
public class HangmanGame implements Game, InputListener
{

    private static int CHANCES_TO_GUESS = 5;
    private int chancesLeftToGuess;
    private Scanner scan = new Scanner(System.in);
    private List<Character> guessedLetters = new ArrayList();
    private char guessedLetter;
    private WordGenerator wordGenerator = new WordGenerator();
    private Word wordToGuess;
    private PrintArea printArea;
    private final Object inputWait = new Object();

    public void start()
    {
        reset();
        //Stops when the word is guessed or ran out of chances
        while (!wordToGuess.hasGuessedWord() && chancesLeftToGuess > 0)
        {

            waitForNextGuess();
            checkGuessedLetter(guessedLetter);

            if (wordToGuess.hasGuessedWord())
            {
                //Prints out if the word is figured out
                printArea.println("Great, you have figured out the word! It is " + wordToGuess + ".");
            }
            else if (Word.hasLetter(guessedLetter, guessedLetters))
            {
                printArea.println("You already guessed the letter '" + guessedLetter + "'. So far you have ");
                wordToGuess.print();
            }
            else if (wordToGuess.hasLetter(guessedLetter))
            {
                printArea.println("Great guess you got one!");
                wordToGuess.print();
            }
            else
            {
                chancesLeftToGuess--;
                printArea.println("Sorry, wrong guess. You have " + (chancesLeftToGuess) + " chances left. So far, you have ");
                wordToGuess.print();

                if (chancesLeftToGuess == 0)
                {
                    printArea.println("You Lose. The word was " + wordToGuess);
                }
            }
            addGuessedLetterToList(guessedLetter);
        }
    }

    public void setWordToGuess(String word)
    {
//        this.wordToGuess = word;
    }

    public void setPrintArea(PrintArea area)
    {
        this.printArea = area;
    }

    public void stop()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void reset()
    {
        wordToGuess = new Word(wordGenerator.generateWord());
        wordToGuess.setPrintArea(printArea);
        chancesLeftToGuess = CHANCES_TO_GUESS;
        guessedLetters = new ArrayList();
        wordToGuess.print();
    }

    /**
     * Check if new letter is correct
     *
     * @param guessedLetter letter that was guessed
     */
    protected void checkGuessedLetter(char guessedLetter)
    {
        if (!Word.hasLetter(guessedLetter, guessedLetters))
        {
            wordToGuess.guessedCorrectLetter(guessedLetter);
        }
    }

    /**
     * Add letter to list of guessed letters
     *
     * @param letter letter that was guessed
     */
    protected void addGuessedLetterToList(char letter)
    {
        guessedLetters.add(new Character(letter));
    }

    protected boolean isALetter(char character)
    {
        //return ((character - 'a' ) < 26) || ((character - 'A') < 26);
        return ('a' <= character) && (character <= 'z');
    }

    /**
     * Called when there is an input from the user. Notifies if the input is a
     * letter.
     *
     * @param inputChar
     */
    public void inputEvent(char inputChar)
    {
        if (isALetter(inputChar))
        {
            guessedLetter = inputChar;
            synchronized (this.inputWait)
            {
                inputWait.notify();
            }
        }
        else
        {
            printArea.println("Please make a valid guess.");
        }
    }

    protected char getGuessedLetter()
    {
        return guessedLetter;
    }

    protected void waitForNextGuess()
    {
        synchronized (this.inputWait)
        {
            try
            {
                inputWait.wait();
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(HangmanGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}