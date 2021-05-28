package koutachan.tctcreeperdupefixer;

import org.bukkit.plugin.java.JavaPlugin;

public final class TCTCreeperDupeFixer extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Event(this),this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
