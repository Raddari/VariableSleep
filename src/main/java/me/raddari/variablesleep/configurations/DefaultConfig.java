package me.raddari.variablesleep.configurations;

import me.raddari.variablesleep.VariableSleep;
import org.bukkit.configuration.Configuration;

public final class DefaultConfig {
    
    private static final String DISABLE_PHANTOMS = "features.disable-phantoms";
    private static final String CLEAR_WEATHER = "features.clear-weather";
    private static final String SLEEP_PERCENT = "features.sleep-percent";
    private static final String TIME_SET = "features.time-set";
    
    private static final String ANNOUNCE_SLEEPING = "messages.announce-sleeping";
    private static final String ANNOUNCE_TIMEOUT = "messages.timeout";
    private static final String WAKE_UP_TEXT = "messages.wake-up-text";
    
    public static void init() {
        config().addDefault(DISABLE_PHANTOMS, false);
        config().addDefault(CLEAR_WEATHER, true);
        config().addDefault(SLEEP_PERCENT, 0.5D);
        config().addDefault(TIME_SET, 500L);
        
        config().addDefault(ANNOUNCE_SLEEPING, "&6[player] is now sleeping ([asleep]/[online]). [required] required to sleep.");
        config().addDefault(ANNOUNCE_TIMEOUT, 1000L);
        config().addDefault(WAKE_UP_TEXT, "&6Wakey wakey!");
        
        config().options().copyDefaults(true);
        
        VariableSleep.instance().saveConfig();
        VariableSleep.instance().saveDefaultConfig();
    }
    
    public static boolean disablePhantoms() {
        return config().getBoolean(DISABLE_PHANTOMS);
    }
    
    public static boolean clearWeather() {
        return config().getBoolean(CLEAR_WEATHER);
    }
    
    public static float sleepPercent() {
        return (float) config().getDouble(SLEEP_PERCENT);
    }
    
    public static long timeSet() {
        return config().getLong(TIME_SET);
    }
    
    public static String announceSleeping() {
        return config().getString(ANNOUNCE_SLEEPING);
    }
    
    public static long announceTimeout() {
        return config().getLong(ANNOUNCE_TIMEOUT);
    }
    
    public static String wakeUpText() {
        return config().getString(WAKE_UP_TEXT);
    }
    
    private static Configuration config() {
        return VariableSleep.instance().getConfig();
    }
    
    private DefaultConfig() {
    }
    
}
