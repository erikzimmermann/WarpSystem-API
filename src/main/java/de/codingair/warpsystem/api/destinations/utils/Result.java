package de.codingair.warpsystem.api.destinations.utils;

public enum Result {
    SUCCESS,
    CANCELLED,
    DESTINATION_DOES_NOT_EXIST,
    WORLD_DOES_NOT_EXIST,
    NOT_ENOUGH_MONEY,
    NO_PERMISSION,
    SERVER_NOT_AVAILABLE,
    CANCELLED_BY_SYSTEM,
    CANCELLED_BY_EXTERNAL,
    NO_CONNECTED_PROXY,
    ERROR,
    ALREADY_ON_TARGET_SERVER,
    TARGET_SERVER_IS_FULL,
    NO_ADAPTER,
    DENIED_PAYMENT,
    DISCONNECT,
    REMAINING_COOLDOWN
}
