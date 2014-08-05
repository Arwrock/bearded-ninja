package com.arwrock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	File businesses = new File("businesses.yml");
	FileConfiguration businessConfig = YamlConfiguration
			.loadConfiguration(businesses);
	ConfigurationSection names = businessConfig
			.getConfigurationSection("businesses");
	List<String> businessesSaved;
	public int businessNumber;

	public void onEnable() {
		if (!businesses.exists()) {
			try {
				businesses.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("bc")) {
			if(args.length == 3){
				if(args[0].equalsIgnoreCase("dba")){
					int compID = Integer.parseInt(args[1]);
				}
			}
			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("create")) {
					if (sender instanceof Player) {
						if (args[1].equalsIgnoreCase("scorp")) {
							return true;
						}
						if (args[1].equalsIgnoreCase("ccorp")) {
							return true;
						}
						if (args[1].equalsIgnoreCase("llc")) {
							return true;
						}
						if (args[1].equalsIgnoreCase("sp")) {
							
							if(args[2] != null){
								businessConfig.set(businessNumber+++"."+args[2]+"'s Company",sender.getName());
								return true;
							}
							
							businessConfig.set( businessNumber+++"."+sender.getName()+"'s Company",sender.getName());
							
							try {
								businessConfig.save(businesses);
							} catch (IOException e) {
								
								e.printStackTrace();
							}
							return true;
						}
						if (args[1].equalsIgnoreCase("gp")) {
							// All of these will soon be filled.
							return true;
						}
						if (args[1].equalsIgnoreCase("llp")) {
							return true;
						}
					} else {
						sender.sendMessage("This command is for players only!");
						return true;
					}
				}
			}
			if(args.length == 1){
				
			}
		}

		return false;

	}
}
