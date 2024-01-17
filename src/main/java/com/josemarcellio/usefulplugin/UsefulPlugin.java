package com.josemarcellio.usefulplugin;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import com.josemarcellio.usefulplugin.listener.AntiCheatListener;
import com.josemarcellio.usefulplugin.listener.PacketSendReceiveListener;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import org.bukkit.plugin.java.JavaPlugin;

public class UsefulPlugin extends JavaPlugin {

    @Override
    public void onLoad() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().getSettings().reEncodeByDefault(false)
                .checkForUpdates(false)
                .bStats(false);
        PacketEvents.getAPI().load();
    }

    @Override
    public void onEnable() {

        PacketEvents.getAPI().getEventManager().registerListener(new PacketSendReceiveListener(),
                PacketListenerPriority.LOW);

        PacketEvents.getAPI().init();

        getServer().getPluginManager().registerEvents(new AntiCheatListener(), this);
    }

    @Override
    public void onDisable() {
        PacketEvents.getAPI().terminate();
    }
}
