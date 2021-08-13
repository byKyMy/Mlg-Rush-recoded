package me.byKyMy.mlgrush.scoreboard;

import me.byKyMy.mlgrush.gamestates.LobbyPhase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class SetScoreboard {

    public static int beds1 = 0;
    public static int beds2 = 0;
    public static int kills1 = 0;
    public static int kills2 = 0;


    public static void setScoreboard(Player player){

        final ScoreboardManager sm = Bukkit.getScoreboardManager();
        assert sm != null;
        final Scoreboard scoreboard;


        if (player.getScoreboard() == Bukkit.getScoreboardManager().getMainScoreboard()) {
            scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            player.setScoreboard(scoreboard);
        } else {
            scoreboard = player.getScoreboard();


            final Objective o = scoreboard.registerNewObjective("how2mc", "dummy", "§bHow§f2mc§b.de");
            o.setDisplaySlot(DisplaySlot.SIDEBAR);
            o.getScore("§aName:").setScore(0);
            o.getScore("§f" + player.getName()).setScore(1);
            o.getScore("§aBeds §f>>" + "b" + LobbyPhase.ingame.get(0).getName() + "§f:").setScore(2);
            o.getScore("§f" + beds1 ).setScore(3);
            o.getScore("§aBeds §f>>" + "b" + LobbyPhase.ingame.get(1).getName() + "§f:").setScore(4);
            o.getScore("§f" + beds2).setScore(5);
            o.getScore("§aKills:").setScore(6);
            o.getScore( "§a" + LobbyPhase.ingame.get(0).getName() + kills1).setScore(7);


            player.setScoreboard(scoreboard);
        }

    }



}
