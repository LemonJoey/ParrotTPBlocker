package LemonJoey.parrottpblocker;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class TPCheck implements Listener{

    Main plugin = Main.plugin;

    @EventHandler
    public void teleporting(PlayerTeleportEvent event) {
        List<String> worlds = plugin.getConfig().getStringList("blocked-worlds");
        YamlConfiguration messages = Main.messages;
        if(worlds.contains(event.getTo().getWorld().getName())) {
            HumanEntity humanEntity = event.getPlayer();

            if(humanEntity.getShoulderEntityLeft() != null || humanEntity.getShoulderEntityRight() != null){
                System.out.println("Blocked parrotTP to events world");
                event.setCancelled(true);
                humanEntity.sendMessage(messages.getString("parrotsblocked"));
            }
        }
    }
}