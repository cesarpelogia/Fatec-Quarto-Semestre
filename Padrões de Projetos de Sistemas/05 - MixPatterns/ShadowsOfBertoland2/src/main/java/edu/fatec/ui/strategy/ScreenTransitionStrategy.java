package edu.fatec.ui.strategy;

import javax.swing.JFrame;

public interface  ScreenTransitionStrategy {

    JFrame getNextScreen(String screenName);
    JFrame getPreviousScreen(String screenName);

}
