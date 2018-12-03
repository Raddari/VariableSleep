package me.raddari.variablesleep.listeners;

import me.raddari.variablesleep.configurations.DefaultConfig;
import me.raddari.variablesleep.VariableSleep;
import me.raddari.variablesleep.util.MiscUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import java.util.Map;
import java.util.Set;

public final class PlayerBedEnter implements Listener{
	
	@EventHandler
	public void onPlayerBedEnter(PlayerBedEnterEvent event){
		if(event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK){
			Player player = event.getPlayer();
			World world = player.getWorld();
			
			// Increment the amount of sleeping players in the world
			MiscUtil.modifyMapCount(VariableSleep.worlds, world, 1);
			
			int online = Bukkit.getServer().getWorld(world.getName()).getPlayerCount();
			int sleeping = VariableSleep.worlds.get(world);
			float sleepingPercent = (float) sleeping / online;
			int required = Math.round(online * DefaultConfig.sleepPercent());
			
			Bukkit.getServer().broadcastMessage(MiscUtil.format(DefaultConfig.announceSleeping())
														.replace("[player]", player.getDisplayName())
														.replace("[asleep]", String.valueOf(sleeping))
														.replace("[online]", String.valueOf(online))
														.replace("[required]", String.valueOf(required)));
			
			if(sleepingPercent >= DefaultConfig.sleepPercent()){
				world.setTime(DefaultConfig.timeSet());
				Bukkit.getServer().broadcastMessage(MiscUtil.format(DefaultConfig.wakeUpText()));
			}
			if(DefaultConfig.clearWeather()){
				world.setThundering(false);
				world.setStorm(false);
			}
			
			VariableSleep.fixWorldMap(world);
		}
	}
}
