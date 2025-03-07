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
        if(Survival.getInstance().config.CUSTOM_JOINLEAVE_MESSAGE){
            e.setJoinMessage(e.getPlayer().getName() + ChatColor.AQUA + " Joined " + ChatColor.DARK_AQUA + Survival.getInstance().config.SERVER_NAME);
            for(int i = 0; i < 20; i++){
                e.getPlayer().sendMessage("   "); // Get Rid Of Any Older Messages Persisting From Other Servers
            }
        }
        if(Survival.getInstance().config.VERBOSE_WELCOME){
            e.getPlayer().sendMessage(ChatColor.GRAY + "Welcome To " + ChatColor.DARK_AQUA + Survival.getInstance().config.SERVER_NAME);
            e.getPlayer().sendMessage(ChatColor.GRAY + "PVP Is " + Survival.getInstance().convertBooleanToChatColor(Survival.getInstance().config.PVP) + Survival.getInstance().convertBooleanToString(Survival.getInstance().config.PVP));
            e.getPlayer().sendMessage(ChatColor.DARK_GRAY + "Running " + Bukkit.getServer().getVersion());
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        if(Survival.getInstance().config.CUSTOM_JOINLEAVE_MESSAGE) {
            e.setQuitMessage(e.getPlayer().getName() + ChatColor.AQUA + " Left " + ChatColor.DARK_AQUA + Survival.getInstance().config.SERVER_NAME);
        }
    }
}
