package de.codingair.warpsystem.api.events;

import de.codingair.warpsystem.api.Options;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Will be fired when the player is about to start a teleport through WarpSystem.
 */
public class AsyncPlayerTeleportEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final Options options;
    private boolean cancelled;

    public AsyncPlayerTeleportEvent(@NotNull Player player, @NotNull Options options) {
        super(true);
        this.player = player;
        this.options = options;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * @return The player that will be teleported.
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * Teleport options can be modified.
     *
     * @return The current teleport options.
     */
    @NotNull
    public Options getOptions() {
        return options;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * If a teleport will be cancelled in this state no messages will be sent to the player.
     *
     * @param cancelled Whether the teleport should be cancelled or not.
     */
    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }
}
