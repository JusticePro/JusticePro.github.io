package me.justicepro.ukit.Inventories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {
	
	private ItemStack itemstack;
	/**
	 * @author JusticePro
	 */
	public Item(Material material) {
		itemstack = new ItemStack(material);
	}
	/**
	 * @author JusticePro
	 */
	public Item(ItemStack item) {
		itemstack = item;
	}
	
	public void setName(String name) {
		ItemMeta meta = itemstack.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		itemstack.setItemMeta(meta);
	}
	
	public ItemStack getItemstack() {
		return itemstack;
	}

	public void addLore(String lore) {
		ItemMeta meta = itemstack.getItemMeta();
		ArrayList<String> lores = new ArrayList<>();
		if (meta.hasLore()) {
			for (String lore1 : meta.getLore()) {
				lores.add(lore1);
			}
		}
		lores.add(lore);
		meta.setLore(lores);
		itemstack.setItemMeta(meta);
	}
	
}