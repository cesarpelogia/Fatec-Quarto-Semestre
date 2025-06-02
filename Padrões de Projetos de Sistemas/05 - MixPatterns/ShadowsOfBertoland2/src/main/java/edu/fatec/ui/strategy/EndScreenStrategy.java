package edu.fatec.ui.strategy;

import javax.swing.JFrame;

import edu.fatec.ui.screens.EndScreen;

public class EndScreenStrategy implements ScreenTransitionStrategy {

    @Override
    public JFrame getNextScreen(String screenName) {
        return new EndScreen();
    }

    @Override
    public JFrame getPreviousScreen(String screenName) {
        return null; 
    }

}
