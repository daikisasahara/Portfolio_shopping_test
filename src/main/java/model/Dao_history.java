package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao_history {
	
	
	
	private static String url = "jdbc:h2:tcp://localhost/~/test" ;
	private static String user_name = "sa" ;
	private static String password = "" ;
	
	
	
	// ログインしているユーザーの購入結果をデータベース( USER_HISTORY )にインサートするメソッド
	public static int insert( int order_id , String detail_id , String product_id , int order_num , String bought_day ) {
		
		int count = 0 ;
		String sql = 
		"insert into user_history ( order_id , detail_id , product_id , order_num , bought_day ) values ( ? , ? , ? , ? , ? )" ;
		
		try ( Connection con = DriverManager.getConnection( url , user_name , password ) ;
			   PreparedStatement ps = con.prepareStatement( sql ) ; 
		){
			System.out.println( "\nデータベースへの接続が成功しました。" );
			
			ps.setInt( 1 , order_id ) ;
			ps.setString( 2 , detail_id ) ;
			ps.setString( 3 , product_id ) ;
			ps.setInt( 4 , order_num ) ;
			ps.setString( 5 , bought_day ) ;
			
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
	
	
	
	
	// ログインしているユーザーの購入履歴をユーザーのメールアドレス( ID )を引数に、データベース( USER_HISTORY )から取得するメソッド
	public static ArrayList < History > serch_cartId( String id ) {
		
		ArrayList < History > list = new ArrayList < History > ( ) ;
		
		String sql = 
		"select * from receipt inner join user_history on receipt.order_id = user_history.order_id where mail_address like ?" ;
		
		
		try ( 
			Connection con = DriverManager.getConnection( url , user_name , password ) ;
			PreparedStatement ps = con.prepareStatement( sql ) ;
			) {
				
				System.out.println( "データベースに接続しました。" ) ;
				
				ps.setString( 1 , id ) ;
				ResultSet rs = ps.executeQuery() ;
				
				while( rs.next( ) ){
					
					int o_id = rs.getInt( "order_id" ) ;
					String d_id = rs.getString( "detail_id" ) ;
					String p_id = rs.getString( "product_id" ) ;
					int n = rs.getInt( "order_num" ) ;
					String b_day = rs.getString( "bought_day" ) ;
					
					History his = new History( o_id , d_id , p_id , n , b_day ) ;
					list.add( his ) ;
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
		finally {
			System.out.println( "データベースへの接続を切断しました。" ) ;
		}
		
		return list ;
	}
	
	
	
	
	
	
	
	
}






