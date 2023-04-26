package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_user {
	
	
	
	private static String url = "jdbc:h2:tcp://localhost/~/test" ;
	private static String user_name = "sa" ;
	private static String password = "" ;
	
	
	
	
	// ユーザーのメールアドレスを引数に、データベース( LOGIN_USER )からユーザーの情報を取得するメソッド
	public static User serch_mail_address( String input ) {
		
		
		String sql = "select * from login_user where mail_address like ?" ;
		
		
		User user = null ;
		
		
		try ( Connection con = DriverManager.getConnection( url , user_name , password ) ;
			   PreparedStatement ps = con.prepareStatement( sql ) ; 
		){
			System.out.println( "\nデータベースへの接続が成功しました。" );
			
			
			ps.setString( 1 , input ) ;
			
			ResultSet rs = ps.executeQuery() ;
			
			while( rs.next() ) {
				String email  = rs.getString( "mail_address" ) ;
				String pass = rs.getString( "password" ) ;
				String name = rs.getString( "name" ) ;
				String address = rs.getString( "address" ) ;
				
				// datebase 「 login_user 」の情報を取得、インスタンス化
				user = new User( email , pass , name , address ) ;
			}
		}
		catch( SQLException e1 ){
			System.out.println( "SQLによるデータベースへの送信エラーが発生しました。" );
			e1.printStackTrace();
		}
		catch( Exception e2 ){
			System.out.println( "予期せぬエラーが発生しました。" );
			e2.printStackTrace();
		}
		finally{
			System.out.println( "データベースへの接続を切断しました。" );
		}
		
		return user ;
	}
	
	
	
	
	// 新規登録したログインユーザーの情報をデータベース( LOGIN_USER )にインサートするメソッド
	public static int insert( String mail , String pass , String name , String address ) {
		
		int count = 0 ;
		
		String sql = 
		"insert into login_user ( mail_address , password , name , address ) values ( ? , ? , ? , ? )" ;
		
		try ( Connection con = DriverManager.getConnection( url , user_name , password ) ;
			   PreparedStatement ps = con.prepareStatement( sql ) ; 
		){
			
			System.out.println( "\nデータベースへの接続が成功しました。" );
			
			ps.setString( 1 , mail ) ;
			ps.setString( 2 , pass ) ;
			ps.setString( 3 , name ) ;
			ps.setString( 4 , address ) ;
			
			count = ps.executeUpdate() ;
		}
		catch( SQLException e1 ){
			System.out.println( "SQLによるデータベースへの送信エラーが発生しました。" );
			e1.printStackTrace();
		}
		catch( Exception e2 ){
			System.out.println( "予期せぬエラーが発生しました。" );
			e2.printStackTrace();
		}
		finally{
			System.out.println( "データベースへの接続を切断しました。" );
		}
		
		return count ;
	}
	
	
	
	
	// ユーザーのパスワードとメールアドレスを引数に、パスワードを更新するメソッド
	public static int update_password ( String pass , String mail ) {
		
		int count = 0 ;
		
		String sql = "update login_user set password = ? where mail_address = ?" ;
		
		
		try ( 
			Connection con = DriverManager.getConnection( url , user_name , password ) ;
			PreparedStatement ps = con.prepareStatement( sql ) ;
		) {
			
			System.out.println( "データベースに接続しました。" ) ;
			
			ps.setString( 1 , pass ) ;
			ps.setString( 2 , mail ) ;
			
			count = ps.executeUpdate( ) ;
			
		}
		catch ( Exception e ) {
			System.out.println( e );
		}
		finally {
			System.out.println( "データベースへの接続を切断しました。" ) ;
		}
	
		return count ;
	
	}
	
	
	
	
	// ユーザーの以前のメールアドレスと新しいメールアドレスを引数に、メールアドレス( ID )を更新するメソッド
	public static int update_mailaddress ( String new_mail , String old_mail ) {
		
		int count = 0 ;
		
		String sql = "update login_user set mail_address = ? where mail_address = ?" ;
		
		
		try ( 
			Connection con = DriverManager.getConnection( url , user_name , password ) ;
			PreparedStatement ps = con.prepareStatement( sql ) ;
		) {
			
			System.out.println( "データベースに接続しました。" ) ;
			
			ps.setString( 1 , new_mail ) ;
			ps.setString( 2 , old_mail ) ;
			
			count = ps.executeUpdate( ) ;
			
		}
		catch ( Exception e ) {
			System.out.println( e );
		}
		finally {
			System.out.println( "データベースへの接続を切断しました。" ) ;
		}
	
		return count ;
	
	}
	
	
	
	
	// ユーザーのメールアドレス( ID )と変更後の名義を引数に、ユーザー名義を更新するメソッド
	public static int update_name ( String name , String email ) {
		
		int count = 0 ;
		
		String sql = "update login_user set name = ? where mail_address = ?" ;
		
		
		try ( 
			Connection con = DriverManager.getConnection( url , user_name , password ) ;
			PreparedStatement ps = con.prepareStatement( sql ) ;
		) {
			
			System.out.println( "データベースに接続しました。" ) ;
			
			ps.setString( 1 , name ) ;
			ps.setString( 2 , email ) ;
			
			count = ps.executeUpdate( ) ;
			
		}
		catch ( Exception e ) {
			System.out.println( e );
		}
		finally {
			System.out.println( "データベースへの接続を切断しました。" ) ;
		}
	
		return count ;
	
	}
	
	
	
	
	// ユーザーのメールアドレス( ID )と変更後の住所を引数に、ユーザーの住所を更新するメソッド
	public static int update_address ( String address , String email ) {
		
		int count = 0 ;
		
		String sql = "update login_user set address = ? where mail_address = ?" ;
		
		
		try ( 
			Connection con = DriverManager.getConnection( url , user_name , password ) ;
			PreparedStatement ps = con.prepareStatement( sql ) ;
		) {
			
			System.out.println( "データベースに接続しました。" ) ;
			
			ps.setString( 1 , address ) ;
			ps.setString( 2 , email ) ;
			
			count = ps.executeUpdate( ) ;
			
		}
		catch ( Exception e ) {
			System.out.println( e );
		}
		finally {
			System.out.println( "データベースへの接続を切断しました。" ) ;
		}
	
		return count ;
	
	}
	
	
	
	
	
	
	
	
}









