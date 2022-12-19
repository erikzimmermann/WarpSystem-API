package de.codingair.warpsystem.api;

import de.codingair.codingapi.server.sounds.SoundData;
import de.codingair.codingapi.tools.Callback;
import de.codingair.warpsystem.api.destinations.utils.IDestination;
import de.codingair.warpsystem.api.destinations.utils.Origin;
import de.codingair.warpsystem.api.destinations.utils.Result;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * <p>An options class for all teleports via WarpSystem.</p>
 * <p>A new instance can be created with {@link ITeleportManager#options()} by using {@link TeleportService#get()}.</p>
 */
public interface Options {

    /**
     * @return Builds the location instance from the given destination if available.
     */
    @Nullable
    Location buildLocation();

    /**
     * Destroys the content of this instance.
     * @return This options-instance.
     */
    @NotNull
    Options destroy();

    /**
     * @return The origin of the teleport.
     */
    @NotNull
    Origin getOrigin();

    /**
     * @return The destination of the teleport.
     */
    @NotNull
    IDestination getDestination();

    /**
     * Overwrites the given destination.
     *
     * @param destination The new destination
     * @return This options-instance.
     */
    @NotNull
    Options setDestination(@NotNull IDestination destination);

    /**
     * @return The current display name of the given destination if available.
     */
    @Nullable
    String getDisplayName();

    /**
     * Overwrites the given destination display name.
     *
     * @param displayName The new destination display name.
     * @return This options-instance.
     */
    @NotNull
    Options setDisplayName(@Nullable String displayName);

    /**
     * @return The current permission if available.
     */
    @Nullable
    String getPermission();

    /**
     * Overwrites the given permission.
     *
     * @param permission The new permission.
     * @return This options-instance.
     */
    @NotNull
    Options setPermission(@Nullable String permission);

    /**
     * @param player The given player.
     * @return The current costs for the specific player. Might be zero if the player has the teleport costs bypass permission.
     */
    double getCosts(@NotNull Player player);

    /**
     * Overwrites the given costs.
     *
     * @param costs The new costs.
     * @return This options-instance.
     */
    @NotNull
    Options setCosts(double costs);

    /**
     * @param player The given player.
     * @return The final costs for the specific player. Might be zero if the player has the teleport costs bypass permission, no economy system is available or costs are negative.
     */
    @NotNull
    Number getFinalCosts(@NotNull Player player);

    /**
     * @return Whether the teleport delay should be skipped or not. Default is false.
     */
    boolean isSkip();

    /**
     * @return The current set skip value. Default is null.
     */
    @Nullable
    Boolean getSkip();

    /**
     * @param skip The new skip value.
     * @return This options-instance.
     */
    @NotNull
    Options setSkip(boolean skip);

    /**
     * @return Whether the player can move during the teleport delay or not.
     */
    boolean isCanMove();

    /**
     * @param canMove Whether the player should be able to move during the teleport delay or not.
     * @return This options-instance.
     */
    @NotNull
    Options setCanMove(boolean canMove);

    /**
     * @return Whether the teleport process waits until the player stands still or directly starts after running the teleport method.
     */
    boolean isWaitForTeleport();

    /**
     * @param waitForTeleport Whether the teleport process should wait until the player stands still or directly start after running the teleport method.
     * @return This options-instance.
     */
    @NotNull
    Options setWaitForTeleport(boolean waitForTeleport);

    /**
     * @return The current teleport message.
     */
    @Nullable
    String getMessage();

    /**
     * @param message The new teleport message. The message will be sent as it will be stored in this instance without any modifications for things like prefixes.
     * @return This options-instance.
     */
    @NotNull
    Options setMessage(@Nullable String message);

    /**
     * @return The current teleport sound.
     */
    @Nullable
    SoundData getTeleportSound();

    /**
     * @param teleportSound The new teleport sound.
     * @return This options-instance.
     */
    @NotNull
    Options setTeleportSound(@Nullable SoundData teleportSound);

    /**
     * @return Whether an animation should be played after teleport or not.
     */
    boolean isAfterEffects();

    /**
     * @param afterEffects Whether an animation should be played after teleport or not.
     * @param force        Force updates the current value if there is already one. The current value will not be overwritten if force is set to false.
     * @return This options-instance.
     */
    @NotNull
    Options setAfterEffects(boolean afterEffects, boolean force);

    /**
     * @return Whether this teleport is already finished or not.
     */
    boolean expired();

    /**
     * @param callback A new callback which will be fired when the teleport will be finished or cancelled.
     * @return This options-instance.
     */
    @NotNull
    Options addCallback(@NotNull Callback<Result> callback);

    /**
     * @return The current pay message.
     */
    @Nullable
    String getPayMessage();

    /**
     * @param payMessage The new pay message.
     * @return This options-instance.
     */
    @NotNull
    Options setPayMessage(@Nullable String payMessage);

    /**
     * @param player The specific player.
     * @return The final message. This depends on whether the player must pay something or not. Includes {@link Options#getMessage()} and {@link Options#getPayMessage()}.
     */
    @Nullable
    String getFinalMessage(@NotNull Player player);

    /**
     * @return Whether the player should confirm the payment (if there is one) to start the teleport or not.
     */
    boolean isConfirmPayment();

    /**
     * @param confirmPayment Whether the player should confirm the payment (if there is one) to start the teleport or not.
     * @return This options-instance.
     */
    @NotNull
    Options setConfirmPayment(boolean confirmPayment);

    /**
     * @param player The specific player.
     * @return The message if the payment (if there was one) has been denied.
     */
    @Nullable
    String getPaymentDeniedMessage(@NotNull Player player);

    /**
     * @param paymentDeniedMessage The message if the payment (if there was one) has been denied.
     * @return This options-instance.
     */
    @NotNull
    Options setPaymentDeniedMessage(@Nullable String paymentDeniedMessage);

    /**
     * @return Whether there should be a teleport animation during teleport delay or not.
     */
    boolean isTeleportAnimation();

    /**
     * @param teleportAnimation Whether there should be a teleport animation during teleport delay or not.
     * @return This options-instance.
     */
    @NotNull
    Options setTeleportAnimation(boolean teleportAnimation);

    /**
     * @return The message that comes up if the target server is not online.
     */
    @Nullable
    String getServerNotOnline();

    /**
     * @param serverNotOnline The message that comes up if the target server is not online.
     * @return This options-instance.
     */
    @NotNull
    Options setServerNotOnline(@Nullable String serverNotOnline);

    /**
     * @return Whether the teleport animation will be shown for the entire server or just the teleporting player.
     */
    boolean isPublicAnimations();

    /**
     * @param publicAnimations Whether the teleport animation will be shown for the entire server or just the teleporting player.
     * @return This options-instance.
     */
    @NotNull
    Options setPublicAnimations(boolean publicAnimations);

    /**
     * @return The current cancel sound.
     */
    @Nullable
    SoundData getCancelSound();

    /**
     * @param cancelSound The new cancel sound.
     * @return This options-instance.
     */
    @NotNull
    Options setCancelSound(@Nullable SoundData cancelSound);

    /**
     * @param player The specific player.
     * @return The teleport delay for the given player. Might be zero if the player has the teleport delay bypass permission.
     */
    int getDelay(@NotNull Player player);

    /**
     * @param delay The new delay.
     */
    @NotNull
    Options setDelay(int delay);

    /**
     * @return Whether the player should recveive invulnerability after teleport or not.
     */
    boolean withPostInvulnerability();

    /**
     * @return The invulnerability time in seconds after teleport.
     */
    float postInvulnerabilityDuration();

    /**
     * PREMIUM-FEATURE This is a premium feature and therefore will not work if you are using the free version.
     *
     * @param withPostInvulnerability Whether the player should receive invulnerability after teleport or not.
     * @return This options-instance.
     */
    @NotNull
    Options setWithPostInvulnerability(boolean withPostInvulnerability);

    /**
     * PREMIUM-FEATURE This is a premium feature and therefore will not work if you are using the free version.
     *
     * @param postInvulnerabilityDuration The invulnerability time in seconds after teleport.
     * @return This options-instance.
     */
    @NotNull
    Options setPostInvulnerabilityDuration(float postInvulnerabilityDuration);
}
