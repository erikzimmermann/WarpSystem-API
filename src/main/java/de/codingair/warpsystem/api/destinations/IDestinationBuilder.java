package de.codingair.warpsystem.api.destinations;

import de.codingair.warpsystem.api.destinations.utils.IDestination;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IDestinationBuilder {
    @NotNull
    IEmptyAdapter empty();

    @NotNull
    IGlobalLocationAdapter globalLocation(@Nullable String server, @NotNull Location location);

    @NotNull
    IGlobalWarpAdapter globalWarp();

    @NotNull
    ILocationAdapter location(@NotNull Location location);

    @NotNull
    IServerAdapter server();

    @NotNull
    ISimpleWarpAdapter simpleWarp();

    @NotNull
    IVelocityAdapter velocity(@NotNull Vector vector, @Nullable Double multiplier);

    @NotNull
    IDestination emptyDestination();

    @NotNull
    IDestination globalLocationDestination(@Nullable String server, @NotNull Location location);

    @NotNull
    IDestination globalWarpDestination(@NotNull String id);

    @NotNull
    IDestination locationDestination(@NotNull Location location);

    @NotNull
    IDestination serverDestination(@NotNull String server);

    @NotNull
    IDestination simpleWarpDestination(@NotNull String id);

    @NotNull
    IDestination velocityDestination(@NotNull Vector vector, @Nullable Double multiplier);
}
