package LemonJoey.parrottpblocker;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        saveResource("config.yml", false);
        getServer().getPluginManager().registerEvents(new TPCheck(),this);
        getServer().getLogger().info("ParrotTPBlocker loaded");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getLogger().info("ParrotTPBlocker unloaded");
    }
}
