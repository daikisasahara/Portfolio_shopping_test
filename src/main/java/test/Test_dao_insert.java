package test;



import model.Dao_user;

public class Test_dao_insert {

	public static void main(String[] args) {
		
		
		String email = "aaa@aaa.jp" ;
		String pass = "xxx" ;
		String name = "ああああ" ;
		String address = "いいいいい" ;		
		// 受け取った情報を、データベース( LOGIN_USER )にインサートする
		int count = 0 ;
		
		count = Dao_user.insert( email , pass , name , address ) ;
		
		
	}

}
