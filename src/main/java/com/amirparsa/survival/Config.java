package com.amirparsa.survival;

import com.amirparsa.survival.commands.CommandData;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Objects;

public class Config {

    private FileConfiguration config;
    public int MAX_PLAYERS;
    public String SERVER_NAME;
    public boolean PVP;
    public boolean ADS;
    public int SERVER_RESTART_SECONDS;
    public String SERVER_DESC;
    public boolean CUSTOM_PVP_MESSAGES;
    public boolean CUSTOM_MOTD;
    public int SERVER_RESTART_ALERT_SECONDS;

    public HashMap<String, CommandData> COMMANDS = new HashMap<>();

    public void loadConfigValues(){
        MAX_PLAYERS = config.getInt("max-players", 5);
        SERVER_NAME = config.getString("server-id", "Unknown");
        PVP = config.getBoolean("pvp", true);
        CUSTOM_PVP_MESSAGES = config.getBoolean("custom-pvp-messages", true);
        ADS = config.getBoolean("enable-ads", true);
        SERVER_RESTART_SECONDS = config.getInt("restart-delay", 30000);
        SERVER_RESTART_ALERT_SECONDS = config.getInt("restart-warn-delay", 30);
        SERVER_DESC = config.getString("server-desc", "Unknown");
        CUSTOM_MOTD = config.getBoolean("custom-motd", true);
    }

    private void loadCommands(){
        ConfigurationSection commandsSection = config.getConfigurationSection("commands");
        assert commandsSection != null;
        for(String key : commandsSection.getKeys(false).stream().toList()){
            ConfigurationSection command = commandsSection.getConfigurationSection(key);
            CommandData commandData = new CommandData();

            assert command != null;
            if(command.getString("permission") != null){
                if(!Objects.requireNonNull(command.getString("permission")).isEmpty()){
                    commandData.setPermission(command.getString("permission"));
                }
            }
            commandData.setEnabled(command.getBoolean("enabled"));

            COMMANDS.put(key, commandData);
        }
    }

    public Config(FileConfiguration serverConfig){
        config = serverConfig;
        loadConfigValues();
        loadCommands();
    }
    public void reloadConfig(FileConfiguration reloadedConfig){
        config = reloadedConfig;
        loadConfigValues();
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
