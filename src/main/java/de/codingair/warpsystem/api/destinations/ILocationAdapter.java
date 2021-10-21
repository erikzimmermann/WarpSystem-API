package de.codingair.warpsystem.api.destinations;

import de.codingair.codingapi.tools.Location;
import de.codingair.codingapi.tools.io.utils.Serializable;
import de.codingair.warpsystem.api.destinations.utils.IDestinationAdapter;
import de.codingair.warpsystem.api.destinations.utils.IdAdapter;
import de.codingair.warpsystem.api.destinations.utils.Usable;
import org.jetbrains.annotations.Nullable;

public interface ILocationAdapter extends IDestinationAdapter, Serializable, IdAdapter, Usable {

    /**
     * @return The current location.
     */
    @Nullable
    Location getLocation();

    /**
     * @param location A new location.
     */
    void setLocation(@Nullable Location location);
}
