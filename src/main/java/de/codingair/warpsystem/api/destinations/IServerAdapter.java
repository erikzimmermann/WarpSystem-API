package de.codingair.warpsystem.api.destinations;

import de.codingair.codingapi.tools.io.utils.Serializable;
import de.codingair.warpsystem.api.destinations.utils.IDestinationAdapter;
import de.codingair.warpsystem.api.destinations.utils.IdAdapter;
import de.codingair.warpsystem.api.destinations.utils.Usable;
import org.jetbrains.annotations.NotNull;

public interface IServerAdapter extends IDestinationAdapter, Serializable, Usable, IdAdapter {
    /**
     * @return Whether the player should keep the position after the server switch. If true, the player will be teleported to the position he currently has.
     */
    boolean isKeepPosition();

    /**
     * @param keepPosition Whether the player should keep the position after the server switch. If true, the player will be teleported to the position he currently has.
     */
    void setKeepPosition(boolean keepPosition);

    /**
     * @return The current target server.
     */
    @NotNull
    String getServer();

    /**
     * @param server A new target server.
     */
    void setServer(@NotNull String server);
}
