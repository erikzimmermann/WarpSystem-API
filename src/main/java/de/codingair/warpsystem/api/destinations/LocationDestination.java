package de.codingair.warpsystem.api.destinations;

import de.codingair.warpsystem.api.IDestination;
import de.codingair.warpsystem.api.Result;
import io.papermc.lib.PaperLib;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class LocationDestination implements IDestination {
    private final Location location;

    public LocationDestination(@NotNull Location location) {
        if(location.getWorld() == null) throw new IllegalArgumentException("World does not exist.");
        this.location = location;
    }

    @Override
    public CompletableFuture<Result> teleport(@NotNull Player player, @Nullable String id, @NotNull Vector randomOffset, @NotNull String displayName, boolean checkPermission, @Nullable String message, double costs) {
        CompletableFuture<Boolean> f = PaperLib.teleportAsync(player, location.clone().add(randomOffset), PlayerTeleportEvent.TeleportCause.PLUGIN);

        CompletableFuture<Result> future = new CompletableFuture<>();
        f.whenComplete((suc, err) -> {
            if(err != null || !suc) future.complete(Result.ERROR);
            else future.complete(Result.SUCCESS);
        });

        return future;
    }
}
