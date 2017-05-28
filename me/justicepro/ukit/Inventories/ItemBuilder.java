package me.justicepro.ukit.Inventories;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {
	
	private Item item;
	/**
	 * @author JusticePro
	 */
	public ItemBuilder(Material material) {
		item = new Item(material);
	}
	/**
	 * @author JusticePro
	 */
	public ItemBuilder(ItemStack item) {
		this.item = new Item(item);
	}
	/**
	 * @author JusticePro
	 */
	@SuppressWarnings("deprecation")
	public ItemBuilder(DyeColor color) {
		item = new Item(new ItemStack(Material.INK_SACK, 1, color.getDyeData()));
	}
	/**
	 * @author JusticePro
	 */
	public ItemBuilder(String player) {
		ItemStack itemstack = new ItemStack(Material.SKULL_ITEM);
		itemstack.setDurability((short) 3);
		SkullMeta skull = (SkullMeta) itemstack.getItemMeta();
		skull.setOwner(player);
		itemstack.setItemMeta(skull);
		item = new Item(itemstack);
	}

	public ItemBuilder setName(String name) {
		item.setName(ChatColor.translateAlternateColorCodes('&', name));
		return this;
	}
	
	public ItemBuilder addLore(String lore) {
		item.addLore(ChatColor.translateAlternateColorCodes('&', lore));
		return this;
	}
	
	public Item build() {
		return item;
	}
	
	public Item buildShopItem(int cost) {
		return new ItemBuilder(item.getItemstack())
				.setName(("&e" + item.getItemstack().getType().name().charAt(0) + item.getItemstack().getType().name().toLowerCase().substring(1)).replaceAll("_", " "))
				.addLore("&9" + cost + " Cost")
				.addLore("&eLeft Click to buy 1")
				.addLore("&eRight Click to buy 64").build();
	}
	
	public Item buildShopItem(int cost, boolean changeName) {
		if (changeName) {
			buildShopItem(cost);
		}
		return new ItemBuilder(item.getItemstack())
				.addLore("&9" + cost + " Cost")
				.addLore("&eLeft Click to buy 1")
				.addLore("&eRight Click to buy 64").build();
	}
	
}