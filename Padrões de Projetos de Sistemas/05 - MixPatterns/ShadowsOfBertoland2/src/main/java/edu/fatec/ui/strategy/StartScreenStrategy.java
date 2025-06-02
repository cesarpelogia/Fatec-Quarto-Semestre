package edu.fatec.ui.strategy;

import javax.swing.JFrame;

import edu.fatec.ui.screens.CharacterSelectionScreen;

public class StartScreenStrategy implements ScreenTransitionStrategy {

    @Override
    public JFrame getNextScreen(String screenName) {
        return new CharacterSelectionScreen();
    }

    @Override
    public JFrame getPreviousScreen(String screenName) {
        return null;
    }

}
