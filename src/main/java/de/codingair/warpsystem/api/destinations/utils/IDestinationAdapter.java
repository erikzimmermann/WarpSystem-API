package de.codingair.warpsystem.api.destinations.utils;

import de.codingair.codingapi.tools.Callback;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public interface IDestinationAdapter {
    /**
     * Initiates the teleport.
     *
     * @param player          Player to be teleported
     * @param id              An optional warp id you can specify
     * @param randomOffset    The offset which can be set in {@link de.codingair.warpsystem.api.Options}
     * @param displayName     The displayName of this destination
     * @param checkPermission Whether you should check for permissions or not
     * @param message         Teleport message which we do NOT have to send this message if the player stays on this server (handled by WarpSystem).
     * @param costs           Teleport costs which we do NOT have to check if the player stays on this server (handled by WarpSystem).
     * @param callback        An optional callback that returns a more specific result than true or false.
     * @return The CompletableFuture<Boolean> which will be completed with true if the teleport succeeded or false if it failed.
     */
    @NotNull
    CompletableFuture<Boolean> teleport(@NotNull Player player, @Nullable String id, @Nullable Vector randomOffset, @Nullable String displayName, boolean checkPermission, @Nullable String message, double costs, @Nullable Callback<Result> callback);

    /**
     * Simulates the teleport process to check for errors before initializing the entire teleport.
     *
     * @param player          Player to be teleported
     * @param id              The id of the destination
     * @param checkPermission Whether you should check for permissions or not
     * @return A {@link SimulatedTeleportResult} for this teleport process.
     */
    @NotNull
    SimulatedTeleportResult simulate(@NotNull Player player, @Nullable String id, boolean checkPermission);

    /**
     * @return A location that might be used in this teleport process. Might be null if this teleport does not include any locations or the location is on another server.
     */
    @Nullable
    Location buildLocation(@NotNull String id);

    /**
     * @return The current costs.
     */
    double getCosts(@NotNull String id);

    /**
     * @return Whether this teleport process uses bukkit teleportation to succeed. Some teleports require server switches and therefore return false.
     */
    boolean usesBukkitTeleportation();
}
