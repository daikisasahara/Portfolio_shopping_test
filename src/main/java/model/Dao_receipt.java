package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao_receipt {
	
	
	
	private static String url = "jdbc:h2:tcp://localhost/~/test" ;
	private static String user_name = "sa" ;
	private static String password = "" ;
	
	
	
	
	
	public static ArrayList < Receipt > all_select ( ) {
		
		
		ArrayList < Receipt > list = new ArrayList < Receipt > ( ) ;
		String sql = "select * from receipt" ;
		
		
		try ( 
			Connection con = DriverManager.getConnection( url , user_name , password ) ;
			PreparedStatement ps = con.prepareStatement( sql ) ;
		) {
			
			System.out.println( "データベースに接続しました。" ) ;
			
			ResultSet rs = ps.executeQuery( ) ;
			
			while( rs.next( ) ){
				
				int o_id = rs.getInt( "order_id" ) ;
				String m_address = rs.getString( "mail_address" ) ;
				
				Receipt rec = new Receipt( o_id , m_address ) ;
				list.add( rec ) ;	
			}
		}
		catch ( Exception e ) {
			System.out.println( e );
		}
		finally {
			System.out.println( "データベースへの接続を切断しました。" ) ;
		}
		
		return list ;
		
	}
	
	
	
	
	// ログインしているユーザーの購入結果をデータベース( USER_HISTORY )にインサートするメソッド
	public static int insert_receipt( String m_address ) {
		
		int count = 0 ;
		String sql = 
		"insert into receipt ( mail_address ) values ( ? )" ;
		
		try ( Connection con = DriverManager.getConnection( url , user_name , password ) ;
			   PreparedStatement ps = con.prepareStatement( sql ) ; 
		){
			System.out.println( "\nデータベースへの接続が成功しました。" );
			
			ps.setString( 1 , m_address ) ;
			
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
	
	
	
}









