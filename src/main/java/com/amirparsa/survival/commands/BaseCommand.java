package com.amirparsa.survival.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class BaseCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        return handle(commandSender, command, label, args);
    }

    public abstract boolean handle(CommandSender commandSender, Command command, String label, String[] args);
}
