package com.ExoMates.Hub.Events;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {
	
	@EventHandler
	public void onItemEvent(InventoryClickEvent e){
		if(e.getWhoClicked().getGameMode() == GameMode.CREATIVE){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	
}
