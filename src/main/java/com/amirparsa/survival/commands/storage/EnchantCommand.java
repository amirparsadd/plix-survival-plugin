package com.amirparsa.survival.commands.storage;

import com.amirparsa.survival.commands.ConfigurableCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnchantCommand extends ConfigurableCommand {

    public boolean handle(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player player){
            player.openEnchanting(null, true);
        }
        return true;
    }
}
