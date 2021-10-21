package de.codingair.warpsystem.api.events;

import de.codingair.warpsystem.api.Options;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Will be fired when the player is about to start a teleport.
 */
public class PlayerPreTeleportEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Options options;
    private boolean cancelled;

    public PlayerPreTeleportEvent(@NotNull Player who, @NotNull Options options) {
        super(who);
        this.options = options;
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

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
