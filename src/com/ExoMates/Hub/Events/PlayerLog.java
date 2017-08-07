package com.ExoMates.Hub.Events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;

import com.ExoMates.Hub.API;

public class PlayerLog implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		setupPlayer(p);
		e.setJoinMessage("");
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		
		if(API.editingPlayers.contains(p)){
			API.editingPlayers.remove(p);
		}
		e.setQuitMessage("");
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e){
		if(Bukkit.getOnlinePlayers().size() >= Bukkit.getMaxPlayers()){
			e.setResult(Result.KICK_FULL);
		}
	}
	
	
	private void setupPlayer(Player p){
		p.setGameMode(GameMode.ADVENTURE);
		p.getInventory().clear();
		p.teleport(API.HubLocation());
		p.setPlayerListName("§7" + p.getName());
		API.setupBasicInventory(p);
	}
	
}
