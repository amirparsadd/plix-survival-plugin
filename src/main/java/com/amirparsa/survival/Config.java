package com.amirparsa.survival;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private FileConfiguration config;
    public int MAX_PLAYERS;
    public String SERVER_NAME;
    public boolean PVP;
    public boolean ADS;
    public int SERVER_RESTART_SECONDS;
    public String SERVER_DESC;

    public void loadConfigValues(){
        MAX_PLAYERS = config.getInt("max-players", 5);
        SERVER_NAME = config.getString("server-id", "Unknown");
        PVP = config.getBoolean("pvp", false);
        ADS = config.getBoolean("enable-ads", true);
        SERVER_RESTART_SECONDS = config.getInt("restart-delay", 40000);
        SERVER_DESC = config.getString("server-desc", "Broken Config!");
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
