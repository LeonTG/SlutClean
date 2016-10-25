package me.BaneOfSmite.SlutClean;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.BaneOfSmite.SlutClean.Main;

public class SlutCleanToggle implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
		Player p = (Player) sender;
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("enable")) {
				p.sendMessage(Main.getPrefix() + ChatColor.GRAY + " You Enabled SlutClean!");
				Main.slutcleanvar = true;
			} else if (args[0].equalsIgnoreCase("disable")) {
				p.sendMessage(Main.getPrefix() + ChatColor.GRAY + " You Disabled SlutClean!");
				Main.slutcleanvar = false;
			}
		}
		return true;
	}

}
