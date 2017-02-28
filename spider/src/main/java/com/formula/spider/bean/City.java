/**
 * 
 */
package com.formula.spider.bean;

/**
 * @author Leon(Liu Yang) Ideas from Formula Innovation
 */
public class City {
	private String name;
	private String link;

	public City(String name, String link){
		this.name = name;
		this.link = link;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
    public String toString() {
        return "Name : " + this.name + ", link : " + this.link; 
    }
	
}
