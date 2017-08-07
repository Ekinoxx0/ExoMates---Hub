package com.ExoMates.Hub.Events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import com.ExoMates.Hub.API;

public class Damage implements Listener {

	@EventHandler
	public void onDamageEvent(EntityDamageEvent e){
		if(e.getEntityType() == EntityType.PLAYER){
			e.setCancelled(true);
			if(e.getCause() == DamageCause.VOID){
				e.getEntity().teleport(API.HubLocation());
			}
		}
		
	}
	
}
