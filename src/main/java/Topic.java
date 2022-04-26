package main.java;

import java.util.List;

public class Topic {
	private String title;
	private String content;
	private List<String> coments;
	
	public Topic(String title, String content) {
		this.setTitle(title);
		this.setContent(content);
	}
	
	public void addComent(String newComment) {
		coments.add(newComment);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
