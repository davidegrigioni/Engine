package me.davide.engine.commands;

import me.davide.engine.Engine;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final Engine plugin;

    public SetSpawnCommand(Engine plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // https://www.youtube.com/watch?v=aUt03TXv4rc 12:50

        if (sender instanceof Player) {

            final Player p = (Player) sender;
            final Location loc = p.getLocation();

            plugin.getConfig().set("spawn-location", loc);
            plugin.saveConfig();
            p.sendMessage(ChatColor.RED + "Spawn Location set.");

        }

        return true;
    }
}
