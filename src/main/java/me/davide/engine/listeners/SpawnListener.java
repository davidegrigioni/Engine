package me.davide.engine.listeners;

import me.davide.engine.Engine;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListener implements Listener {

    private final Engine plugin;

    public SpawnListener(Engine plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        if (!player.hasPlayedBefore()) {

            final Location loc = plugin.getConfig().getLocation("spawn-location");

            if (loc != null) {

                player.teleport(loc);

            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {

        final Location loc = plugin.getConfig().getLocation("spawn-location");

        if (loc != null) {

            e.setRespawnLocation(loc);

        }
    }

}
