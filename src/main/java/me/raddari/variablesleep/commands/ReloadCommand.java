package me.raddari.variablesleep.commands;

import me.raddari.variablesleep.VariableSleep;
import me.raddari.variablesleep.util.MiscUtil;
import org.bukkit.command.CommandSender;

public class ReloadCommand{
	
	public static void reloadConfig(CommandSender sender){
		VariableSleep.instance().reloadConfig();
		sender.sendMessage(MiscUtil.format(VariableSleep.prefix() + " &aConfig reloaded!"));
	}
	
}
