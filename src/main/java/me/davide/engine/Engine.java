package me.davide.engine;

import me.davide.engine.commands.FlyCommand;
import me.davide.engine.commands.ListCommand;
import me.davide.engine.commands.SetSpawnCommand;
import me.davide.engine.commands.SpawnCommand;
import me.davide.engine.listeners.FreezeListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Engine extends JavaPlugin {

    private Engine instance;
    private PluginManager pm;

    @Override
    public void onEnable() {
        instance = this;

        registerConfig();
        registerCommands();
        registerEvents();

    }

    private void registerCommands() {
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("list").setExecutor(new ListCommand());
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
    }

    private void registerEvents() {
        pm.registerEvents(new FreezeListener(), this);
    }

    private void registerConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

}
