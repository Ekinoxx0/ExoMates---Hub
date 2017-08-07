package com.ExoMates.Hub.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityExplode implements Listener {
	
	@EventHandler
	public void entityExplodeE(EntityExplodeEvent e){
		e.setCancelled(true);
	}
	
}
