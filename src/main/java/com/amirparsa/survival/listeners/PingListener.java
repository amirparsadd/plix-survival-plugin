package com.amirparsa.survival.listeners;

import com.amirparsa.survival.Survival;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e){
        e.setMotd(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + Survival.getInstance().SERVER_NAME + ChatColor.RESET + ChatColor.GRAY + " Is Online!\n" + ChatColor.DARK_GRAY + Survival.getInstance().SERVER_DESC);
    }
}
