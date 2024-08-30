package com.amirparsa.survival.commands;

import com.amirparsa.survival.BaseCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShareLocationCommand extends BaseCommand {

    public boolean handle(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player p){
            if(args.length != 1){
                p.sendMessage(ChatColor.RED + "Incorrect Arguments!");
                return true;
            }

            Player receiver = Bukkit.getPlayer(args[0]);

            if(receiver == null){
                p.sendMessage(ChatColor.RED + "Unknown Player!");
                return true;
            }

            Location rawLocation = p.getLocation();
            String location = rawLocation.getBlockX() + " " + rawLocation.getBlockY() + " " + rawLocation.getBlockZ();
            receiver.sendMessage(ChatColor.AQUA + p.getName() + " Sent You Their Location: " + ChatColor.DARK_AQUA + location);
            p.sendMessage(ChatColor.GREEN + "Sent Successfully!");
        }
        return true;
    }
}
