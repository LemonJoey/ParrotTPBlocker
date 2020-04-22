package LemonJoey.parrottpblocker;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

public class ReloadCommand implements CommandExecutor {

    Main plugin = Main.plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        YamlConfiguration messages = Main.messages;
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                plugin.setupMessages();
                sender.sendMessage(messages.getString("reload"));
                plugin.getServer().getLogger().info(messages.getString("reload"));
            }
            else{
                sender.sendMessage(messages.getString("wrongreloadcommand"));
            }
        }
        else {
            sender.sendMessage(messages.getString("wrongreloadcommand"));
        }
        return true;
    }
}
