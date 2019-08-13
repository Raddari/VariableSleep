package me.raddari.variablesleep.listeners;

import me.raddari.variablesleep.VariableSleep;
import me.raddari.variablesleep.util.MiscUtil;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public final class PlayerBedLeave implements Listener {
    
    @EventHandler
    public void onPlayerBedLeave(PlayerBedLeaveEvent event) {
        World world = event.getPlayer().getWorld();
        MiscUtil.modifyMapCount(VariableSleep.WORLDS, world, -1);
        VariableSleep.fixWorldMap(world);
    }
    
}
