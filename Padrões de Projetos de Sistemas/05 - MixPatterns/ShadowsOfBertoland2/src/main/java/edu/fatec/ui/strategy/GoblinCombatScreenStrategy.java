package edu.fatec.ui.strategy;

import javax.swing.JFrame;

import edu.fatec.ui.screens.CharacterSelectionScreen;
import edu.fatec.ui.screens.GoblinCombatScreen;

public class GoblinCombatScreenStrategy implements ScreenTransitionStrategy {

    @Override
    public JFrame getNextScreen(String screenName) {
        return new GoblinCombatScreen(); 
    }

    @Override
    public JFrame getPreviousScreen(String screenName) {
        return new CharacterSelectionScreen();
    }

}
