package me.pokemichele.logdel8;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

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

		
		//crea cartella del config.yml
		saveDefaultConfig();
		
		//Setting permissions to the file (+rwx)
	    LogDir.setReadable(true); //read
	    LogDir.setWritable(true); //write
	    LogDir.setExecutable(true); //execute

		try {
			enableAutoRemover();
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}

	}



	public static void enableAutoRemover( ) throws SchedulerException {
		//delete Logs
		//wait 10 minutes
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();

		JobDetail job = newJob(AutoRemover.class)
				.withIdentity("auto-remover")
				.build();

		SimpleTrigger trigger = newTrigger().withIdentity("trigger1")
				.startNow()
				.withSchedule(simpleSchedule().withIntervalInMinutes(10).repeatForever())
				.build();
		scheduler.scheduleJob(job, trigger);
	}
	public static class AutoRemover implements Job {
		@Override
		public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
			LogDelCommand.LogDelete();
		}

	}


	
	//OnDisable
	public void onDisable() {
		System.out.println("LogDel8 is now Disabled");
	}

	
}
