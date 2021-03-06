package com.mycompany.hangman.controller;

import com.mycompany.hangman.gui.GamePanel;
import com.mycompany.hangman.model.HangmanGame;
import com.mycompany.hangman.model.Resetable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordController extends AbstractController implements ActionListener, Resetable
{

    private final GamePanel view;
    private final HangmanGame model;

    /**
     * Constructs a WordController object.
     *
     * @param view  GUI that is displayed
     * @param model contains core game logic
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public WordController(GamePanel view, HangmanGame model)
    {
        this.view = view;
        this.model = model;

        addModel(model);
        addView(view);
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

}
