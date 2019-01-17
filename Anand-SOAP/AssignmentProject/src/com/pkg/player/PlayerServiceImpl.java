package com.pkg.player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayerServiceImpl implements PlayerService{

	private static Map<Integer,Player> players = new HashMap<Integer,Player>();
	
	
	@Override
	public String addPlayer(Player p) {
		if(players.get(p.getId()) != null) {
			return "Already Player exist !!!!";
		}
		else{
			players.put(p.getId(), p);
		}
		return p.getId() + "- Added!!!";
	}

	@Override
	public String updatePlayer(Player player) {
		// TODO Auto-generated method stub
		if(players.get(player.getId()) == null) {
			System.out.println(players.get(player.getId()));
			System.out.println(player.getId());
			return "No such player !!!!";
		}
		else {
			System.out.println(players.get(player.getId()));
			players.get(player.getId()).setName(player.getName());
			players.get(player.getId()).setGame(player.getGame());
			players.get(player.getId()).setAge(player.getAge());
			System.out.println(players.get(player.getId()));
			
		}
		
		return player.getId() + " Updated !!!";
	}
	
	@Override
	public String deletePlayer(int id) {
		if(players.get(id) == null) {
			return "No Such Player !!!";
		}
		else {
			players.remove(id);
		}
		return id + " deleted !!!";
	}

	@Override
	public Player getPlayer(int id) {
		return players.get(id);
	}

	@Override
	public Player[] getAllPlayers() {
		Set<Integer> ids = players.keySet();
		Player[] p = new Player[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = players.get(id);
			i++;
		}
		return p;
	}

	
}
