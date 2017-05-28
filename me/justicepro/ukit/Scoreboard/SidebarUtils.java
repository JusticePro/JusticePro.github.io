package me.justicepro.ukit.Scoreboard;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

public class SidebarUtils {
	
	/**
	 * <h1>
	 * 	Code created by WinterGuardian
	 * 	<br>
	 * 	</br>
	 * 	https://www.spigotmc.org/resources/easyscoreboards-for-programmers.10823/
	 * </h1>
	 * 	<br>
	 * 
	 * @author WinterGuardian
	 * @param elements 1st String is the Sidebar Name.<br>2nd and further are the List of items in sidebar.
	 * 
	 */
	public static String[] removeSidebar(String[] content)
	{
		String[] elements = Arrays.copyOf(content, 16);

		if(elements[0] == null)
			elements[0] = "Unamed board";

		if(elements[0].length() > 32)
			elements[0] = elements[0].substring(0, 32);

		for(int i = 1; i < elements.length; i++)
			if(elements[i] != null)
				if(elements[i].length() > 40)
					elements[i] = elements[i].substring(0, 40);

		return elements;
	}
	
	/**
	 * <h1>
	 * 	Code created by WinterGuardian
	 * 	<br>
	 * 	</br>
	 * 	https://www.spigotmc.org/resources/easyscoreboards-for-programmers.10823/
	 * </h1>
	 * <br>
	 * 
	 * @author WinterGuardian
	 * @param p Player to show the sidebar to.
	 * @param elements 1st String is the Sidebar Name.<br>2nd and further are the List of items in sidebar.
	 * 
	 */
	public static boolean showSidebarDisplay(Player p, String... elements)
	{
		elements = removeSidebar(elements);
		try
		{
			if(p.getScoreboard() == null || p.getScoreboard() == Bukkit.getScoreboardManager().getMainScoreboard() || p.getScoreboard().getObjectives().size() != 1)
			{
				p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
			}

			if(p.getScoreboard().getObjective(p.getUniqueId().toString().substring(0, 16)) == null)
			{
				p.getScoreboard().registerNewObjective(p.getUniqueId().toString().substring(0, 16), "dummy");
				p.getScoreboard().getObjective(p.getUniqueId().toString().substring(0, 16)).setDisplaySlot(DisplaySlot.SIDEBAR);
			}



			p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(elements[0]);

			for(int i = 1; i < elements.length; i++)
				if(elements[i] != null)
					if(p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore(elements[i]).getScore() != 16 - i)
					{
						p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore(elements[i]).setScore(16 - i);
						for(String string : p.getScoreboard().getEntries())
							if(p.getScoreboard().getObjective(p.getUniqueId().toString().substring(0, 16)).getScore(string).getScore() == 16 - i)
								if(!string.equals(elements[i]))
									p.getScoreboard().resetScores(string);

					}

			for(String entry : p.getScoreboard().getEntries())
			{
				boolean toErase = true;
				for(String element : elements)
				{
					if(element != null && element.equals(entry) && p.getScoreboard().getObjective(p.getUniqueId().toString().substring(0, 16)).getScore(entry).getScore() == 16 - Arrays.asList(elements).indexOf(element))
					{
						toErase = false;
						break;
					}
				}

				if(toErase)
					p.getScoreboard().resetScores(entry);

			}

			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
}