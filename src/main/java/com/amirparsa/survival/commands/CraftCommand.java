package com.amirparsa.survival.commands;

import com.amirparsa.survival.BaseCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CraftCommand extends BaseCommand {

    public boolean handle(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player player){
            player.openWorkbench(null, true);
        }
        return true;
    }
}
