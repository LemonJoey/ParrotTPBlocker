package LemonJoey.parrottpblocker;

import LemonJoey.parrottpblocker.bStats.Metrics;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class Main extends JavaPlugin {

    public static Main plugin;
    public static YamlConfiguration messages;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        saveDefaultConfig();
        createCustomConfig();
        int pluginId = 7278;
        Metrics metrics = new Metrics(this, pluginId);
        getServer().getPluginManager().registerEvents(new TPCheck(), this);
        getServer().getLogger().info("ParrotTPBlocker loaded");
        this.getCommand("ParrotTpBlocker").setExecutor(new ReloadCommand());
        Objects.requireNonNull(this.getCommand("ParrotTPBlocker")).setTabCompleter(new TabComplete());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getLogger().info("ParrotTPBlocker unloaded");
    }

    void createCustomConfig() {
        File messages = new File(getDataFolder(), "messages.yml");
        if (!messages.exists()) {
            plugin.getLogger().warning("No messages.yml found, creating a new one!");
            plugin.saveResource("messages.yml", false);
        }
    }
}