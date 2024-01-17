package com.josemarcellio.usefulplugin.check;

import java.util.HashMap;
import java.util.Map;

public class CheckManager {

    private static final Map<String, Double> CHECK_VIOLATIONS_MAP = initializeCheckViolationsMap();

    private static Map<String, Double> initializeCheckViolationsMap() {
        Map<String, Double> map = new HashMap<>();
        map.put("Simulation", 40.0);
        map.put("Knockback", 5.0);
        map.put("Post", 20.0);
        map.put("BadPackets", 20.0);
        map.put("Reach", 5.0);
        map.put("Misc", 5.0);
        map.put("Combat", 20.0);
        map.put("Autoclicker", 20.0);
        return map;
    }

    public static Map<String, Double> getCheckViolationsMap() {
        return CHECK_VIOLATIONS_MAP;
    }
}