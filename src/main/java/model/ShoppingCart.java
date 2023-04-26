package model;

import java.util.ArrayList;
import java.util.Iterator;




// 買い物かご用のクラス、interface cart を実装
public class ShoppingCart implements Cart{
	
	
	
	// ジェネリクス Order型の ArrayList orderList( 買い物かご内の商品( 注文 )一覧 )
	// → has-a の関係
	private ArrayList< Order > orderList = new ArrayList< Order >() ;
	
	
	
	// 買い物かご内に商品を追加するメソッド
	public void add( Product product , int num ) {
		
		
		// orderListの中にある商品と、引数で受け取った商品( product )が同じ商品かをチェックする
		
		int position = 0 ;
		
		if( ( position = orderList.indexOf( new Order( product ) ) ) > -1 )  {
			
			
			// 1) orderListの中にある商品と、引数で受け取った商品( product )が同じなら、
			//    その product に対する購入数を増やす。
			Order order = orderList.get( position ) ;
			order.increase( num ) ;
			
		}
		else {
			
			// 2) orderListの中にある商品と、引数で受け取った商品( product )が異なるなら、
			//    新たに、Order をインスタンス化して、買い物かご内の商品( 注文 )一覧に追加する。
			orderList.add( new Order( product , num ) ) ;
			
		}
		
		
	}
	
	
	
	// orderList を返すメソッド
	public Iterator< Order > iterator() {
		
		return orderList.iterator() ;
	}
	
	
	
	// 買い物かごのサイズ( 商品の種類数、長さ )を返すメソッド
	public int size() {
		
		return orderList.size() ;
	}
	
	
	
	// 買い物かごに追加済みの商品一覧から、引数で受け取った番号番目の商品を削除するメソッド
	// ( 例： canselNum 番目の商品を、orderList から削除する )
	public void remove( int canselNum ) {
		
        orderList.remove( canselNum ) ;
	}
	
	
	
	
	
	
	
}





