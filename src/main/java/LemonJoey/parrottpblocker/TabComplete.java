package LemonJoey.parrottpblocker;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> output = new ArrayList<>();

        switch (args.length) {
            case 0: {
                output.add("reload");
                return output;
            }
            case 1: {
                if ("reload".startsWith(args[0])) {
                    output.add("reload");
                    return output;
                }
            }
        }
        return null;
    }
}

