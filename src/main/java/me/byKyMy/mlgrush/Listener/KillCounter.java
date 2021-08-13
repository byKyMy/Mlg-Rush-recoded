package me.byKyMy.mlgrush.Listener;

import me.byKyMy.mlgrush.Mlgrush;
import me.byKyMy.mlgrush.gamestates.LobbyPhase;
import me.byKyMy.mlgrush.items.AddItems;
import me.byKyMy.mlgrush.scoreboard.SetScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillCounter implements Listener {

    @EventHandler
    public void onKill(PlayerDeathEvent event){


        Player player1 = LobbyPhase.ingame.get(0);
        Player player2 = LobbyPhase.ingame.get(1);

        if (event.getEntity().getPlayer() == player1){

            SetScoreboard.kills2++;

            for (Player all : Bukkit.getOnlinePlayers()){

                SetScoreboard.setScoreboard(all);
            }

            Location Spawn1 = (Location) Mlgrush.getInstance().getConfig().get("Spawn.1");
            assert Spawn1 != null;
            player1.teleport(Spawn1);

            Location Spawn2 = (Location) Mlgrush.getInstance().getConfig().get("Spawn.2");
            assert Spawn2 != null;
            player2.teleport(Spawn2);

            AddItems.addItems();

        }else if(event.getEntity().getPlayer() == player2){

            SetScoreboard.kills1++;

            for (Player all : Bukkit.getOnlinePlayers()){

                SetScoreboard.setScoreboard(all);
            }

            Location Spawn1 = (Location) Mlgrush.getInstance().getConfig().get("Spawn.1");
            assert Spawn1 != null;
            player1.teleport(Spawn1);

            Location Spawn2 = (Location) Mlgrush.getInstance().getConfig().get("Lobby.2");
            assert Spawn2 != null;
            player2.teleport(Spawn2);

            AddItems.addItems();
        }


    }

}
