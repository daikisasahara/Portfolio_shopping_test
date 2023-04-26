package model;



// 買い物かご内の情報を管理する用のクラス
public class Order {
	
	
	
	// 買い物かごに追加された商品の情報
	private Product product ;
	
	
	// 買い物かごに追加した商品の購入数
	private int amount ;
	
	
	// 買い物かごに追加した商品の合計金額
	private int totalPlice ;
	
	
	
	
	public Order() {
		
		setProduct(product);
		setAmount(amount);
	}
	public Order(Product product) {
		
		// 購入数が指定されていなければ、買い物かごに追加した商品の購入数を 1個 とする
		this( product , 1 ) ;
	}
	public Order(Product product, int amount) {
		
		setProduct(product);
		setAmount(amount);
	}
	
	
	
	
	public Product getProduct() {
		return product;
	}
	public int getAmount() {
		return amount;
	}
	public int getTotalPlice() {
		return totalPlice;
	}
	
	
	
	
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setTotalPlice(int totalPlice) {
		this.totalPlice = totalPlice;
	}
	
	
	
	
	// 買い物かご内にある商品の購入数を増やすメソッド
	public void increase( int amount ) {
		
		setAmount( getAmount() + amount ) ;
	}
	
	
	
	
	// 買い物かごに追加済みの商品と、新たに追加された商品( 引数で渡された商品 )が同じであるかどうかの判定メソッド
	//  例 ) 買い物かごに「リンゴ」が入っている状態で、あとから「リンゴ」を追加 → true が返される
	public boolean contains( Product product ) {
		
		return getProduct().equals( product ) ;
	}
	
	
	
	
	// equalsメソッドのオーバーライド
	public boolean equals( Object obj ) {
		
		Order order = null ;
		
		try {
			
			// 引数が Object型 → Orderにキャストできない場合への対処としての try-catch処理
			order = ( Order ) obj ;
			
		}
		catch( Exception e ) {
			
			e.printStackTrace() ;
		}
		finally {
			
			System.out.println( "Order-equalsMethod-error" );
		}
		
		return getProduct().getProductId().equals( order.getProduct().getProductId() ) ;
		
		
	}
	
	
	
	
	// hashCodeメソッドのオーバーライド
	public int hashCode() {
		
		return getProduct().getProductId().hashCode() ;
	}
	
	
	
	
	
	
}







