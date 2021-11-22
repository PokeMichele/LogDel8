package logdel8;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LogDelCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("logdel")) {
			
			Main.getInstance().LogDelete();
			
		}
		
		
		return false;
	}
	
	
	

}
