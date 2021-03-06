package me.raddari.variablesleep.listeners;

import me.raddari.variablesleep.VariableSleep;
import me.raddari.variablesleep.configurations.DefaultConfig;
import me.raddari.variablesleep.util.MiscUtil;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import java.util.List;

public final class PlayerBedEnter implements Listener {
    
    private static long lastAnnounce = System.currentTimeMillis();
    
    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
        if (event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {
            World world = event.getPlayer().getWorld();
            
            // Increment the amount of sleeping players in the world
            MiscUtil.modifyMapCount(VariableSleep.WORLDS, world, 1);
            
            List<Player> players = Bukkit.getServer().getWorld(world.getName()).getPlayers();
            int online = players.size();
            int sleeping = VariableSleep.WORLDS.get(world);
            float sleepingPercent = (float) sleeping / online;
            int required = Math.round(online * DefaultConfig.sleepPercent());
            
            String msg = MiscUtil.format(DefaultConfig.announceSleeping())
                                 .replace("[player]", event.getPlayer().getDisplayName())
                                 .replace("[online]", String.valueOf(online))
                                 .replace("[asleep]", String.valueOf(sleeping))
                                 .replace("[asleep%]", String.valueOf(sleepingPercent))
                                 .replace("[required]", String.valueOf(required))
                                 .replace("[required%]", String.valueOf(DefaultConfig.sleepPercent()));
            
            if (System.currentTimeMillis() - lastAnnounce > DefaultConfig.announceTimeout()) {
                MiscUtil.messagePlayers(players, msg);
            }
            if (sleepingPercent >= DefaultConfig.sleepPercent()) {
                world.setTime(DefaultConfig.timeSet());
                MiscUtil.messagePlayers(players, MiscUtil.format(DefaultConfig.wakeUpText()));
            }
            if (DefaultConfig.clearWeather()) {
                world.setThundering(false);
                world.setStorm(false);
            }
            
            VariableSleep.fixWorldMap(world);
        }
    }
}
