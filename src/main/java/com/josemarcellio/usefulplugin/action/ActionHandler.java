package com.josemarcellio.usefulplugin.action;

import ac.grim.grimac.AbstractCheck;
import ac.grim.grimac.GrimUser;
import com.josemarcellio.usefulplugin.check.CheckManager;
import com.josemarcellio.usefulplugin.manager.PlayerData;
import com.josemarcellio.usefulplugin.manager.PlayerManager;

import java.util.Map;

public class ActionHandler {

    public static boolean userDetectedOrSuspicious(AbstractCheck check, String module) {
        Map<String, Double> checkViolationsMap = CheckManager.getCheckViolationsMap();
        return check.getCheckName().equals(module) && check.getViolations() >= checkViolationsMap.getOrDefault(module, 0.0);
    }

    public static void punish(GrimUser grimUser) {
        PlayerManager.putPlayerData(grimUser.getUniqueId(), new PlayerData(0));
    }
}