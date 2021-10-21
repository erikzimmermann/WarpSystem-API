package de.codingair.warpsystem.api.destinations;

import org.jetbrains.annotations.Nullable;

public interface IGlobalLocationAdapter extends ILocationAdapter {
    /**
     * @return The current target server if available.
     */
    @Nullable
    String getServer();

    /**
     * @param server The target server (if necessary)
     */
    void setServer(@Nullable String server);
}
