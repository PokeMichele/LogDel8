package logdel8;

import java.io.File;
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
	
	//define directory
	File LogDir = new File("/logs/");
	
	
	
	//Delete Logs
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
		

        
        //wait 10 minutes
        try {
            Thread.sleep(600000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
       System.out.println("Logs Removed :D");
       
       //repeat
       LogDelete();
       
		
	} 
	
	
	
	
	
	
	public void onEnable() {
		plugin = this;
		System.out.println("LogDel8 is now Enabled");
		saveDefaultConfig();
		
		this.getClassLoader();
		
		LogDelete();
		
		
	}
	
	public void onDisable() {
		System.out.println("LogDel8 is now Disabled");
	}

	public static Main getInstance() {
		return plugin;
		
	}

	
}
