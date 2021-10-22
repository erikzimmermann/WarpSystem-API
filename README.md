# WarpSystem-API
[![](https://jitpack.io/v/CodingAir/WarpSystem-API.svg)](https://jitpack.io/#CodingAir/WarpSystem-API)  
The corresponding API to [WarpSystem](https://github.com/CodingAir/WarpSystem-IssueTracker) v5.0.6 and above.  

### Maven 
```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>

<dependency>  
  <groupId>com.github.CodingAir</groupId>
  <artifactId>WarpSystem-API</artifactId>
  <version>5.0.6</version>
  <scope>provided</scope>
</dependency>

<!-- Important: This API is necessary for compiling your plugin -->
<dependency>
    <groupId>com.github.CodingAir</groupId>
    <artifactId>CodingAPI</artifactId>
    <version>1.35</version>
    <scope>provided</scope>
</dependency>
```

### Event List
* [AsyncPlayerTeleportEvent](https://github.com/CodingAir/WarpSystem-API/blob/master/src/main/java/de/codingair/warpsystem/api/events/AsyncPlayerTeleportEvent.java)

### Event example
```java
@EventHandler
public void onWarp(PlayerPreTeleportEvent e) {
    IDestination destination = e.getOptions().getDestination();
    Location location = destination.buildLocation();
    
    if (location != null && inSpecificArea(location)) {
        e.setCancelled(true);
        e.getPlayer().sendMessage("§cWarps §8» §7This area is §ccurrently unavailable§7.");
    }
}
```

### Custom teleports
```java
public void teleport(@NotNull Player player) {
    ITeleportManager man = TeleportService.get();
    IDestinationBuilder builder = man.destinationBuilder();

    man.teleport(player, man.options()
            .setDestination(builder.serverDestination("citybuild-01"))
            .setMessage("§cWarps §8» §7You were moved to §eCityBuild§7.")
            .setSkip(true)
    );
}
```

### Custom destination adapter
```java
import de.codingair.codingapi.tools.Callback;
import de.codingair.warpsystem.api.destinations.utils.IDestinationAdapter;
import de.codingair.warpsystem.api.destinations.utils.Result;
import de.codingair.warpsystem.api.destinations.utils.SimulatedTeleportResult;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class CustomDestinationAdapter implements IDestinationAdapter {
    @Override
    public @NotNull CompletableFuture<Boolean> teleport(@NotNull Player player, @Nullable String id, @Nullable Vector randomOffset, @Nullable String displayName, boolean checkPermission, @Nullable String message, double costs, @Nullable Callback<Result> callback) {
        //find a player
        Optional<? extends Player> opt = Bukkit.getOnlinePlayers().stream().findAny();
        boolean present = opt.isPresent();

        //teleport if present
        if (present) player.teleport(opt.get());

        //give feedback about the specific result
        if (callback != null) callback.accept(present ? Result.SUCCESS : Result.ERROR);

        //return whether we teleported the player or not
        return CompletableFuture.completedFuture(present);
    }

    @Override
    public @NotNull SimulatedTeleportResult simulate(@NotNull Player player, @Nullable String id, boolean checkPermission) {
        //find a player
        Optional<? extends Player> opt = Bukkit.getOnlinePlayers().stream().findAny();
        boolean present = opt.isPresent();

        //give some feedback about potential teleport
        if (present) return new SimulatedTeleportResult(null, Result.SUCCESS);
        else return new SimulatedTeleportResult("§cWarps §8» §cNo player online!", Result.ERROR);
    }

    @Override
    public @Nullable Location buildLocation(@NotNull String id) {
        //find a player
        Optional<? extends Player> opt = Bukkit.getOnlinePlayers().stream().findAny();
        boolean present = opt.isPresent();

        //return the target location (if we have one)
        if (present) return opt.get().getLocation();
        else return null;
    }

    @Override
    public double getCosts(@NotNull String id) {
        //we don't want any costs for the player
        return 0;
    }

    @Override
    public boolean usesBukkitTeleportation() {
        //we are not using any BungeeCord or Velocity stuff for our teleport so return true which means: bukkit only
        return true;
    }
}

```
