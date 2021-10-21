package de.codingair.warpsystem.api.destinations.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SimulatedTeleportResult {
    private final String error;
    private final Result result;

    /**
     * @param error  The error that should be send to the player. The error message will not be modified anymore so the player will get an empty message if you leave it blank (""). Null means that no error has occurred.
     * @param result The result of the simulated teleport result. Default is {@link Result#SUCCESS}.
     */
    public SimulatedTeleportResult(@Nullable String error, @NotNull Result result) {
        this.error = error;
        this.result = result;
    }

    @Nullable
    public String getError() {
        return error;
    }

    @NotNull
    public Result getResult() {
        return result;
    }
}
