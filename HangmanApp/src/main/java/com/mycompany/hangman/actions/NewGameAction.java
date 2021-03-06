package com.mycompany.hangman.actions;

import com.mycompany.hangman.model.Resetable;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class NewGameAction extends AbstractAction
{

    private final Resetable controller;

    public NewGameAction(Resetable controller)
    {
        super("New Game");
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        controller.reset();
    }

}
