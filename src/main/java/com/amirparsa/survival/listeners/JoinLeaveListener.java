package com.amirparsa.survival.listeners;

import com.amirparsa.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.setJoinMessage(e.getPlayer().getName() + ChatColor.AQUA + " Joined " + ChatColor.DARK_AQUA + Survival.getInstance().SERVER_NAME);
        for(int i = 0; i < 20; i++){
            e.getPlayer().sendMessage("   ");
        }
        e.getPlayer().sendMessage(ChatColor.GRAY + "Welcome To " + ChatColor.DARK_AQUA + Survival.getInstance().SERVER_NAME);
        e.getPlayer().sendMessage(ChatColor.GRAY + "PVP Is " + Survival.getInstance().getColor(Survival.getInstance().PVP) + Survival.getInstance().toString(Survival.getInstance().PVP));
        e.getPlayer().sendMessage(ChatColor.DARK_GRAY + "Running " + Bukkit.getServer().getVersion());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        e.setQuitMessage(e.getPlayer().getName() + ChatColor.AQUA + " Left " + ChatColor.DARK_AQUA + Survival.getInstance().SERVER_NAME);
    }
}
