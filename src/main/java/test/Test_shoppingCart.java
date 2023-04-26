package test;

import java.util.Iterator;

import model.Dao_product;
import model.Order;
import model.Product;
import model.ShoppingCart;

public class Test_shoppingCart {

	public static void main(String[] args) {
		
		
		Product pro1 = new Product() ;
		pro1.setProductId( "FOOD_01" );
		
		
		Product pro2 = new Product() ;
		pro2.setProductId( "FOOD_01" );
		
		
		
		Product product1 = Dao_product.serch_prodId( pro1.getProductId() ) ;
		Product product2 = Dao_product.serch_prodId( pro2.getProductId() ) ;
		
		
		ShoppingCart shoppingCart = new ShoppingCart() ;
		
		
		shoppingCart.add( product1 , 2 ) ;
		
		shoppingCart.add( product2 , 1 ) ;
		
		
		Iterator<Order> it = shoppingCart.iterator() ;
		
		while( it.hasNext() ) {
			
			Order o = it.next() ;
			
			System.out.println( "商品名：" + o.getProduct().getName() );
			System.out.println( "購入数：" + o.getAmount() );
		}
		
		
		
		
	}
	
	
	

}
