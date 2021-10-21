package de.codingair.warpsystem.api.destinations;

import de.codingair.codingapi.tools.io.utils.Serializable;
import de.codingair.warpsystem.api.destinations.utils.IDestinationAdapter;
import de.codingair.warpsystem.api.destinations.utils.Usable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

public interface IVelocityAdapter extends IDestinationAdapter, Serializable, Usable {

    /**
     * @return The current velocity vector.
     */
    @Nullable Vector getVector();

    /**
     * @param vector The new vector which will be normalized later on.
     */
    void setVector(@Nullable Vector vector);

    /**
     * @return The current multiplier. Null values will be replaced by 1 later on.
     */
    @Nullable Double getMultiplier();

    /**
     * @param multiplier A new multiplier. Null values will be replaced by 1 later on.
     */
    void setMultiplier(@Nullable Double multiplier);
}
