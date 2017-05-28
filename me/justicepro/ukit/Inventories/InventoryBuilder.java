package me.justicepro.ukit.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

	private Inventory inv;
	/**
	 * @author JusticePro
	 */
	public InventoryBuilder(int size, String title) {
		inv = Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', title));
	}

	public Inventory build() {
		return inv;
	}

	public InventoryBuilder addItems(ItemStack... items) {
		for (int i = 0; i < items.length; i++) {
			if (!items[i].getType().equals(Material.AIR)) {
				inv.setItem(i, items[i]);
			}
		}
		return this;
	}

	public InventoryBuilder addItems(Item... items) {
		for (int i = 0; i < items.length; i++) {
			if (!items[i].getItemstack().getType().equals(Material.AIR)) {
				inv.setItem(i, items[i].getItemstack());
			}
		}
		return this;
	}

	public InventoryBuilder setItem(int index, ItemStack item) {
		inv.setItem(index, item);
		return this;
	}

	public InventoryBuilder setItem(int index, Item item) {
		inv.setItem(index, item.getItemstack());
		return this;
	}

}