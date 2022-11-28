package me.pokemichele.logdel8;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
@SuppressWarnings("unused")

public class LogDel8 extends JavaPlugin {
	
	public static LogDel8 plugin;
	
	
	//get plugin instance
	public static LogDel8 getInstance() {
		return plugin;
		
	}
	
	//define directory
	String MainDir = System.getProperty("user.dir");

	File LogDir = new File(MainDir+"/logs/");



	//OnEnable
	public void onEnable() {
		plugin = this;
		System.out.println("LogDel8 is now Enabled");
		getCommand("logdel").setExecutor(new LogDelCommand());

		
		//Load config.yml
		saveDefaultConfig();
		
		//Setting permissions to the file (+rwx)
	    LogDir.setReadable(true); //read
	    LogDir.setWritable(true); //write
	    LogDir.setExecutable(true); //execute

		if (plugin.getConfig().getBoolean("settings.enable-auto-remover") == true) {
			try {
				enableAutoRemover();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			return;
		}

	}

	//AutoRemover
	public void enableAutoRemover(){
		BukkitScheduler scheduler = getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				LogDelCommand.LogDelete();
			}
		}, 0L, plugin.getConfig().getInt("settings.time-between-log-removing-in-minutes")*1200L);

	}


	//OnDisable
	public void onDisable() {
		System.out.println("LogDel8 is now Disabled");
	}

	
}
