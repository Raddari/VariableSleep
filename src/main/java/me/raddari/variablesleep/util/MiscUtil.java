package me.raddari.variablesleep.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;

public final class MiscUtil{
	
	/**
	 * Given a {@link Map} of the form {@code Map<K, Integer>}, modifies the value of the
	 * specified key to be increased (or decreased) by mod.
	 *
	 * @param map the map to modify
	 * @param key the key to change the value of
	 * @param mod modify the the value by this amount
	 * @param <K> the type of the map keys
	 * @return {@code true} if the map contained the key, {@code false} otherwise
	 */
	public static <K> boolean modifyMapCount(Map<K, Integer> map, K key, int mod){
		if(map.containsKey(key)){
			map.put(key, map.get(key) + mod);
			return true;
		}
		return false;
	}
	
	public static <T extends Player> void messagePlayers(List<T> players, String message){
		for(T player : players){
			player.sendMessage(message);
		}
	}
	
	public static String format(String text){
		if(text == null || text.trim().equals("")){
			return "";
		}else{
			return ChatColor.translateAlternateColorCodes('&', text);
		}
	}
	
}
