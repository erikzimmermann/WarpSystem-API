package de.codingair.warpsystem.api;

import de.codingair.warpsystem.api.destinations.IDestinationBuilder;
import de.codingair.warpsystem.api.destinations.utils.Result;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Map;
import java.util.Set;
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

    /**
     * @return A set of all available servers that are connected by a proxy.
     */
    @NotNull
    @Unmodifiable Set<String> servers();

    /**
     * @return A map containing all available server names and their worlds on the entire proxy. This is used for providing world name suggestions for the random teleport command.
     */
    @NotNull
    @Unmodifiable Map<String, Set<String>> worlds();

    /**
     * @return A set of all simple warp names available on this server.
     */
    @NotNull
    @Unmodifiable Set<String> simpleWarps();

    /**
     * @param id The id of the simple warp.
     * @return The location of the given simple warp if available.
     */
    @Nullable
    Location simpleWarp(@NotNull String id);

    /**
     * @return A map containing all global warp names and their corresponding server name available on the entire network.
     */
    @NotNull
    @Unmodifiable Map<String, String> globalWarps();
}
