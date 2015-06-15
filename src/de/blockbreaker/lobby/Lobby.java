package de.blockbreaker.lobby;

import de.blockbreaker.lobby.api.mysql.MySQL;
import de.blockbreaker.lobby.api.mysql.MySQLFile;
import de.blockbreaker.lobby.api.util.RegisterUtil;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lukas on 15.06.2015.
 */
public class Lobby extends JavaPlugin {

    public static String cmd = ChatColor.GRAY + "[Lobby] ";

    private static Lobby instance;

    @Override
    public void onEnable() {
        instance = this;

        //Erstellt Default MySQL Config
        MySQLFile file = new MySQLFile();
        file.setStandard();
        file.readData();

        RegisterUtil<Lobby> register = new RegisterUtil<Lobby>(this);

        MySQL.connect();

        System.out.println(cmd + ChatColor.DARK_GREEN + "Enabled!");
    }

    @Override
    public void onDisable() {
        MySQL.disconnect();

        System.out.println(cmd + ChatColor.DARK_RED + "Disabled!");
    }


    /**
     * Alle Methoden folgen
     */

    //Return Lobby (Mainclass)
    public Lobby getInstance() {
        return instance;
    }
}
