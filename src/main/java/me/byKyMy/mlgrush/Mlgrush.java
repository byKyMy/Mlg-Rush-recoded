package me.byKyMy.mlgrush;

import me.byKyMy.mlgrush.Commands.Spawn;
import deby_kymy.mlgrush.Listener.*;
import me.byKyMy.mlgrush.Listener.*;
import me.byKyMy.mlgrush.gamestates.LobbyPhase;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Mlgrush extends JavaPlugin {


    public static String PREFIX = "[§bMlg§fRush]";
    public static Mlgrush instance;
    public static Mlgrush getInstance(){return instance;}



    @Override
    public void onEnable() {


        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new BreakBed(), this);
        pluginManager.registerEvents(new KillCounter(), this);
        pluginManager.registerEvents(new Leave(), this);
        pluginManager.registerEvents(new NoHunger(), this);
        pluginManager.registerEvents(new NoPvP(), this);
        pluginManager.registerEvents(new LobbyPhase(), this);


        Objects.requireNonNull(getCommand("mlgrush")).setExecutor(new Spawn());

        instance = this;



        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
