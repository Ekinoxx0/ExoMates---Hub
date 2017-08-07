package com.ExoMates.Hub.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevel implements Listener {
	
	@EventHandler
	public void onPlayerFoodLevelChangeEvent(FoodLevelChangeEvent e){
		e.setCancelled(true);
		e.setFoodLevel(20);
	}
	
}
