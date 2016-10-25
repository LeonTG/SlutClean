package me.BaneOfSmite.SlutClean;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.BaneOfSmite.SlutClean.Main;

public class SlutClean implements Listener {

	@EventHandler
	public void on(BlockBreakEvent e) {
		Block block = e.getBlock();
		Player p = e.getPlayer();
		if (Main.getSlutcleanvar()) {
			if (p.getInventory().getHelmet() == null && p.getInventory().getChestplate() == null
					&& p.getInventory().getLeggings() == null && p.getInventory().getBoots() == null) {
				if (block.getType() == Material.IRON_ORE) {
					if (p.getItemInHand().getType() == Material.IRON_PICKAXE
							|| p.getItemInHand().getType() == Material.DIAMOND_PICKAXE
							|| p.getItemInHand().getType() == Material.STONE_PICKAXE) {
						e.getBlock().setType(Material.CHEST);
						Chest c = (Chest) e.getBlock().getState();
						Inventory ci = c.getInventory();
						ci.addItem(new ItemStack(Material.IRON_INGOT));
						e.getBlock().setType(Material.AIR);
						e.getBlock().getWorld().spawn(block.getLocation(), ExperienceOrb.class)
								.setExperience((int) 1.0);
					}
				} else if (block.getType() == Material.GOLD_ORE) {
					if (p.getItemInHand().getType() == Material.IRON_PICKAXE
							|| p.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
						e.getBlock().setType(Material.CHEST);
						Chest c = (Chest) e.getBlock().getState();
						Inventory ci = c.getInventory();
						ci.addItem(new ItemStack(Material.GOLD_INGOT));
						e.getBlock().setType(Material.AIR);
						e.getBlock().getWorld().spawn(block.getLocation(), ExperienceOrb.class)
								.setExperience((int) 1.0);
					}
				}
			}
		}

	}

	@EventHandler
	public void on(EntityDeathEvent event) {
		Entity ent = event.getEntity();
		if (event.getEntity().getKiller() instanceof Player) {
			Player p = event.getEntity().getKiller();
			if (Main.getSlutcleanvar()) {
				if (p.getInventory().getHelmet() == null && p.getInventory().getChestplate() == null
						&& p.getInventory().getLeggings() == null && p.getInventory().getBoots() == null) {
					if (ent.getType() == EntityType.COW) {
						event.getDrops().clear();
						ent.getWorld().dropItemNaturally(ent.getLocation(), new ItemStack(Material.LEATHER, 1));
						ent.getWorld().dropItemNaturally(ent.getLocation(), new ItemStack(Material.COOKED_BEEF, 3));
					} else if (ent.getType() == EntityType.RABBIT) {
						event.getDrops().clear();
						Random rand = new Random();
						if (rand.nextInt(100) < 50) {
							ent.getWorld().dropItemNaturally(ent.getLocation(), new ItemStack(Material.RABBIT_HIDE, 1));
						}
						ent.getWorld().dropItemNaturally(ent.getLocation(), new ItemStack(Material.COOKED_RABBIT, 1));
						if (rand.nextInt(100) < 30) {
							ent.getWorld().dropItemNaturally(ent.getLocation(), new ItemStack(Material.RABBIT_FOOT, 1));
						}
					} else if (ent.getType() == EntityType.SHEEP) {
						event.getDrops().clear();
						ent.getWorld().dropItemNaturally(ent.getLocation(), new ItemStack(Material.COOKED_MUTTON, 3));
					} else if (ent.getType() == EntityType.PIG) {
						event.getDrops().clear();
						ent.getWorld().dropItemNaturally(ent.getLocation(), new ItemStack(Material.GRILLED_PORK, 3));
					} else if (ent.getType() == EntityType.CHICKEN) {
						event.getDrops().clear();
						ent.getWorld().dropItemNaturally(ent.getLocation(), new ItemStack(Material.COOKED_CHICKEN, 1));
						ent.getWorld().dropItemNaturally(ent.getLocation(), new ItemStack(Material.FEATHER, 2));
					} else if (ent.getType() == EntityType.MUSHROOM_COW) {
						event.getDrops().clear();
						ent.getWorld().dropItemNaturally(ent.getLocation(), new ItemStack(Material.LEATHER, 1));
						ent.getWorld().dropItemNaturally(ent.getLocation(), new ItemStack(Material.COOKED_BEEF, 3));
					}
				}
			}
		}

	}

}
