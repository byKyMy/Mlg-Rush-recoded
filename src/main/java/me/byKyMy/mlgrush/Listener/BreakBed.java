package me.byKyMy.mlgrush.Listener;

import me.byKyMy.mlgrush.Mlgrush;
import me.byKyMy.mlgrush.gamestates.EndGame;
import me.byKyMy.mlgrush.gamestates.LobbyPhase;
import me.byKyMy.mlgrush.scoreboard.SetScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBed implements Listener {

    @EventHandler
    public void onBedBreak(BlockBreakEvent event){



        if(event.getBlock().getType() == Material.RED_BED){

           Player player1 = LobbyPhase.ingame.get(0);
           Player player2 = LobbyPhase.ingame.get(1);

            if(event.getPlayer() == player1){

                SetScoreboard.beds1 = player1.getLevel();
                SetScoreboard.beds1++;

               for (Player all : Bukkit.getOnlinePlayers()){
                   SetScoreboard.setScoreboard(all);

               }

                Location Spawn1 = (Location) Mlgrush.getInstance().getConfig().get("Spawn.1");
                assert Spawn1 != null;
                player1.teleport(Spawn1);

                Location Spawn2 = (Location) Mlgrush.getInstance().getConfig().get("Spawn.2");
                assert Spawn2 != null;
                player2.teleport(Spawn2);

                World world = Bukkit.getWorld("world");
                assert world != null;
                world.setAutoSave(false);
                Bukkit.getServer().unloadWorld("world", false);


            }else if(event.getPlayer() == player2){

                SetScoreboard.beds2 = player2.getLevel();
                SetScoreboard.beds2++;

                for (Player all : Bukkit.getOnlinePlayers()){
                    SetScoreboard.setScoreboard(all);
                }

                Location Spawn1 = (Location) Mlgrush.getInstance().getConfig().get("Spawn.1");
                assert Spawn1 != null;
                player1.teleport(Spawn1);

                Location Spawn2 = (Location) Mlgrush.getInstance().getConfig().get("Spawn.2");
                assert Spawn2 != null;
                player2.teleport(Spawn2);

                World world = Bukkit.getWorld("world");
                assert world != null;
                world.setAutoSave(false);
                Bukkit.getServer().unloadWorld("world", false);

            }


            if(SetScoreboard.beds1 == 10){
                EndGame.end();
            }else if(SetScoreboard.beds2 == 10) {
                EndGame.end();
            }


        }


    }


}
