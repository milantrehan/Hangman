package com.mycompany.hangman.controller;

import com.mycompany.hangman.gui.GamePanel;
import com.mycompany.hangman.model.GameConfig;
import com.mycompany.hangman.model.HangmanGame;
import com.mycompany.hangman.model.Resetable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author Cory
 */
public class WordController extends AbstractController implements ActionListener, Resetable
{

    private final GamePanel view;
    private final HangmanGame model;

    public WordController(GamePanel view, HangmanGame model)
    {
        this.view = view;
        this.model = model;

        addModel(model);
        addView(view);

        view.setWordToGuess(model.getDisplayString());
        view.setIncorrectLetters(model.getIncorrectLetters());
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String guess = view.consumeGuess();
        if (!guess.isEmpty())
        {
            model.processLetter(guess.charAt(0));
        }
    }

    @Override
    public void reset()
    {
        this.model.reset();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        if (evt.getPropertyName().equals(HangmanGame.SET_CONFIG))
        {
            model.setConfig((GameConfig) evt.getNewValue());
        }
        else
        {
            super.propertyChange(evt);
        }
    }

}
