package com.ExoMates.Specials;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.ExoMates.Hub.Hub;
import com.ExoMates.Hub.MinecraftPing.MinecraftPing;
import com.ExoMates.Hub.MinecraftPing.MinecraftPingOptions;
import com.ExoMates.Hub.MinecraftPing.MinecraftPingReply;

public class ServersInventory implements Listener{

	static Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§9§l» §6Les Parties §9§l«");
	static int secondsUntilUpdate = 30;
	
	private void serversInventory(Player p){
		updateServersInventory();
		p.openInventory(inv);
	}
	
	private static void updateServersInventory(){
		MinecraftPingReply data = null;
		try {
			data = new MinecraftPing().getPing(new MinecraftPingOptions().setHostname("localhost").setPort(20101));
			String desc = data.getDescription();
			ItemStack is1 = new ItemStack(Material.STAINED_CLAY, 1, (short) 5);
			ItemMeta isM1 = is1.getItemMeta();
			isM1.setDisplayName(" §6GAME-1 ");
			isM1.setLore(Arrays.asList("", "§2Disponible !", "  " + desc, ""));
			is1.setItemMeta(isM1);
			inv.setItem(2, is1);
		} catch (Exception e) {
			ItemStack is1 = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
			ItemMeta isM1 = is1.getItemMeta();
			isM1.setDisplayName(" §6GAME-1 ");
			isM1.setLore(Arrays.asList("", "§cIndisponible !", ""));
			is1.setItemMeta(isM1);
			inv.setItem(2, is1);
		}
		
	}
	
	public static void scheduleServersInventory(){
		if(inv != null){
			try{
				ItemStack is1 = new ItemStack(Material.BEACON);
				ItemMeta isM1 = is1.getItemMeta();
				isM1.setDisplayName(" ");
				is1.setItemMeta(isM1);
				
				inv.setItem(0, is1);
				inv.setItem(4, is1);
				
				Bukkit.getScheduler().scheduleSyncRepeatingTask(Hub.plugin, new Runnable() {
					
					@Override
					public void run() {
						updateServersInventory();
						
					}
				}, 0, secondsUntilUpdate * 20);
			}catch(Exception exp){
				Bukkit.getConsoleSender().sendMessage("§cCritical Error ServerInventory ! (General Scheduling)");
			}
			
		}else{
			Bukkit.getConsoleSender().sendMessage("§cCritical Error ServerInventory ! (Alpha)");
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		
		if(e.getItem() != null){
			ItemStack i = e.getItem();
			
			if(i.getType() == Material.BANNER){
				serversInventory(p);
			}
		}
		
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		
	}
	
}
