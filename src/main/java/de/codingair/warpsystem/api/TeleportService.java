package de.codingair.warpsystem.api;

import org.jetbrains.annotations.NotNull;

public class TeleportService {
    private static ITeleportManager instance;

    /**
     * @return The teleport manager of WarpSystem.
     */
    public static ITeleportManager get() {
        return instance;
    }

    /**
     * This will automatically be used by the WarpSystem itself. Please do not overwriter it.
     *
     * @param instance The new teleport instance.
     */
    public static void set(@NotNull ITeleportManager instance) {
        TeleportService.instance = instance;
    }

    /**
     * This will automatically be used by the WarpSystem itself. Please do not overwriter it.
     *
     * @param instance The new teleport instance.
     */
    public static void setIfAbsent(@NotNull ITeleportManager instance) {
        if (TeleportService.instance != null) return;
        set(instance);
    }
}
