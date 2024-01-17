package com.josemarcellio.usefulplugin.manager;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {

    private static final HashMap<UUID, PlayerData> playerDataMap = new HashMap<>();

    public static void putPlayerData(UUID uuid, PlayerData playerData) {
        playerDataMap.put(uuid, playerData);
    }

    public static void removePlayerData(UUID uuid) {
        playerDataMap.remove(uuid);
    }

    public static PlayerData getPlayerData(UUID uuid) {
        return playerDataMap.get(uuid);
    }
}
