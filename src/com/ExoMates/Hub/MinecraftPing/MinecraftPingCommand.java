package com.ExoMates.Hub.MinecraftPing;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class MinecraftPingCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strgs) {
		
		if(label.equalsIgnoreCase("mcping")){
			if(strgs.length == 2){
				MinecraftPingReply data = null;
				
				try {
					data = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname(strgs[0]).setPort(Integer.parseInt(strgs[1])));
				} catch (Exception e) {
					sender.sendMessage("§cErreur...");
				}
				
				try{
					sender.sendMessage("§6§lMOTD : " + data.getDescription());
					sender.sendMessage("§6§lJoueurs en ligne : §7" + data.getPlayers().getOnline());
					sender.sendMessage("§6§lJoueurs Max : §7" + data.getPlayers().getMax());
				}catch(Exception e){}
				
			}else{
				sender.sendMessage("§cUsage: /mcping <IP> <PORT>");
			}
		}
		
		return false;
	}
	
	
	
}
