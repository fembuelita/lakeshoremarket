package com.online.lakeshoremarket.model.taxonomy;

/**
 * instantiates the taxonomy interface to represent the taxonomy model
 *
 */
public class TaxonomyImpl {

	private int taxonomyID;
	private String taxonomyName;
	private String slug;
	
	
	public int getTaxonomyID() {
		return taxonomyID;
	}
	public void setTaxonomyID(int taxonomyID) {
		this.taxonomyID = taxonomyID;
	}
	public String getTaxonomyName() {
		return taxonomyName;
	}
	public void setTaxonomyName(String taxonomyName) {
		this.taxonomyName = taxonomyName;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	
}
