package de.codingair.warpsystem.api;

public class TeleportService {
    private static ITeleportManager instance;

    public static ITeleportManager getInstance() {
        return instance;
    }

    public static void setInstance(ITeleportManager instance) {
        TeleportService.instance = instance;
    }

    public static void setInstanceIfAbsent(ITeleportManager instance) {
        if(TeleportService.instance != null) return;
        setInstance(instance);
    }
}
