package com.ExoMates.Hub.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {
	
	@EventHandler
	public void onMoveEvent(PlayerMoveEvent e){
		
		e.getPlayer().setFallDistance(0);
		
	}
	
}
