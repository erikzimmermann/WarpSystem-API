package de.codingair.warpsystem.api;

import de.codingair.warpsystem.api.destinations.IDestinationBuilder;
import de.codingair.warpsystem.api.destinations.utils.IDestination;
import de.codingair.warpsystem.api.destinations.utils.Result;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public interface ITeleportManager {

    /**
     * @param player  The player that should be teleported.
     * @param options The options for the teleport.
     * @return A {@link CompletableFuture<Result>} that will be fired when the teleport is finished or cancelled.
     */
    @NotNull
    CompletableFuture<Result> teleport(@NotNull Player player, @NotNull Options options);

    /**
     * @return A new {@link Options} instance that can be used to call {@link ITeleportManager#teleport(Player, Options)}.
     */
    @NotNull
    Options options();

    /**
     * @return A new {@link IDestinationBuilder} instance that can be used to create pre-defined destinations.
     */
    @NotNull
    IDestinationBuilder destinationBuilder();
}
