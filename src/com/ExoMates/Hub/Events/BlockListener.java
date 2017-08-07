package com.ExoMates.Hub.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import com.ExoMates.Hub.API;

public class BlockListener implements Listener {
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e){
		
		if(API.editingPlayers.contains(e.getPlayer())){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		
		if(API.editingPlayers.contains(e.getPlayer())){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		
	}
	
}
