package com.online.lakeshoremarket.representation.generic;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Link")
public class Link {
	
	private String rel;
	private String href;
	private String type;
	
	public Link() {}
	
	public Link(String rel, String href, String type) {
		this.rel = rel;
		this.href = href;
		this.type = type;
	}
	@XmlAttribute
	public String getAction() {
		return rel;
	}
	public void setAction(String action) {
		this.rel = action;
	}
	@XmlAttribute
	public String getUrl() {
		return href;
	}
	public void setUrl(String url) {
		this.href = url;
	}
	@XmlAttribute
	public String getMediaType() {
		return type;
	}

	public void setMediaType(String mediaType) {
		this.type = mediaType;
	}
	
}
