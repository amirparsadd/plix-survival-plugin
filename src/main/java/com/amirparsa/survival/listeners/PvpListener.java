package com.amirparsa.survival.listeners;

import com.amirparsa.survival.Survival;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvpListener implements Listener {

    @EventHandler
    public void onPVP(EntityDamageByEntityEvent e){
        if(!(e.getEntity() instanceof Player)) return;
        if(!(e.getDamager() instanceof Player)) return;

        if(!Survival.getInstance().PVP){
            e.setCancelled(true);
            e.getDamager().sendMessage(ChatColor.RED + "PVP Is Disabled In Your Current SMP");
        }
    }

}
