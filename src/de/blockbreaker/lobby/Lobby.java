package de.blockbreaker.lobby;

import de.blockbreaker.lobby.api.util.RegisterUtil;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lukas on 15.06.2015.
 */
public class Lobby extends JavaPlugin {

    private static Lobby instance;

    @Override
    public void onEnable() {
        instance = this;

        MySQLFile file = new MySQLFile();
        file.setStandard();
        file.readData();

        RegisterUtil<Lobby> register = new RegisterUtil<Lobby>(this);
    }

    @Override
    public void onDisable() {

    }


    /**
     * Alle Methoden folgen
     */

    //Return Lobby (Mainclass)
    public Lobby getInstance() {
        return instance;
    }
}
