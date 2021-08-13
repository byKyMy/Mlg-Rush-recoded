package me.byKyMy.mlgrush.gamestates;



import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;



public class EndGame {


    public static void end(){

        for (Player all : Bukkit.getOnlinePlayers()){

            all.kickPlayer("§cThe Game is ended");
            Bukkit.getServer().shutdown();


            World world = Bukkit.getWorld("world");
            assert world != null;
            world.setAutoSave(false);
            Bukkit.getServer().unloadWorld("world", false);

            StartGame.started = false;

        }

    }


}
