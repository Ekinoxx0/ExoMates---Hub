package com.ExoMates.Hub;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.ExoMates.Hub.Cmds.Admin;
import com.ExoMates.Hub.Cmds.HubLobby;
import com.ExoMates.Hub.Events.ArmorStand;
import com.ExoMates.Hub.Events.BlockListener;
import com.ExoMates.Hub.Events.BlockPhysic;
import com.ExoMates.Hub.Events.Damage;
import com.ExoMates.Hub.Events.EntityExplode;
import com.ExoMates.Hub.Events.FoodLevel;
import com.ExoMates.Hub.Events.Interact;
import com.ExoMates.Hub.Events.InventoryListener;
import com.ExoMates.Hub.Events.ItemDrop;
import com.ExoMates.Hub.Events.PickupItem;
import com.ExoMates.Hub.Events.PlayerLog;
import com.ExoMates.Hub.Events.PlayerMove;
import com.ExoMates.Hub.Events.Tchat;
import com.ExoMates.Hub.Events.Weather;
import com.ExoMates.Hub.MinecraftPing.MinecraftPingCommand;
import com.ExoMates.Specials.ServersInventory;

public class Hub extends JavaPlugin implements Listener {

	
	public static Plugin plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		setupServer();
		registerEvents();
		registerCmds();
		
		ServersInventory.scheduleServersInventory();
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void setupServer(){
		System.out.println("\033[33m+-----------------Hub------------------+\033[0m");
		System.out.println("\033[33m|       Plugin créé par Ekinoxx        |\033[0m");
		System.out.println("\033[33m|                 " + this.getDescription().getVersion() + "                  |\033[0m");
		System.out.println("\033[33m+--------------------------------------+\033[0m");
		
		World w = Bukkit.getWorld("hub");
		w.setGameRuleValue("commandBlockOutput", "false");
		w.setGameRuleValue("doDaylightCycle", "false");
		w.setGameRuleValue("doEntityDrops", "false");
		w.setGameRuleValue("doMobLoot", "false");
		w.setGameRuleValue("doMobSpawning", "false");
		w.setGameRuleValue("doTileDrops", "false");
		w.setGameRuleValue("keepInventory", "false");
		w.setGameRuleValue("logAdminCommands", "false");
		w.setGameRuleValue("mobGriefing", "false");
		w.setGameRuleValue("randomTickSpeed", "-1");
		w.setGameRuleValue("showDeathMessages", "false");
		
		w.setFullTime(6000L);
		w.setPVP(false);
		w.setStorm(false);
		w.setDifficulty(Difficulty.NORMAL);
		API.HubWorld = w;
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	}
	
	
	private void registerCmds(){
		getCommand("Admin").setExecutor(new Admin());
		getCommand("Hub").setExecutor(new HubLobby());
		getCommand("Lobby").setExecutor(new HubLobby());
		
		getCommand("McPing").setExecutor(new MinecraftPingCommand());
	}
	
	private void registerEvents(){
		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new ArmorStand(), this);
		pm.registerEvents(new BlockListener(), this);
		pm.registerEvents(new BlockPhysic(), this);
		pm.registerEvents(new Damage(), this);
		pm.registerEvents(new EntityExplode(), this);
		pm.registerEvents(new FoodLevel(), this);
		pm.registerEvents(new Interact(), this);
		pm.registerEvents(new InventoryListener(), this);
		pm.registerEvents(new ItemDrop(), this);
		pm.registerEvents(new PickupItem(), this);
		pm.registerEvents(new PlayerLog(), this);
		pm.registerEvents(new PlayerMove(), this);
		pm.registerEvents(new Tchat(), this);
		pm.registerEvents(new Weather(), this);
		
		pm.registerEvents(new ServersInventory(), this);
	}	
}
