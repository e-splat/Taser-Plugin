package me.saeko.taser_plugin;

import me.saeko.taser_plugin.ListenerOrListeners.Interact;
import org.bukkit.plugin.java.JavaPlugin;

public final class Taser_Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Interact(), this);
    }
}
