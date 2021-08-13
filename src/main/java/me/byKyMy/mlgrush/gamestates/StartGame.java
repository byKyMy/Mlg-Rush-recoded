package me.byKyMy.mlgrush.gamestates;

import me.byKyMy.mlgrush.items.AddItems;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class StartGame {


    public static boolean started = false;


    static void startGame(){


        started = true;


            if(LobbyPhase.lobbyPhase = false){
                for (Player all : Bukkit.getOnlinePlayers()){

                    all.setGameMode(GameMode.SURVIVAL);

                    AddItems.addItems();


                }
            }



    }

}
