package com.ExoMates.Hub.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

import com.ExoMates.Hub.API;

public class ArmorStand implements Listener {
	
	@EventHandler
    public void onArmorStand(PlayerArmorStandManipulateEvent e){
		
		if(API.editingPlayers.contains(e.getPlayer())){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		
    }
	
}
