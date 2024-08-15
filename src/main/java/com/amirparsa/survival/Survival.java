package com.amirparsa.survival;

import com.amirparsa.survival.commands.ShareLocationCommand;
import com.amirparsa.survival.listeners.DeathListener;
import com.amirparsa.survival.listeners.JoinLeaveListener;
import com.amirparsa.survival.listeners.PvpListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Survival extends JavaPlugin implements Listener {

    public final int MAX_PLAYERS = getConfig().getInt("max-players", 5);
    public final String SERVER_NAME = getConfig().getString("server-id", "Unknown");
    public final boolean PVP = getConfig().getBoolean("pvp", false);
    public final int SERVER_RESTART_SECONDS = getConfig().getInt("restart-delay", 40000);

    private static Survival plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        getServer().setMaxPlayers(MAX_PLAYERS);

        registerCommands();
        registerEvents();
        displayStartupMessage();
        runRestartTask();
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new PvpListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
    }

    private void registerCommands(){
        PluginCommand sharelocationCommand = getCommand("sharelocation");

        if (sharelocationCommand != null) {
            sharelocationCommand.setExecutor(new ShareLocationCommand());
            return;
        }

        getServer().getLogger().severe("Failed To Setup ShareLocation Command!");
        getServer().shutdown();
    }

    private void runRestartTask(){
        new BukkitRunnable(){
            @Override
            public void run() {
                getServer().broadcastMessage("Server Restarting In 30 Seconds!");
            }
        }.runTaskLater(this, (SERVER_RESTART_SECONDS - 30) * 20L);
        new BukkitRunnable(){
            @Override
            public void run() {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
            }
        }.runTaskLater(this, SERVER_RESTART_SECONDS * 20L);
    }

    private void displayStartupMessage(){
        getLogger().info("Max Players:" + MAX_PLAYERS);
        getLogger().info("Server Name:" + SERVER_NAME);
        getLogger().info("This Server Is Running " + getServer().getVersion());
    }

    public ChatColor getColor(boolean bool){
        return bool ? ChatColor.GREEN : ChatColor.RED;
    }

    public String toString(boolean bool){
        return bool ? "ON" : "OFF";
    }

    public static Survival getInstance() {
        return plugin;
    }
}
