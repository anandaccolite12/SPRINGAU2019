package com.pkg.player;

import java.io.Serializable;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private int id;
	private String game;

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}
	
	public String getGame(){
		return game;
	}

	public void setGame(String game){
		this.game = game;
	}

	@Override
	public String toString(){
		return "Id - "+id+" *** Name - "+name+" *** Age - "+age+" *** Game - "+game;
	}

}
