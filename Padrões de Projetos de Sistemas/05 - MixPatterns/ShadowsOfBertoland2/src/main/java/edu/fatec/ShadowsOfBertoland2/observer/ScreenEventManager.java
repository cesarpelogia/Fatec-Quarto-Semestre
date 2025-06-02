package edu.fatec.ShadowsOfBertoland2.observer;

import java.util.List;

public class ScreenEventManager {
    private static final List<ScreenEventListener> listeners = new java.util.ArrayList<>();

    public static void addListener(ScreenEventListener listener) {
        if (listener != null && !listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public static void notifyEvent(String eventType) {
        for (ScreenEventListener listener : listeners) {
            listener.onScreenEvent(eventType);
        }
    }
}
