package model;




//database「 USER_HISTORY 」の内容
public class History {
	
	
	
	private int orderId ;
	private String detailId ;
	private String productId ;
	private int order_num ;
	private String boughtDay ;
	
	
	
	
	public History(int orderId, String detailId, String productId, int order_num, String boughtDay) {
		setOrderId(orderId);
		setDetailId(detailId);
		setProductId(productId);
		setOrder_num(order_num);
		setBoughtDay(boughtDay);
	}
	
	
	
	
	public int getOrderId() {
		return orderId;
	}
	public String getDetailId() {
		return detailId;
	}
	public String getProductId() {
		return productId;
	}
	public int getOrder_num() {
		return order_num;
	}
	public String getBoughtDay() {
		return boughtDay;
	}
	
	
	
	
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public void setBoughtDay(String boughtDay) {
		this.boughtDay = boughtDay;
	}
	
	
	
	
	
	
	
	
	
	
	
}






