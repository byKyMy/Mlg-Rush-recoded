package me.byKyMy.mlgrush.Listener;

import me.byKyMy.mlgrush.gamestates.LobbyPhase;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class NoPvP implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event){
        if(LobbyPhase.lobbyPhase = true){
            event.setCancelled(true);
        }else {
            event.setCancelled(false);
        }

    }

}
