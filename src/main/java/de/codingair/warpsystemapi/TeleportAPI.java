package de.codingair.warpsystemapi;

import de.codingair.codingapi.tools.Location;
import org.bukkit.entity.Player;

public class TeleportAPI {
    private static Class<?> CLAZZ;
    private static Object MANAGER;

    static {
        try {
            CLAZZ = Class.forName("de.codingair.warpsystem.spigot.base.managers.TeleportManager");
            MANAGER = CLAZZ.getDeclaredMethod("getInstance").invoke(null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isTeleporting(Player player) {
        return false;
    }

    public void teleport(Player player, Location location) {
        teleport(player, location, null);
    }

    public void teleport(Player player, Location location, String server) {
        
    }
}
