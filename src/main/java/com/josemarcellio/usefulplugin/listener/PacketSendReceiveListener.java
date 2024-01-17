package com.josemarcellio.usefulplugin.listener;

import com.github.retrooper.packetevents.event.PacketListener;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.player.User;
import com.josemarcellio.usefulplugin.manager.PlayerData;
import com.josemarcellio.usefulplugin.manager.PlayerManager;

import java.util.UUID;

public class PacketSendReceiveListener implements PacketListener {

    @Override
    public void onPacketSend(PacketSendEvent event) {
        User user = event.getUser();
        UUID uuid = user.getUUID();
        PlayerData playerData = PlayerManager.getPlayerData(uuid);

        if (playerData != null) {
            event.setCancelled(true);
        }
    }

    @Override
    public void onPacketReceive(PacketReceiveEvent event) {
        User user = event.getUser();
        UUID uuid = user.getUUID();
        PlayerData playerData = PlayerManager.getPlayerData(uuid);

        if (playerData != null) {
            event.setCancelled(true);
        }
    }
}
