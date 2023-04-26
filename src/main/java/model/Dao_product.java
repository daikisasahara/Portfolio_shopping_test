package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Dao_product {
	
	
	
	private static String url = "jdbc:h2:tcp://localhost/~/test" ;
	private static String user_name = "sa" ;
	private static String password = "" ;
	
	
	
	
	// 1 つの商品の情報を取得するメソッド
	public static Product serch_prodId( String product ) {
		
		Product pro = null ;
		
		
		// 厳密な現在時間の取得
		ZonedDateTime now = ZonedDateTime.now() ;
		
		int hour = now.getHour() ;
		
		
		
		// 1) 18時から24時の間
		// 2) 引数で受け取った product が「 FOOD 」から始まる
		// → 1) と 2) を満たせば、true
		boolean foodSale = ( 18 <= hour ) && ( product.startsWith( "FOOD" ) ) ;
		
		
		
		// 1) 10時から15時( 14時台 )の間
		// 2) 引数で受け取った product が「 MOVIE 」から始まる
		// → 1) と 2) を満たせば、true
		boolean movieSale = ( 10 <= hour ) && ( hour <= 14 ) && ( product.startsWith( "MOVIE" ) ) ;
		
		
		
		// 割引率( 商品価格に掛ける数 )
		// 例) 2割引で販売したいので、商品価格に「 0.8 」掛ければいい
		double saleRate = 0.8 ;
		
		
		String sql = "select * from product_list where product_id like ?" ;
		
		
		try ( 
			Connection con = DriverManager.getConnection( url , user_name , password ) ;
			PreparedStatement ps = con.prepareStatement( sql ) ;
			) {
				
				System.out.println( "データベースに接続しました。" ) ;
				
				ps.setString( 1 , product ) ;
				ResultSet rs = ps.executeQuery() ;
				
				
				while( rs.next( ) ){
					
					String id = rs.getString( "product_id" ) ;
					String name = rs.getString( "name" ) ;
					
					int price = rs.getInt( "price" ) ;
					
					
					// タイムセールの処理( foodSale または、 movieSale が true なら実行される処理 )
					if( ( foodSale ) || ( movieSale ) ) {
						price =  (int) ( price * saleRate ) ;
					}
					
					String v_s = rs.getString( "volume_size" ) ;
					String text = rs.getString( "text" ) ;
					
					
					pro = new Product( id , name , price , v_s , text ) ;
					
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
		
		return pro ;
	}
	
	
	
	
	// 商品IDを引数に、買い物かごに入っているすべての商品情報を取得するメソッド
	public static ArrayList < Product > serch_productId( String input ) {
		
		
		ArrayList < Product > list = new ArrayList < Product > ( ) ;
		String sql = "select * from product_list where product_id like ?" ;
		
		
		try ( 
			Connection con = DriverManager.getConnection( url , user_name , password ) ;
			PreparedStatement ps = con.prepareStatement( sql ) ;
			) {
				
				System.out.println( "データベースに接続しました。" ) ;
				
				ps.setString( 1 , input ) ;
				ResultSet rs = ps.executeQuery() ;
				
				while( rs.next( ) ){
					
					String id = rs.getString( "product_id" ) ;
					String name = rs.getString( "name" ) ;
					int price = rs.getInt( "price" ) ;
					String v_s = rs.getString( "volume_size" ) ;
					String text = rs.getString( "text" ) ;
					
					Product pro = new Product( id , name , price , v_s , text ) ;
					list.add( pro ) ;
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
	
	
	
	
	// 入力されたキーワードを引数に、データベ―ス内の商品名にキーワードが含まれているか検索するメソッド
	public static ArrayList < Product > keyWord_select ( String input ) {
		
		
		ArrayList < Product > list = new ArrayList < Product > ( ) ;
		
		String sql = "select * from product_list where name like ?";
		
		
		try ( 
			Connection con = DriverManager.getConnection( url , user_name , password ) ;
			PreparedStatement ps = con.prepareStatement( sql ) ;
			) {
				
				System.out.println( "データベースに接続しました。" ) ;
				
				ps.setString( 1 , "%" + input + "%" ) ;
				
				ResultSet rs = ps.executeQuery( ) ;
				
				while( rs.next( ) ){
					
					String id = rs.getString( "product_id" ) ;
					String name = rs.getString( "name" ) ;
					int price = rs.getInt( "price" ) ;
					String v_s = rs.getString( "volume_size" ) ;
					String text = rs.getString( "text" ) ;
					
					Product pro = new Product( id , name , price , v_s , text ) ;
					list.add( pro ) ;
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







