package com.amirparsa.survival.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Random;

public class DeathListener implements Listener {

    public final String[] deathMessages = new String[]{
            "Brutally Murdered",
            "Murdered",
            "Covered In Blood",
            "Destroyed",
            "Eaten",
            "Eaten With Hot Sauce",
            "Brutally Eaten",
            "Brutally Destroyed",
            "K.O. d",
            "Squashed",
            "Imploded",
            "Squished",
            "Taken The L",
            "Caked",
            "Cooked",
            "Knocked Down",
            "Knocked Out",
            "Ducked"
    };

    private final Random random = new Random();

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if(e.getEntity().getKiller() == null) return;
        e.setDeathMessage("");
        Bukkit.broadcastMessage(e.getEntity().getName() + " Was " + ChatColor.GOLD + deathMessages[random.nextInt(deathMessages.length)] + ChatColor.RESET + " By " + e.getEntity().getKiller().getName());
    }
}
