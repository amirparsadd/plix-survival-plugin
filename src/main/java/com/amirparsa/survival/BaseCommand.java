package com.amirparsa.survival;

import com.amirparsa.survival.data.CommandData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class BaseCommand implements CommandExecutor {

    private final String commandDisabledMessage = ChatColor.RED + "This command is disabled";
    private final String lackingPermissionMessage = ChatColor.RED + "You are lacking the required permission!";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        CommandData commandData = Survival.getInstance().config.COMMANDS.get(command.getName());

        if(commandData == null){
            commandData = new CommandData(null, true);
        }

        if(!commandData.isEnabled()){
            if(commandSender instanceof Player p){
                p.sendMessage(commandDisabledMessage);
                return true;
            }

            Survival.getInstance().getLogger().info(commandDisabledMessage);
            return true;
        }

        if(commandData.getPermission() != null && commandSender instanceof Player p){
            if(!p.hasPermission(commandData.getPermission())){
                p.sendMessage(lackingPermissionMessage);
                return true;
            }
        }

        return handle(commandSender, command, label, args);
    }

    public abstract boolean handle(CommandSender commandSender, Command command, String label, String[] args);
}
