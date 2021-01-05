package de.codingair.warpsystem.api;

import org.bukkit.entity.Player;

import java.util.concurrent.CompletableFuture;

public interface ITeleportManager {

    CompletableFuture<Result> teleport(Player player, Options options);

}
