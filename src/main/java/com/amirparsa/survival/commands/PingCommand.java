package com.amirparsa.survival.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player player){
            player.sendMessage(ChatColor.GREEN + "Your Ping Is: " + ChatColor.DARK_GREEN + player.getPing() + "ms");
        }
        return true;
    }
}
