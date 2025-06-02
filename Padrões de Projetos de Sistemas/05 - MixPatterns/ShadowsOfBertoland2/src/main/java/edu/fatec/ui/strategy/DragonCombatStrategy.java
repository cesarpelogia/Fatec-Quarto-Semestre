package edu.fatec.ui.strategy;

import javax.swing.JFrame;

import edu.fatec.ui.screens.DragonCombatScreen;
import edu.fatec.ui.screens.OrcCombatScreen;

public class DragonCombatStrategy implements ScreenTransitionStrategy {

    @Override
    public JFrame getNextScreen(String screenName) {
        return new DragonCombatScreen();
    }

    @Override
    public JFrame getPreviousScreen(String screenName) {
        return new OrcCombatScreen();
    }

}
