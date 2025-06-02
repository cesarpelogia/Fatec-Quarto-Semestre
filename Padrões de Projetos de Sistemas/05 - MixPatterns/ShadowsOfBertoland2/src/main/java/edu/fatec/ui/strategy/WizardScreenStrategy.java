package edu.fatec.ui.strategy;

import javax.swing.JFrame;

import edu.fatec.ui.screens.VictoryScreen;
import edu.fatec.ui.screens.WyzardScreen;

public class WizardScreenStrategy implements ScreenTransitionStrategy {

    @Override
    public JFrame getNextScreen(String screenName) {
        return new WyzardScreen();
    }

    @Override
    public JFrame getPreviousScreen(String screenName) {
        return new VictoryScreen();
    }
}
