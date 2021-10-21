package de.codingair.warpsystem.api.destinations.utils;

import de.codingair.codingapi.tools.io.utils.Serializable;
import org.jetbrains.annotations.Nullable;

public interface IDestinationOptions extends Serializable {
    /**
     * @param message The current message of the destination
     * @return The final message that will be used for the teleport.
     */
    @Nullable
    String buildMessage(@Nullable String message);

    /**
     * @return Whether the teleport feature disabled teleport messages or not.
     */
    boolean sendMessage();

    /**
     * @return Whether the teleport feature disabled teleport messages or not.
     */
    @Nullable
    Boolean getMessage();

    /**
     * @param message The new message.
     */
    void setMessage(@Nullable Boolean message);

    /**
     * @return The current custom message of the destination.
     */
    @Nullable
    String getCustomMessage();

    /**
     * @param customMessage The new custom message of the destination.
     */
    void setCustomMessage(@Nullable String customMessage);

    /**
     * @param seconds The default value.
     * @return The final delay that might be modified by the teleport feature.
     */
    int getDelay(int seconds);

    /**
     * @param delay The new teleport delay in seconds.
     */
    void setDelay(@Nullable Integer delay);

    /**
     * @return Whether the teleport process should consider the current rotation of the player.
     */
    boolean isRotation();

    /**
     * @param rotation Whether the teleport process should consider the current rotation of the player.
     */
    void setRotation(@Nullable Boolean rotation);

    /**
     * @return The custom display name of the destination.
     */
    @Nullable
    String getDisplayName();

    /**
     * @param displayName The new custom display name.
     */
    void setDisplayName(@Nullable String displayName);

    /**
     * @return The display name but with translated color codes.
     */
    @Nullable
    String getColoredDisplayName();

    /**
     * @return The custom value whether teleport particles are enabled or not.
     */
    boolean isParticles();

    /**
     * @return The current particle value. Default is null.
     */
    @Nullable
    Boolean getParticles();

    /**
     * @param particles The new particle value.
     */
    void setParticles(@Nullable Boolean particles);

    /**
     * @return Whether the teleport process should prefer safe teleport target locations.
     */
    boolean isSafeTP();

    /**
     * @return The current safeTp value. Default is null.
     */
    @Nullable
    Boolean getSafeTP();

    /**
     * @param safeTP The new safeTp value.
     */
    void setSafeTP(@Nullable Boolean safeTP);
}
