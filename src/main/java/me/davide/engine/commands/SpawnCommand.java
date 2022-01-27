package me.davide.engine.commands;

import me.davide.engine.Engine;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final Engine plugin;

    public SpawnCommand(Engine plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            final Player p = (Player) sender;
            final Location loc = plugin.getConfig().getLocation("spawn-location");

            if (loc != null) {

                p.teleport(loc);

                p.sendMessage(ChatColor.RED + "You have been teleported!");

            } else {

                p.sendMessage("There is no spawnpoint set, use /setspawn");

            }

        }

        return true;
    }
}
