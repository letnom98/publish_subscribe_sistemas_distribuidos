package main.java;

import java.util.List;

public class Channel {
	//public static enum VISIBILITY{PUBLIC, PRIVATE};
	private String name;
	private String owner;
	//private VISIBILITY visibility;
	private List<String> videos;
	
	public Channel(String name, String owner) {
		this.name = name;
		this.owner = owner;
	}
	
	public void addVideo(String newVideo) {
		videos.add(newVideo);
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}

}
