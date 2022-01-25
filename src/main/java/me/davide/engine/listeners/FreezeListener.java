package me.davide.engine.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class FreezeListener implements Listener {

    ArrayList<String> frozen = new ArrayList<String>();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {

        Player p = e.getPlayer();

        if (frozen.contains(p.getName())) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.RED + "You are frozen!");
        }

    }



}
