package me.pokemichele.logdel8;

import org.apache.commons.io.FileUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

import static me.pokemichele.logdel8.LogDel8.plugin;

public class LogDelCommand implements CommandExecutor{

	//define directory
	static String MainDir = plugin.getServer().getWorldContainer().getAbsolutePath();
	static File LogDir = new File(MainDir+"/logs/");

	//Delete Logs Method
	public static void LogDelete() {

		// TODO Auto-generated method stub

		System.out.println("Your Server Files Location is: " + MainDir);

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
		System.out.println("Logs Removed :D");

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		Player player = (Player) sender;

		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("logdel")) {

				LogDelete();

			}
		} else{
			System.out.println("You can't execute this command from console");
		}
		
		return false;
	}
	
	
	

}
