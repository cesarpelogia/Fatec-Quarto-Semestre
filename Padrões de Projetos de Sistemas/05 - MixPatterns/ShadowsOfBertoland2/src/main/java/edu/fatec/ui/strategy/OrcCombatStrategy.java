package edu.fatec.ui.strategy;

import javax.swing.JFrame;

import edu.fatec.ui.screens.GoblinCombatScreen;
import edu.fatec.ui.screens.OrcCombatScreen;

public class OrcCombatStrategy implements ScreenTransitionStrategy {

    @Override
    public JFrame getNextScreen(String screenName) {
        return new OrcCombatScreen();
    }

    @Override
    public JFrame getPreviousScreen(String screenName) {
        return new GoblinCombatScreen();
    }

}
