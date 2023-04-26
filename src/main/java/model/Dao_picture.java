package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_picture {
	
	
	
	private static String url = "jdbc:h2:tcp://localhost/~/test" ;
	private static String user_name = "sa" ;
	private static String password = "" ;
	
	
	
	
	// 商品IDを引数に、データベース( PICTURE_LIST )に保存している画像データを取得するメソッド
	public static Picture serch_prodId( String product ) {
		
		
		Picture pic = null ;
		
		
		String sql = "select * from picture_list where product_id like ?" ;
		
		
		try ( 
			Connection con = DriverManager.getConnection( url , user_name , password ) ;
			PreparedStatement ps = con.prepareStatement( sql ) ;
			) {
				
				System.out.println( "データベースに接続しました。" ) ;
				
				ps.setString( 1 , product ) ;
				ResultSet rs = ps.executeQuery() ;
				
				while( rs.next( ) ){
					
					String src = rs.getString( "picture_src" ) ;
					String p_id = rs.getString( "product_id" ) ;
					String alt = rs.getString( "alt" ) ;
					int width = rs.getInt( "width" ) ;
					int height = rs.getInt( "height" ) ;
					
					pic = new Picture( src , p_id , alt , width , height ) ;
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
		
		return pic ;
	}
	
	
	
	
	
	
}






