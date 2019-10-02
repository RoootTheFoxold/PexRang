package de.rootrobo.pexrang;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PexRang extends JavaPlugin {
    
    @Override
    public void onEnable() {
        super.onEnable();
        System.out.println("§aDas Rang-Plugin von RootRobo wurde erfolgreich geladen!");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = null;
        if(sender instanceof Player){
            player = (Player) sender;
        }

        //commands
            //command "rang"
            if(command.getName().equalsIgnoreCase("rang")){
                if(!player.hasPermission("rang.rang")) {
                    sender.sendMessage("§cDu hast dazu keine Rechte!");
                    return true;
                }
                
            if (!(args.length == 3)) {
            return false;
            } else {
                if (args[0].equalsIgnoreCase("add")) {
                    
                    PermissionUser user = PermissionsEx.getUser(args[1]);
                    user.addGroup(args[2]);
                    sender.sendMessage("§aDer Spieler " + args[1] + " wurde zur Gruppe " + args[2] + " hinzugefügt.");
                    return true;
                }
                if (args[0].equalsIgnoreCase("remove")) {
                    
                    PermissionUser user = PermissionsEx.getUser(args[1]);
                    user.removeGroup(args[2]);
                    sender.sendMessage("§cDer Spieler " + args[1] + " wurde von der Gruppe " + args[2] + " entfernt.");
                    return true;
                }
            }
        }
        return false;
    }
}