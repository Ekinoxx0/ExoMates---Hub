package com.ExoMates.Hub.Cmds;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ExoMates.Hub.API;

public class Admin implements CommandExecutor {

	String s = "§cUsage: /admin <edit>";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("Admin")){
			if(args.length == 0){
				sender.sendMessage(s);
			}else if(args.length == 1){
				if(args[0].equalsIgnoreCase("edit")){
					sender.sendMessage("§cUsage: /admin <edit> <player>");
				}else{
					sender.sendMessage(s);
				}
			}else if(args.length == 2){
				if(args[0].equalsIgnoreCase("edit")){
					try{
						boolean b = false;
						for(Player allP : Bukkit.getOnlinePlayers()){
							if(allP.getName().equalsIgnoreCase(args[1])){
								b = true;
								break;
							}
						}
						
						if(b){
							Player p = Bukkit.getPlayer(args[1]);
							if(!API.editingPlayers.contains(p)){
								API.editingPlayers.add(p);
								p.sendMessage(API.MessageOK + "§2Vous pouvez maintenant éditer le hub !");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.setGameMode(GameMode.CREATIVE);
							}else{
								API.editingPlayers.remove(p);
								p.sendMessage(API.MessageNO + "§cVous ne pouvez plus éditer le hub !");
								p.setGameMode(GameMode.ADVENTURE);
							}
						}else{
							sender.sendMessage("§cUsage: /admin <edit> <player>");
						}
					}catch(Exception exp){
						sender.sendMessage("");
					}
				}else{
					sender.sendMessage(s);
				}
			}else{
				sender.sendMessage(s);
			}
		}
		
		return false;
	}

}
