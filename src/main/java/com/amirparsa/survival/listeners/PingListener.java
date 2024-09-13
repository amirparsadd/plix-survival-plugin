package com.amirparsa.survival.listeners;

import com.amirparsa.survival.Survival;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e){
        if(!Survival.getInstance().config.CUSTOM_MOTD) return;
        e.setMotd(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + Survival.getInstance().config.SERVER_NAME + ChatColor.RESET + ChatColor.GRAY + " Is Online!\n" + ChatColor.DARK_GRAY + Survival.getInstance().config.SERVER_DESC);
    }
}
