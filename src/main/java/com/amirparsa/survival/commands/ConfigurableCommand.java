package com.amirparsa.survival.commands;

import com.amirparsa.survival.Survival;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

abstract public class ConfigurableCommand extends BaseCommand {

    private final String commandDisabledMessage = ChatColor.RED + "This command is disabled";
    private final String lackingPermissionMessage = ChatColor.GRAY + "You are lacking the required permission!";

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

        return super.onCommand(commandSender, command, label, args);
    }
}
