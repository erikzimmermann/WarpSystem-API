package de.codingair.warpsystem.api.destinations.utils;

import de.codingair.codingapi.tools.Callback;
import de.codingair.codingapi.tools.Location;
import de.codingair.codingapi.tools.io.utils.Serializable;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public interface IDestination extends Serializable {
    /**
     * @return The target server if this is a proxy teleport.
     */
    @Nullable
    String getTargetServer();

    /**
     * Initiates the teleport process of the destination adapter.
     *
     * @param player          Player to be teleported
     * @param message         Teleport message which we do NOT have to send this message if the player stays on this server (handled by WarpSystem).
     * @param displayName     The displayName of this destination
     * @param checkPermission Whether you should check for permissions or not
     * @param costs           Teleport costs which we do NOT have to check if the player stays on this server (handled by WarpSystem).
     * @param callback        An optional callback that returns a more specific result than true or false.
     * @return The CompletableFuture<Boolean> which will be completed with true if the teleport succeeded or false if it failed.
     */
    @NotNull
    CompletableFuture<Boolean> teleport(@NotNull Player player, @Nullable String message, @Nullable String displayName, boolean checkPermission, double costs, @Nullable Callback<Result> callback);

    /**
     * @param player      The given player
     * @param message     An optional message that should be sent
     * @param displayName The displayName  of the destination that should be entered
     * @param costs       The costs of the teleport
     * @param origin      The origin of this teleport
     */
    void sendMessage(@NotNull Player player, @Nullable String message, @NotNull String displayName, double costs, @NotNull Origin origin);

    /**
     * Adjusts a given location until it's final. Includes random offset or rotation.
     *
     * @param player   The given player that should be teleported
     * @param location A given location
     */
    void adjustLocation(@NotNull Player player, @NotNull org.bukkit.Location location);

    /**
     * @return A location that might be used in this teleport process. Might be null if this teleport does not include any locations or the location is on another server.
     */
    @Nullable
    Location buildLocation();

    /**
     * @return The random offset
     */
    @Nullable
    Vector buildRandomOffset();

    /**
     * @return The current costs.
     */
    double getCosts();

    /**
     * Initiates the teleport simulation of the destination adapter.
     *
     * @param player          The given player
     * @param checkPermission Whether the adapter should check for permissions or not
     * @return A {@link SimulatedTeleportResult}.
     */
    @NotNull
    SimulatedTeleportResult simulate(Player player, boolean checkPermission);

    /**
     * @return The current destination id (e.g. the name of the SimpleWarp if the {@link de.codingair.warpsystem.api.destinations.ISimpleWarpAdapter} is used).
     */
    @Nullable
    String getId();

    /**
     * @param id The new destination id (e.g. the name of the SimpleWarp if the {@link de.codingair.warpsystem.api.destinations.ISimpleWarpAdapter} is used).
     */
    void setId(@Nullable String id);

    /**
     * @return The current destination adapter.
     */
    @Nullable
    IDestinationAdapter getAdapter();

    /**
     * @param adapter The new destination adapter. A destination is meant to hold an adapter so it should be impossible to set this value to null.
     */
    void setAdapter(@NotNull IDestinationAdapter adapter);

    /**
     * @return The current random x offset.
     */
    double getOffsetX();

    /**
     * @param offsetX The new x offset range. Will be used in the positive and the negative direction.
     */
    void setOffsetX(double offsetX);

    /**
     * @return The current random y offset.
     */
    double getOffsetY();

    /**
     * @param offsetY The new y offset range. Will be used in the positive and the negative direction.
     */
    void setOffsetY(double offsetY);

    /**
     * @return The current random z offset.
     */
    double getOffsetZ();

    /**
     * @param offsetZ The new z offset range. Will be used in the positive and the negative direction.
     */
    void setOffsetZ(double offsetZ);

    /**
     * @return Whether this teleport process uses bukkit teleportation to succeed. Some teleports require server switches and therefore return false.
     */
    boolean usesBukkitTeleportation();

    /**
     * @return The current custom options.
     */
    @NotNull
    IDestinationOptions getCustomOptions();
}
