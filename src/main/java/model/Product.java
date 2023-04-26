package model;




//database「 PRODUCT_LIST 」の内容
public class Product {
	
	
	
	private String productId ;
	private String name ;
	private int price ;
	private String volume_size ;
	private String text ;
	
	
	
	
	public Product() {
		setProductId(productId);
		setName(name);
		setPrice(price);
		setVolume_size(volume_size);
		setText(text);
	}
	public Product(String productId, String name, int price, String volume_size, String text) {
		setProductId(productId);
		setName(name);
		setPrice(price);
		setVolume_size(volume_size);
		setText(text);
	}
	
	
	
	
	public String getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getVolume_size() {
		return volume_size;
	}
	public String getText() {
		return text;
	}
	
	
	
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setVolume_size(String volume_size) {
		this.volume_size = volume_size;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
	
	
	
}




