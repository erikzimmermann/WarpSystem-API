package de.codingair.warpsystem.api;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public interface IDestination {
    /**
     * @param player          Player to be teleported
     * @param id              An optional warp id you can specify
     * @param randomOffset    The offset which can be set in @see de.codingair.warpsystem.api.Options
     * @param displayName     The displayName of this destination
     * @param checkPermission If you still need to check permissions for this teleportation. This means only custom permissions.
     * @param message         Teleport message which we do NOT have to send this message if the player stays on this server (handled by WarpSystem).
     * @param costs           Teleport costs which we do NOT have to check if the player stays on this server (handled by WarpSystem).
     * @return The CompletableFuture<Result> which must be called after finishing the teleportation process.
     */
    CompletableFuture<Result> teleport(@NotNull Player player, @Nullable String id, @NotNull Vector randomOffset, @NotNull String displayName, boolean checkPermission, @Nullable String message, double costs);
}
