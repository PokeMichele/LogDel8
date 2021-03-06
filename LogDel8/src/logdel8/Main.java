package logdel8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.*; 
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandExecutor;
@SuppressWarnings("unused")

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	
	//get plugin instance
	public static Main getInstance() {
		return plugin;
		
	}
	
	//define directory
	File LogDir = new File("/logs/");
	
	
	//Delete Logs Method
	public void LogDelete() {
		
		// TODO Auto-generated method stub
        
		
		//log file remove
		System.out.println("Removing Logs....");
        
		
		if(LogDir.exists()) {
	        try {
				FileUtils.cleanDirectory(LogDir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

        //wait 10 minutes or x minutes
        try {
            Thread.sleep(Main.getInstance().getConfig().getInt("settings.time-between-log-removing-in-ms"));
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
       System.out.println("Logs Removed :D");
       
       //repeat
       LogDelete();
       
		
	} 
	
	
	

	//OnEnable
	public void onEnable() {
		plugin = this;
		System.out.println("LogDel8 is now Enabled");
		
		//crea cartella del config.yml
		saveDefaultConfig();
		
		this.getClassLoader();
		
		//Setting permissions to the file
	    LogDir.setReadable(true); //read
	    LogDir.setWritable(true); //write
	    LogDir.setExecutable(true); //execute
		
		//delete Logs
		//wait 10 minutes or x minutes
        try {
            Thread.sleep(Main.getInstance().getConfig().getInt("settings.time-between-log-removing-in-ms"));
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
		LogDelete();
		
		
	}
	
	//OnDisable
	public void onDisable() {
		System.out.println("LogDel8 is now Disabled");
	}

	
}
