package com.amirparsa.survival.commands.storage;

import com.amirparsa.survival.commands.ConfigurableCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand extends ConfigurableCommand {

    public boolean handle(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player player){
            if(args.length != 1){
                player.sendMessage(ChatColor.GREEN + "Your Ping Is: " + ChatColor.DARK_GREEN + player.getPing() + "ms");
                return true;
            }

            Player selectedPlayer = Bukkit.getPlayer(args[0]);

            if (selectedPlayer == null){
                player.sendMessage(ChatColor.RED + "Unable to find specified player!");
                return true;
            }

            player.sendMessage(ChatColor.GREEN + selectedPlayer.getName() + "'s Ping Is: " + ChatColor.DARK_GREEN + selectedPlayer.getPing() + "ms");
            return true;
        }
        commandSender.sendMessage("Unable To Execute Command From This Scope!");
        return true;
    }
}
