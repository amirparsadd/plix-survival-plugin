package com.amirparsa.survival.commands;

import com.amirparsa.survival.BaseCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand extends BaseCommand {

    public boolean handle(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player player){
            player.sendMessage(ChatColor.GREEN + "Your Ping Is: " + ChatColor.DARK_GREEN + player.getPing() + "ms");
        }
        return true;
    }
}
