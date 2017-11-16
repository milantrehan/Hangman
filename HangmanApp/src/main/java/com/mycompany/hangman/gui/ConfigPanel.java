package com.mycompany.hangman.gui;

import com.mycompany.hangman.model.GameConfig;
import com.mycompany.hangman.model.HangmanGame;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author cory.bianchi
 */
public class ConfigPanel extends javax.swing.JPanel implements View
{

    /**
     * Creates new form ConfigPanel
     */
    public ConfigPanel()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        guessLimitLabel = new javax.swing.JLabel();
        guessLimitSlider = new javax.swing.JSlider();

        guessLimitLabel.setText("Guess Limit:");

        guessLimitSlider.setMajorTickSpacing(2);
        guessLimitSlider.setMaximum(GameConfig.MAX_NUM_GUESSES);
        guessLimitSlider.setMinimum(GameConfig.MIN_NUM_GUESSES);
        guessLimitSlider.setMinorTickSpacing(1);
        guessLimitSlider.setPaintLabels(true);
        guessLimitSlider.setPaintTicks(true);
        guessLimitSlider.setSnapToTicks(true);
        guessLimitSlider.setToolTipText("");
        guessLimitSlider.setValue(GameConfig.DEFAULT_NUM_GUESSES);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(guessLimitLabel)
                .addGap(18, 18, 18)
                .addComponent(guessLimitSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(guessLimitSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guessLimitLabel))
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel guessLimitLabel;
    private javax.swing.JSlider guessLimitSlider;
    // End of variables declaration//GEN-END:variables

    @Override
    public void modelPropertyChange(PropertyChangeEvent evt)
    {
        if (evt.getPropertyName().equals(HangmanGame.GAME_CONFIG))
        {
            System.out.println("Game Config Event");
            GameConfig config = (GameConfig) evt.getNewValue();
            applyConfig(config);
        }
    }

    private void applyConfig(GameConfig config)
    {
        this.guessLimitSlider.setValue(config.getNumGuessesAllowed());
    }

    public GameConfig getUserConfig()
    {
        GameConfig retVal = new GameConfig();
        retVal.setNumGuessesAllowed(guessLimitSlider.getValue());
        return retVal;
    }
}
