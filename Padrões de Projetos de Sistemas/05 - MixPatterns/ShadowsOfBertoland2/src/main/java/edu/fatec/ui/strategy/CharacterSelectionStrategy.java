package edu.fatec.ui.strategy;

import javax.swing.JFrame;

import edu.fatec.ui.screens.CharacterSelectionScreen;
import edu.fatec.ui.screens.StartScreen;

public class CharacterSelectionStrategy implements ScreenTransitionStrategy {

    @Override
    public JFrame getNextScreen(String screenName) {
        return new CharacterSelectionScreen();
    }
    @Override
    public JFrame getPreviousScreen(String screenName) {
        return new StartScreen();
    }
}
