package com.amirparsa.survival;

import com.amirparsa.survival.data.CommandData;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

public class Config {

    private FileConfiguration config;
    public int MAX_PLAYERS;
    public String SERVER_NAME;
    public boolean PVP;
    public boolean ADS;
    public int SERVER_RESTART_SECONDS;
    public String SERVER_DESC;

    public HashMap<String, CommandData> COMMANDS = new HashMap<>();

    public void loadConfigValues(){
        MAX_PLAYERS = config.getInt("max-players", 5);
        SERVER_NAME = config.getString("server-id", "Unknown");
        PVP = config.getBoolean("pvp", false);
        ADS = config.getBoolean("enable-ads", true);
        SERVER_RESTART_SECONDS = config.getInt("restart-delay", 40000);
        SERVER_DESC = config.getString("server-desc", "Broken Config!");

        ConfigurationSection commandsSection = config.getConfigurationSection("commands");
        assert commandsSection != null;
        for(String key : commandsSection.getKeys(false)){
            ConfigurationSection command = commandsSection.getConfigurationSection(key);
            CommandData commandData = new CommandData();

            if(command.getString("permission") != null) commandData.setPermission(command.getString("permission"));
            commandData.setEnabled(command.getBoolean("enabled"));

            COMMANDS.put(key, commandData);
        }
    }

    public Config(FileConfiguration serverConfig){
        config = serverConfig;
        loadConfigValues();
    }
    public void reloadConfig(FileConfiguration reloadedConfig){
        config = reloadedConfig;
        loadConfigValues();
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
