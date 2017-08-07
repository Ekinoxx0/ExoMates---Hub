package com.ExoMates.Hub;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class API {

	public static String ServerName = "ExoCraft";
	public static String ServerPlatformName = "ExoCord";
	
	public static String A1 = "➠";
	public static String A2 = "▸";
	
	public static String MessageOK = "§9[§2" + "✔" + "§9] §r";
	public static String MessageNO = "§9[§c" + "✖" + "§9] §r";
	public static String MessageGO = "§9[§1➠§9] §r";
	public static String MessageLOAD = "§9[§5§l" + "🔄" + "§9] §r";
	
	public static String noPerms = "§cTu n'as pas la permission !";
	
	
	public static World HubWorld = null;
	public static Location HubLocation(){
		return new Location(Bukkit.getWorld("hub"), 0.5, 100, 0.5);
	}
	

	public static ArrayList<Player> editingPlayers = new ArrayList<>();
	
	
	public static void setupBasicInventory(Player p){
		PlayerInventory inv = p.getInventory();
		
		inv.clear();
		inv.setBoots(new ItemStack(Material.AIR));
		inv.setLeggings(new ItemStack(Material.AIR));
		inv.setChestplate(new ItemStack(Material.AIR));
		inv.setHelmet(new ItemStack(Material.AIR));
		
		ItemStack banner = new ItemStack(Material.BANNER);
		ItemMeta bannerM = banner.getItemMeta();
		bannerM.setDisplayName("§9§l» §6Sélections des Parties §9§l«");
		banner.setItemMeta(bannerM);
		
		
		inv.setItem(4, banner);
	}
	
}
