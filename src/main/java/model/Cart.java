package model;

import java.util.Iterator;


// interface
// 1) すべてのメソッドは抽象メソッドである。
// 2) 原則、フィールドを持たない。

public interface Cart {
	
	
	
	// 商品とその購入量を追加する抽象メソッド
	public void add( Product product , int num ) ;
	
	
	
	// イテレーターを返すメソッド
	public Iterator< Order > iterator() ;
	
	
	
	// 買い物かごのサイズ( 商品の種類数、長さ )を返す抽象メソッド
	public int size() ;
	
	
	
	// 買い物かごに追加済みの商品一覧から、引数で受け取った番号番目の商品を削除する抽象メソッド
	// ( 例： canselNum 番目の商品を、orderList から削除する )
	public void remove( int canselNum ) ;
	
	
	
	
	
}






