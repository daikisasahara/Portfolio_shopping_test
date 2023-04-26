package model;

// database「 LOGIN_USER 」の内容
public class User {
	
	
	
	private String mailaddress ;
	private String password ;
	private String name ;
	private String address ;
	
	
	
	
	public User() {
		setMailaddress(mailaddress);
		setPassword(password);
		setName(name);
		setAddress(address);
	}
	public User(String mailaddress, String password, String name, String address) {
		setMailaddress(mailaddress);
		setPassword(password);
		setName(name);
		setAddress(address);
	}
	
	
	
	
	public String getMailaddress() {
		return mailaddress;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	
	
	
	
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	
	
	
	
	
	
}







