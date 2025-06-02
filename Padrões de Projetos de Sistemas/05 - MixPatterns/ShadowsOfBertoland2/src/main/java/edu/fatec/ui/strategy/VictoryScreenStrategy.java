package edu.fatec.ui.strategy;

import javax.swing.JFrame;

import edu.fatec.ui.screens.DragonCombatScreen;
import edu.fatec.ui.screens.VictoryScreen;

public class VictoryScreenStrategy implements ScreenTransitionStrategy {
    
    @Override
    public JFrame getNextScreen(String screenName) {
        return new VictoryScreen();
    }

    @Override
    public JFrame getPreviousScreen(String screenName) {
        return new DragonCombatScreen();
    }

}
