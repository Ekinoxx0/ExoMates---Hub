package com.ExoMates.Hub.Cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ExoMates.Hub.API;

public class HubLobby implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("lobby") || label.equalsIgnoreCase("lobby")){
			Player p = (Player) sender;
			p.teleport(API.HubLocation());
		}
		
		return false;
	}
	
}
