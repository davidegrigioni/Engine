package me.davide.engine.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        final Player p = (Player) sender;
        final Player target = Bukkit.getPlayer(args[0]);

        if (sender instanceof Player) {

            p.setFlying(true);
            p.sendMessage(ChatColor.RED + "Fly activated");

        } else {

            p.setFlying(false);
            p.sendMessage(ChatColor.RED + "Fly disabled");

        }

        return false;
    }
}
