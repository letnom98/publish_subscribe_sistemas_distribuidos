package main.java;

import java.io.Serializable;
import java.util.List;

public class Channel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8103427165286100960L;
	private String name;
	private String owner;
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
