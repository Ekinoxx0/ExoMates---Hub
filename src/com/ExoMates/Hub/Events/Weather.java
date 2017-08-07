package com.ExoMates.Hub.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Weather implements Listener {

	@EventHandler
	public void onItemEvent(WeatherChangeEvent e){
		e.setCancelled(true);
		e.getWorld().setThundering(false);
	}
	
}
