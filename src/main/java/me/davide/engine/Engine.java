package me.davide.engine;

import me.davide.engine.commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Engine extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommands();
        registerEvents();

    }

    private void registerCommands() {
        getCommand("fly").setExecutor(new FlyCommand());
    }

    private void registerEvents() {

    }

}
