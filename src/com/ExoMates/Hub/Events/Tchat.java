package com.ExoMates.Hub.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Tchat implements Listener {
	
	@EventHandler
	public void onItemEvent(AsyncPlayerChatEvent e){
		e.setFormat("§7§l%s§7 : %s");
	}
	
}
