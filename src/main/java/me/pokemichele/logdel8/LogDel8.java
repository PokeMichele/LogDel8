package me.pokemichele.logdel8;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.io.FileUtils;
import org.bukkit.plugin.java.JavaPlugin;
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

	public void enableAutoRemover(){
		//delete Logs
		//wait 10 minutes or x minutes

		//


		//repeat
		enableAutoRemover();
	}

	
	//OnEnable
	public void onEnable() {
		plugin = this;
		System.out.println("LogDel8 is now Enabled");
		getCommand("logdel").setExecutor(new LogDelCommand());

		
		//crea cartella del config.yml
		saveDefaultConfig();
		
		//Setting permissions to the file
	    LogDir.setReadable(true); //read
	    LogDir.setWritable(true); //write
	    LogDir.setExecutable(true); //execute

		//enableAutoRemover();


	}
	
	//OnDisable
	public void onDisable() {
		System.out.println("LogDel8 is now Disabled");
	}

	
}
