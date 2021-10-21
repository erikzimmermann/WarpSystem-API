package de.codingair.warpsystem.api.destinations.utils;

import org.jetbrains.annotations.Nullable;

/**
 * An adapter which manages the id for itself.
 */
public interface IdAdapter {

    /**
     * @return The target id for the teleport.
     */
    @Nullable
    String getId();

}
