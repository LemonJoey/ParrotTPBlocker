package LemonJoey.parrottpblocker;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public final class Main extends JavaPlugin {

    public static Main plugin;
    public static YamlConfiguration messages;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        saveDefaultConfig();
        saveResource("messages.yml", false);
        setupMessages();
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

    public static void setupMessages() {
        File file = new File(plugin.getDataFolder()+File.separator+"messages.yml");
        messages = YamlConfiguration.loadConfiguration(file);
    }
}
