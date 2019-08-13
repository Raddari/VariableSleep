package me.raddari.variablesleep;

import me.raddari.variablesleep.commands.CommandHandler;
import me.raddari.variablesleep.configurations.DefaultConfig;
import me.raddari.variablesleep.listeners.EntitySpawn;
import me.raddari.variablesleep.listeners.PlayerBedEnter;
import me.raddari.variablesleep.listeners.PlayerBedLeave;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public final class VariableSleep extends JavaPlugin {
    
    public static final Map<World, Integer> worlds = new HashMap<>();
    
    private static VariableSleep instance;
    public final Logger logger = getLogger();
    
    public VariableSleep() {
        super();
        instance = this;
    }
    
    @Override
    public void onEnable() {
        setupListeners();
        DefaultConfig.init();
        
        for (World w : Bukkit.getServer().getWorlds()) {
            worlds.put(w, 0);
        }
        
        getCommand("variablesleep").setExecutor(new CommandHandler());
    }
    
    @Override
    public void onDisable() {
        // Kick people out of bed
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.damage(0.00001D);
        }
        worlds.clear();
    }
    
    private void setupListeners() {
        Listener[] listeners = {
                new EntitySpawn(),
                new PlayerBedEnter(),
                new PlayerBedLeave()
        };
        
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }
    
    public static void fixWorldMap(World world) {
		if (VariableSleep.worlds.get(world) < 0) {
			VariableSleep.worlds.put(world, 0);
		}
    }
    
    public static VariableSleep instance() {
        return instance;
    }
    
    public static String prefix() {
        return "&7[&6VariableSleep&7]";
    }
}
