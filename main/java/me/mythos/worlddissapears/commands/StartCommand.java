package me.mythos.worlddissapears.commands;

import me.mythos.worlddissapears.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class StartCommand implements CommandExecutor {

    Main plugin;
    public StartCommand(Main plugin)
    {
        this.plugin = plugin;
        plugin.getCommand("startdestroy").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        new WorldEaterTask(p).runTaskTimer(plugin, 0, 20);
        p.sendMessage(ChatColor.GREEN + "World Eating Started");
        return true;
    }

    private static class WorldEaterTask extends BukkitRunnable {
        private int height = -63;
        private final World world;

        public WorldEaterTask(Player player) {
            this.world = player.getWorld();
        }

        @Override
        public void run() {
            WorldEater(world);
        }

        public void WorldEater(World world)
        {
            if(this.isCancelled()) return;
            WorldBorder bounds = world.getWorldBorder();
            double length = bounds.getSize();
            double xCord = bounds.getCenter().getX();
            double zCord = bounds.getCenter().getZ();

            for (int x = (int) (xCord - length / 2); x < length / 2; x++)
            {
                //world.getBlockAt(x, height, 0).setType(Material.AIR);
                for (int z = (int) (zCord - length / 2); z < length / 2; z++)
                {
                    world.getBlockAt(x, height, z).setType(Material.AIR);
                }
            }
            this.height++;
            if(this.height >= world.getMaxHeight()) this.cancel();
        }
    }
}
