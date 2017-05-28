package me.justicepro.ukit.Chat;

import org.bukkit.ChatColor;

public class MessageBuilder {
	
	private String message;
	/**
	 * @author JusticePro
	 */
	public MessageBuilder() {
		message = "";
	}
	
	/**
	 * @param str Add to the end of the message. Use '&' for color codes. Example add("Hey"); "Hey"
	 */
	public MessageBuilder add(String str) {
		message = message + ChatColor.translateAlternateColorCodes('&', str);
		return this;
	}
	
	/**
	 * @param prefix Prefix for message. Example addPrefix("Color", ChatColor.RED); "&c[Color]"
	 * @param color Color of the Prefix.
	 */
	public MessageBuilder addPrefix(String prefix, ChatColor color) {
		message = message + ChatColor.translateAlternateColorCodes('&', color + "[" + prefix + "]");
		return this;
	}
	
	/**
	 * @return Returns the message built.
	 */
	public String build() {
		return message;
	}
	
}