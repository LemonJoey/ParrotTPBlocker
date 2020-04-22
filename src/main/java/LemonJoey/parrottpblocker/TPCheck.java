package LemonJoey.parrottpblocker;

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

    @EventHandler
    public void teleporting(PlayerTeleportEvent event) {
        if(event.getTo().getWorld().getName().equals("event")) {
            HumanEntity humanEntity = event.getPlayer();
            if(humanEntity.getShoulderEntityLeft() != null){
                System.out.println("Blocked parrot from events world");
                humanEntity.setShoulderEntityLeft(null);
            }
            if(humanEntity.getShoulderEntityRight() != null){
                System.out.println("Blocked parrot from events world");
                humanEntity.setShoulderEntityRight(null);
            }

        }
    }
}