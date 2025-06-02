package edu.fatec.ShadowsOfBertoland2.observer;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import edu.fatec.ui.screens.StartScreen;
import edu.fatec.ui.strategy.CharacterSelectionStrategy;
import edu.fatec.ui.strategy.DragonCombatStrategy;
import edu.fatec.ui.strategy.EndScreenStrategy;
import edu.fatec.ui.strategy.GoblinCombatScreenStrategy;
import edu.fatec.ui.strategy.OrcCombatStrategy;
import edu.fatec.ui.strategy.ScreenTransitionStrategy;
import edu.fatec.ui.strategy.VictoryScreenStrategy;
import edu.fatec.ui.strategy.WizardScreenStrategy;

public class ScreenController implements ScreenEventListener {

    private JFrame currentScreen;
    private final Map<String, ScreenTransitionStrategy> strategyMap = new HashMap<>();

    public ScreenController() {
        
        strategyMap.put("BACK_TO_START", new CharacterSelectionStrategy());
        strategyMap.put("START_BUTTON_CLICKED", new CharacterSelectionStrategy());
        strategyMap.put("CHARACTER_SELECTED", new GoblinCombatScreenStrategy());
        strategyMap.put("GOBLIN_COMBAT_FINISHED", new OrcCombatStrategy());
        strategyMap.put("ORC_COMBAT_FINISHED", new DragonCombatStrategy());
        strategyMap.put("DRAGON_COMBAT_FINISHED", new VictoryScreenStrategy());
        strategyMap.put("VICTORY_SCREEN_FINISHED", new WizardScreenStrategy());
        strategyMap.put("WIZARD_SCREEN_FINISHED", new EndScreenStrategy());

        currentScreen = new StartScreen();
        currentScreen.setVisible(true);
    }

    public void initialize() {
        ScreenEventManager.addListener(this);
    }

    @Override
    public void onScreenEvent(String eventType) {
        ScreenTransitionStrategy strategy = strategyMap.get(eventType);

        if (strategy != null) {

            currentScreen.dispose();
            currentScreen = strategy.getNextScreen(eventType);
            currentScreen.setVisible(true);
        } else {
            System.err.println("Nenhuma estratégia definida para o evento: " + eventType);
        }
    }
}