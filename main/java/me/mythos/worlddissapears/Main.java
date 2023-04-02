package me.mythos.worlddissapears;

import me.mythos.worlddissapears.commands.StartCommand;
import me.mythos.worlddissapears.commands.WandCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable()
    {
        new StartCommand(this);
        new WandCommand(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
