package model;

public class Picture {
	
	
	
	private String picture_src ;
	private String product_id ;
	private String alt ;
	private int width ;
	private int height ;
	
	
	
	
	public Picture() {
		setPicture_src(picture_src);
		setProduct_id(product_id);
		setAlt(alt);
		setWidth(width);
		setHeight(height);
	}
	public Picture(String picture_src, String product_id, String alt, int width, int height) {
		setPicture_src(picture_src);
		setProduct_id(product_id);
		setAlt(alt);
		setWidth(width);
		setHeight(height);
	}
	
	
	
	
	public String getPicture_src() {
		return picture_src;
	}
	public String getProduct_id() {
		return product_id;
	}
	public String getAlt() {
		return alt;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	
	
	
	public void setPicture_src(String picture_src) {
		this.picture_src = picture_src;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	
	
	
	
}







