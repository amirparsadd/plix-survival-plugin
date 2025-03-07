package com.amirparsa.survival;

import com.amirparsa.survival.commands.BaseCommand;
import com.amirparsa.survival.commands.storage.CraftCommand;
import com.amirparsa.survival.commands.storage.EnchantCommand;
import com.amirparsa.survival.commands.storage.PingCommand;
import com.amirparsa.survival.commands.storage.ShareLocationCommand;
import com.amirparsa.survival.listeners.DeathListener;
import com.amirparsa.survival.listeners.JoinLeaveListener;
import com.amirparsa.survival.listeners.PingListener;
import com.amirparsa.survival.listeners.PvpListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Objects;

public final class Survival extends JavaPlugin implements Listener {

    private static Survival plugin;
    public Config config;

    public static HashMap<String, BaseCommand> commandHandlers = new HashMap<>();

    static {
        commandHandlers.put("sharelocation", new ShareLocationCommand());
        commandHandlers.put("ping", new PingCommand());
        commandHandlers.put("craft", new CraftCommand());
        commandHandlers.put("enchant", new EnchantCommand());
    }

    @Override
    public void onEnable() {
        plugin = this;
        setupConfig();
        getServer().setMaxPlayers(config.MAX_PLAYERS);

        registerCommands();
        registerEvents();
        displayStartupMessage();
        runRestartTask();
        runAdsTask();
    }

    private void setupConfig(){
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
        config = new Config(getConfig());
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new PvpListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new PingListener(), this);
    }

    private void registerCommands(){
        for(String commandName : commandHandlers.keySet().stream().toList()){
            Objects.requireNonNull(getCommand(commandName)).setExecutor(commandHandlers.get(commandName));
        }
    }

    private void runAdsTask(){
        new BukkitRunnable(){
            @Override
            public void run(){
                if(!config.ADS) return;

                getServer().broadcastMessage(ChatColor.GREEN + "This Server Is Powered By PlixSMP");
                getServer().broadcastMessage(ChatColor.YELLOW + "Telegram: " + ChatColor.BLUE + ChatColor.UNDERLINE + "https://t.me/plixsmp");
                getServer().broadcastMessage(ChatColor.YELLOW + "Rubika:   " + ChatColor.BLUE + ChatColor.UNDERLINE + "https://rubika.ir/plixsmp");
                getServer().broadcastMessage(ChatColor.YELLOW + "Discord:  " + ChatColor.BLUE + ChatColor.UNDERLINE + "https://discord.gg/D9F7QsMZpS");
                getServer().broadcastMessage(ChatColor.YELLOW + "Eitaa:    " + ChatColor.BLUE + ChatColor.UNDERLINE + "https://eitaa.com/plixsmp");
            }
        }.runTaskTimer(this, 10, 1200 * 20L);
    }

    private void runRestartTask(){
        new BukkitRunnable(){
            @Override
            public void run() {
                getServer().broadcastMessage("Server Restarting In 30 Seconds!");
            }
        }.runTaskLater(this, (config.SERVER_RESTART_SECONDS - config.SERVER_RESTART_ALERT_SECONDS) * 20L);

        new BukkitRunnable(){
            @Override
            public void run() {
                Bukkit.shutdown();
            }
        }.runTaskLater(this, config.SERVER_RESTART_SECONDS * 20L);
    }

    private void displayStartupMessage(){
        getLogger().info("Max Players:" + config.MAX_PLAYERS);
        getLogger().info("Server Name:" + config.SERVER_NAME);
        getLogger().info("This Server Is Running " + getServer().getVersion());
    }

    public ChatColor convertBooleanToChatColor(boolean bool){
        return bool ? ChatColor.GREEN : ChatColor.RED;
    }

    public String convertBooleanToString(boolean bool){
        return bool ? "ON" : "OFF";
    }

    public static Survival getInstance() {
        return plugin;
    }
}
