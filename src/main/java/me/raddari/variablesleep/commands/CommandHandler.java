package me.raddari.variablesleep.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public final class CommandHandler implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if(args.length > 0){
			if(args[0].equalsIgnoreCase("reload")){
				ReloadCommand.reloadConfig(sender);
				return true;
			}
		}
		
		return false;
	}
}
