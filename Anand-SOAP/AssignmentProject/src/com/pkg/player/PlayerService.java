package com.pkg.player;

public interface PlayerService {
	
	public String addPlayer(Player p);
	
	public String updatePlayer(Player player);
	
	public String deletePlayer(int id);
	
	public Player getPlayer(int id);
	
	public Player[] getAllPlayers();
}
