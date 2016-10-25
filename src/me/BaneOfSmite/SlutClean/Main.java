package me.BaneOfSmite.SlutClean;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static String prefix = ChatColor.GOLD + "UHC" + ChatColor.DARK_GRAY + " »";
	public static boolean slutcleanvar = false;

	@Override
	public void onEnable() {
		getCommand("slutclean").setExecutor(new SlutCleanToggle());
		getServer().getPluginManager().registerEvents((Listener) new SlutClean(), this);
	}

	public static String getPrefix() {
		return prefix;
	}

	public static boolean getSlutcleanvar() {
		return slutcleanvar;
	}

}
