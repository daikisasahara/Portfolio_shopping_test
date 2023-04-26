package test;

import java.util.HashMap;

import model.Dao_product;
import model.Product;

public class Test_map {

	public static void main(String[] args) {
		
		
		
		HashMap< Product , Integer > cartList = new HashMap< Product , Integer >() ;
		
		Product p1 = Dao_product.serch_prodId( "FOOD_01" ) ;
		Product p2 = Dao_product.serch_prodId( "FOOD_02" ) ;
		Product p3 = Dao_product.serch_prodId( "FOOD_03" ) ;
		
		cartList.put( p1 , 1 ) ;
		cartList.put( p2 , 1 ) ;
		cartList.put( p3 , 1 ) ;
		
		cartList.remove( p1 ) ;
		
		for( Product key : cartList.keySet() ) {
			int num = cartList.get( key ) ;
			System.out.println( key.getName() + "の購入数：" + num + "個" );
		}
		
		
		System.out.println( cartList.get(p3) );
		
		
	}

}
