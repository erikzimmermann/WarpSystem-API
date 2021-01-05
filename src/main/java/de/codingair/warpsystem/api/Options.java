package de.codingair.warpsystem.api;

import de.codingair.codingapi.server.sounds.SoundData;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Options {
    private int mask = 0;

    private final IDestination destination;
    private final String displayName;
    private String permission;
    private Double costs;
    private Integer delay;
    private Vector randomOffset;

    private Boolean skip;
    private Boolean canMove;
    private Boolean waitForTeleport;
    private Boolean confirmPayment;

    private String payMessage;
    private String paymentDeniedMessage;
    private String message;
    private String serverNotOnline;

    private SoundData teleportSound;
    private SoundData cancelSound;

    private Boolean afterEffects;
    private Boolean publicAnimations;
    private Boolean teleportAnimation;

    private Options(@NotNull IDestination destination, @NotNull String displayName) {
        this.destination = destination;
        this.displayName = displayName;
    }

    public @NotNull IDestination getDestination() {
        return destination;
    }

    public @NotNull String displayName() {
        return displayName;
    }

    public String permission(String def) {
        if(modified(0)) return def;
        return permission;
    }

    public Double costs(double def) {
        if(modified(1)) return def;
        return costs;
    }

    public Integer delay(int def) {
        if(modified(2)) return def;
        return delay;
    }

    public Vector randomOffset(Vector def) {
        if(modified(3)) return def;
        return randomOffset;
    }

    public Boolean skip(boolean def) {
        if(modified(4)) return def;
        return skip;
    }

    public Boolean canMove(boolean def) {
        if(modified(5)) return def;
        return canMove;
    }

    public Boolean waitForTeleport(boolean def) {
        if(modified(6)) return def;
        return waitForTeleport;
    }

    public Boolean confirmPayment(boolean def) {
        if(modified(7)) return def;
        return confirmPayment;
    }

    public String payMessage(String def) {
        if(modified(8)) return def;
        return payMessage;
    }

    public String paymentDeniedMessage(String def) {
        if(modified(9)) return def;
        return paymentDeniedMessage;
    }

    public String message(String def) {
        if(modified(10)) return def;
        return message;
    }

    public String serverNotOnline(String def) {
        if(modified(11)) return def;
        return serverNotOnline;
    }

    public SoundData teleportSound(SoundData def) {
        if(modified(12)) return def;
        return teleportSound;
    }

    public SoundData cancelSound(SoundData def) {
        if(modified(13)) return def;
        return cancelSound;
    }

    public Boolean afterEffects(boolean def) {
        if(modified(14)) return def;
        return afterEffects;
    }

    public Boolean publicAnimations(boolean def) {
        if(modified(15)) return def;
        return publicAnimations;
    }

    public Boolean teleportAnimation(boolean def) {
        if(modified(16)) return def;
        return teleportAnimation;
    }

    private boolean modified(int index) {
        return ((this.mask >> index) & 1) != 1;
    }

    private void modify(int index) {
        this.mask |= (1 << index);
    }

    /**
     * All unmodified values will be replaced with default values of the WarpSystem configuration.
     * @param destination The used destination.
     * @return A new builder instance.
     */
    public static Builder newBuilder(@NotNull IDestination destination, @NotNull String displayName) {
        return new Builder(destination, displayName);
    }

    public static class Builder {
        private final Options options;

        private Builder(@NotNull IDestination destination, @NotNull String displayName) {
            this.options = new Options(destination, displayName);
        }

        /**
         * @param permission Permission which will be checked by WarpSystem.
         */
        public Builder permission(@Nullable String permission) {
            options.permission = permission;
            options.modify(1);
            return this;
        }

        /**
         * @param costs Costs to pay for this teleportation.
         */
        public Builder costs(double costs) {
            if(costs < 0) throw new IllegalArgumentException("Costs must be >= 0. Was: " + costs);
            options.costs = costs;
            options.modify(2);
            return this;
        }

        /**
         * @param delay The delay for the teleportation process.
         */
        public Builder delay(int delay) {
            if(delay < 0) throw new IllegalArgumentException("Delay must be >= 0. Was: " + delay);
            options.delay = delay;
            options.modify(3);
            return this;
        }

        /**
         * @param randomOffset A random offset which can be applied to the destination's location.
         */
        public Builder randomOffset(@NotNull Vector randomOffset) {
            options.randomOffset = randomOffset;
            options.modify(4);
            return this;
        }

        /**
         * @param skip Can be enabled if the player should skip the teleportation waiting process.
         */
        public Builder skip(boolean skip) {
            options.skip = skip;
            options.modify(5);
            return this;
        }

        /**
         * @param canMove Describes whether the player is able to move during the waiting process of this teleportation.
         */
        public Builder canMove(boolean canMove) {
            options.canMove = canMove;
            options.modify(6);
            return this;
        }

        /**
         * @param waitForTeleport If enabled and this teleportation will be executed while the player is moving, the player will be notified to stand still to get teleported.
         */
        public Builder waitForTeleport(boolean waitForTeleport) {
            options.waitForTeleport = waitForTeleport;
            options.modify(7);
            return this;
        }

        /**
         * @param confirmPayment When enabled, the player must confirm the payment (when costs > 0) by toggle sneaking.
         */
        public Builder confirmPayment(boolean confirmPayment) {
            options.confirmPayment = confirmPayment;
            options.modify(8);
            return this;
        }

        /**
         * @param payMessage The pay message. Contains following placeholders: %warp%, %AMOUNT% and %player%
         */
        public Builder payMessage(@Nullable String payMessage) {
            options.payMessage = payMessage;
            options.modify(9);
            return this;
        }

        /**
         * @param paymentDeniedMessage The message when the player denies the payment. Contains following placeholders: %AMOUNT%
         */
        public Builder paymentDeniedMessage(@Nullable String paymentDeniedMessage) {
            options.paymentDeniedMessage = paymentDeniedMessage;
            options.modify(10);
            return this;
        }

        /**
         * @param message The teleport message. Contains following placeholders: %warp% and %player%
         */
        public Builder message(@Nullable String message) {
            options.message = message;
            options.modify(11);
            return this;
        }


        /**
         * @param serverNotOnline An error message when target server is not online (destination specific).
         */
        public Builder serverNotOnline(@Nullable String serverNotOnline) {
            options.serverNotOnline = serverNotOnline;
            options.modify(12);
            return this;
        }

        /**
         * @param teleportSound Sound when the player will be teleported.
         */
        public Builder teleportSound(@Nullable SoundData teleportSound) {
            options.teleportSound = teleportSound;
            options.modify(13);
            return this;
        }

        /**
         * @param cancelSound Sound when the teleportation will be cancelled.
         */
        public Builder cancelSound(@Nullable SoundData cancelSound) {
            options.cancelSound = cancelSound;
            options.modify(14);
            return this;
        }

        /**
         * @param afterEffects Particle effects when completing the teleportation.
         */
        public Builder afterEffects(boolean afterEffects) {
            options.afterEffects = afterEffects;
            options.modify(15);
            return this;
        }

        /**
         * @param publicAnimations Decided whether all particle effects should be visible for all online players in range.
         */
        public Builder publicAnimations(boolean publicAnimations) {
            options.publicAnimations = publicAnimations;
            options.modify(16);
            return this;
        }

        /**
         * @param teleportAnimation If enabled, teleport animation particles will be shown.
         */
        public Builder teleportAnimation(boolean teleportAnimation) {
            options.teleportAnimation = teleportAnimation;
            options.modify(17);
            return this;
        }

        public Options build() {
            return options;
        }
    }
}
