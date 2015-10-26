package com.online.lakeshoremarket.model.taxonomy;

/**
 * represents a taxonomy in the database
 *
 */
public interface Taxonomy {

	/**
	 * gets the taxonomy id
	 * @return the id
	 */
	public int getTaxonomyID();
	
	/**
	 * sets the taxonomy id
	 * @param taxonomyID the id
	 */
	public void setTaxonomyID(int taxonomyID);
	
	/**
	 * gets the tax name
	 * @return name
	 */
	public String getTaxonomyName();
	
	/**
	 * sets the tax name
	 * @param taxonomyName name
	 */
	public void setTaxonomyName(String taxonomyName);
	
	/**
	 * gets the tax slug
	 * @return the slug
	 */
	public String getSlug();
	
	/**
	 * sets the tax slug
	 * @param slug the slug
	 */
	public void setSlug(String slug);
	
	
}
