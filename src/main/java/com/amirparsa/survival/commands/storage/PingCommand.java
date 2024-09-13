package com.amirparsa.survival.commands.storage;

import com.amirparsa.survival.commands.ConfigurableCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand extends ConfigurableCommand {

    public boolean handle(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player player){
            player.sendMessage(ChatColor.GREEN + "Your Ping Is: " + ChatColor.DARK_GREEN + player.getPing() + "ms");
        }
        return true;
    }
}
