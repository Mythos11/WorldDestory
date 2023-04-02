package me.mythos.worlddissapears.commands;

import me.mythos.worlddissapears.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class WandCommand implements CommandExecutor {

    Main plugin;

    public WandCommand(Main plugin)
    {
        this.plugin = plugin;
        plugin.getCommand("wand").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return true;
    }
}
