# WarpSystem-API
[![](https://jitpack.io/v/CodingAir/WarpSystem-API.svg)](https://jitpack.io/#CodingAir/WarpSystem-API)  
The corresponding API to [WarpSystem](https://github.com/CodingAir/WarpSystem-IssueTracker) v5.1.6 and above.  

## Setup

In order to make your plugin compatible with WarpSystem, you need to compile it with the CodingAPI besides WarpSystem-API. Important is, that WarpSystem **relocates** their dependencies. So you need to relocate the CodingAPI as well. Make sure NOT to include both APIs in your plugin.

### Maven 
```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>

<dependency>  
  <groupId>com.github.CodingAir</groupId>
  <artifactId>WarpSystem-API</artifactId>
  <version>5.1.6</version>
  <scope>provided</scope>
</dependency>

<dependency>
    <groupId>com.github.CodingAir</groupId>
    <artifactId>CodingAPI</artifactId>
    <version>1.67</version>
    <scope>provided</scope>
</dependency>

<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>3.2.3</version>
    
        <configuration>
            <relocations>
                <relocation>
                    <pattern>de.codingair.codingapi</pattern>
                    <shadedPattern>de.codingair.warpsystem.lib.codingapi</shadedPattern>
                </relocation>
            </relocations>
        </configuration>
    
        <executions>
            <execution>
                <phase>package</phase>
                <goals>
                    <goal>shade</goal>
                </goals>
            </execution>
        </executions>
    </plugin>
</plugins>
```

### Gradle

```gradle
plugins {
    id 'java'
    id 'com.github.johnrengelman.shadow' version "7.1.2"
}

repositories {
    ...
    maven { url 'https://jitpack.io' }
    ...
}

dependencies {
    ...
    compileOnly 'com.github.CodingAir:WarpSystem-API:5.1.6'
    compileOnly 'com.github.CodingAir:CodingAPI:1.67'
    ...
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

shadowJar {
    relocate 'de.codingair.codingapi', 'de.codingair.warpsystem.lib.codingapi'
}
```

## API
* [AsyncPlayerTeleportEvent](https://github.com/CodingAir/WarpSystem-API/blob/master/src/main/java/de/codingair/warpsystem/api/events/AsyncPlayerTeleportEvent.java)

### Event example
```java
@EventHandler
public void onWarp(AsyncPlayerTeleportEvent e) {
    IDestination destination = e.getOptions().getDestination();
    Location location = destination.buildLocation();
    
    if (location != null && inSpecificArea(location)) {
        e.setCancelled(true);
        e.getPlayer().sendMessage("§cWarps §8» §7This area is §ccurrently unavailable§7.");
    }
}

@EventHandler
public void onTeleport(AsyncPlayerTeleportEvent e) {
    IDestination destination = e.getOptions().getDestination();
    String targetServer = destination.getTargetServer();

    boolean onSameServer = targetServer == null;
    if (onSameServer) return;

    if (isOffline(targetServer)) startSync(targetServer);
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
