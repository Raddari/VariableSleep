package me.raddari.variablesleep.listeners;

import me.raddari.variablesleep.configurations.DefaultConfig;
import me.raddari.variablesleep.VariableSleep;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.logging.Level;

public final class EntitySpawn implements Listener{
	
	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent event){
		if(event.getEntityType() == EntityType.PHANTOM){
			if(DefaultConfig.disablePhantoms()){
				event.setCancelled(true);
				
				Location loc = event.getEntity().getLocation();
				String coords = String.format("(%s, %s, %s)", loc.getX(), loc.getY(), loc.getZ());
				String msg = String.format("Phantom tried spawning at %s. Denied!", coords);
				VariableSleep.instance().logger.log(Level.FINE, msg);
			}
		}
	}
	
}
