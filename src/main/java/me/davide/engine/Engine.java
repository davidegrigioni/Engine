package me.davide.engine;

import me.davide.engine.commands.FlyCommand;
import me.davide.engine.listeners.FreezeListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Engine extends JavaPlugin {

    private Engine instance;
    private PluginManager pm;

    @Override
    public void onEnable() {
        instance = this;
        registerCommands();
        registerEvents();

    }

    private void registerCommands() {
        getCommand("fly").setExecutor(new FlyCommand());
    }

    private void registerEvents() {
        pm.registerEvents(new FreezeListener(), this);
    }

}
