package com.ExoMates.Hub.Events;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickupItem implements Listener {
	
	@EventHandler
	public void onItemEvent(PlayerPickupItemEvent e){
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	
}
