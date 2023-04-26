package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dao_history;
import model.Dao_receipt;
import model.Order;
import model.Receipt;
import model.ShoppingCart;
import model.User;




@WebServlet( "/payment_controller" )
public class Payment_controller extends HttpServlet{
	
	
	
	
	protected void doPost( HttpServletRequest req , HttpServletResponse res ) 
			throws ServletException , IOException
	{
		
		res.setContentType( "text/html; charset=UTF-8" );
		res.setCharacterEncoding( "utf-8" ) ;
		
		
		HttpSession ses = req.getSession() ;
		
		PrintWriter out = res.getWriter() ;
		
		
		try {
			// 支払方法の番号を受け取り、支払い名をリクエストにセット
			int pay_method = Integer.parseInt( req.getParameter( "pay_method" ) ) ;
			
			String pay_method_msg = "" ;
			
			if( pay_method == 1 ) {
				pay_method_msg = "クレジットカード決済でお支払いしました。" ;
			}
			else if( pay_method == 2 ) {
				pay_method_msg = "銀行ネット決済（ネットバンキング)でお支払いしました。" ;
			}
			else if( pay_method == 3 ) {
				pay_method_msg = "キャリア決済でお支払いしました。" ;
			}
			else if( pay_method == 4 ) {
				pay_method_msg = "コンビニ決済でお支払いしました。" ;
			}
			else if( pay_method == 5 ) {
				pay_method_msg = "ペイジー（Pay-easy）でお支払いしました。" ;
			}
			else {
				pay_method_msg = "プリペイド決済でお支払いしました。" ;
			}
			
			req.setAttribute( "pay_method_msg" , pay_method_msg ) ;
			
			
			
			
			// USER_HISTORY にインサートする情報( 注文ID , 売上明細ID , 商品ID , 購入数 , 購入日( 現在の日付 ) )の取得
			
			
			// 注文ID
			ArrayList < Receipt > receiptList = Dao_receipt.all_select() ;
			
			int order_id = receiptList.size() + 1 ;
			
			
			// 売上明細IDの取得のため、初期化。
			String detail_id = "" ;
			
			int digit = 12 ;
			
			
			// 商品IDの取得のため、初期化。その後、セッションにセットしていた shoppingCart を取得
			String product_id = "" ;
			
			ShoppingCart shoppingCart = ( ShoppingCart ) ses.getAttribute( "shoppingCart" ) ;
			
			
			// 購入数の取得のために初期化
			int num = 0 ;
			
			
			// 購入日( String型 date )の取得
			LocalDate now = LocalDate.now() ;
			
			LocalDate nowDate = LocalDate.of( now.getYear() , now.getMonthValue() , now.getDayOfMonth() ) ;
			
			DateTimeFormatter f = DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ;
			
			String date = f.format( nowDate ) ;
			
			
			// インサート結果( result_status )が 0 なら、決済エラーページへ
			String result_payment_url = "" ;
			
			int result_status = 0 ;
			
			
			// ログインしているユーザーのメールアドレス( ID )を引数に、レシートを会計の回数分発行( 原則 1 枚発行 )
			User user = ( User ) ses.getAttribute( "user" ) ;
			
			String mail = user.getMailaddress() ;
			
			int count = 0 ;
			
			count = Dao_receipt.insert_receipt( mail ) ;
			
			
			// レシートが発行されたなら、購入内容の印字を行う
			if( count == 1 ) {
				
				
				// 購入した商品内容をデータベース( USER_HISTORY )にインサートする( 発行したレシートに購入内容を印字する )
				
				Iterator<Order> it = shoppingCart.iterator() ;
				
				while( it.hasNext() ) {
					
					Order o = it.next() ;
					
					
					// 売上明細IDの取得( 購入した商品の種類の数だけ発行 )
					detail_id = createDetail_id( digit ) ;
					
					
					// 商品IDの取得
					product_id = o.getProduct().getProductId() ;
					
					
					// 購入数の取得
					num = o.getAmount() ;
					
					
					result_status = Dao_history.insert( order_id , detail_id , product_id , num , date ) ;
					
					
				}
				
				
			}
			else {
				result_payment_url = "payment_error.jsp" ;
			}
			
			
			
			if( result_status == 0 ) {
				
				result_payment_url = "payment_error.jsp" ;
			}
			else {
				result_payment_url = "payment_finish.jsp" ;
			}
			
			
			res.sendRedirect( result_payment_url ) ;
			
			
		}
		catch( Exception e ){
			out.println( "SystemError --- Payment_controller ---" ) ;
			out.println( e ) ;
		}
		finally{
			out.println( "データベースへの接続を切断しました。" );
		}
	
	}
	
	
	
	// 売上明細IDの桁数を引数に、売上明細IDを発行するメソッド
	public String createDetail_id( int digit ) {
		
		String detail_id = "" ;
		
        StringBuilder builder = new StringBuilder( digit ) ;
        
        
        // 売上明細IDに使用する文字種( アルファベットの大文字・小文字と数字 )
        // 0 ( ゼロは、大文字のオーと混同するので使用していない )
        String useWord = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "123456789" ;
        
        for ( int i = 0 ; i < digit ; i++ ) {
        	
        	int index = new Random().nextInt( useWord.length() ) ;
            
        	builder.append( useWord.charAt( index ) ) ; 
        } 
			
        detail_id = builder.toString() ;
        
        return detail_id ;
	}
	
	
	
	
	
}




