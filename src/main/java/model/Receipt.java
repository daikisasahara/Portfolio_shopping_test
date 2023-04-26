package model;

public class Receipt {
	
	
	
	private int order_id ;
	private String mail_address ;
	
	
	
	
	public Receipt() {
		setOrder_id(order_id);
		setMail_address(mail_address);
	}
	public Receipt(int order_id, String mail_address) {
		setOrder_id(order_id);
		setMail_address(mail_address);
	}
	
	
	
	
	public int getOrder_id() {
		return order_id;
	}
	public String getMail_address() {
		return mail_address;
	}
	
	
	
	
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}
	
	
	
	
	
	
	
}








