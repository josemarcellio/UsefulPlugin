package com.josemarcellio.usefulplugin.listener;

import ac.grim.grimac.AbstractCheck;
import ac.grim.grimac.GrimUser;
import ac.grim.grimac.events.FlagEvent;
import com.josemarcellio.usefulplugin.action.ActionHandler;
import com.josemarcellio.usefulplugin.check.CheckManager;
import com.josemarcellio.usefulplugin.manager.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class AntiCheatListener implements Listener {


    @EventHandler
    public void onFlag(FlagEvent event) {

        GrimUser user = event.getPlayer();
        AbstractCheck check = event.getCheck();

        String[] modules = CheckManager.getCheckViolationsMap().keySet().toArray(new String[0]);

        for (String module : modules) {
            if (ActionHandler.userDetectedOrSuspicious(check, module)) {
                ActionHandler.punish(user);
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        PlayerManager.removePlayerData(player.getUniqueId());
    }
}
