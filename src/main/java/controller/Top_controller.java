package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dao_product;
import model.Product;
import model.ShoppingCart;




@WebServlet( "/top_controller" )
public class Top_controller extends HttpServlet{
	
	
	
	protected void doGet( HttpServletRequest req , HttpServletResponse res ) 
			throws ServletException , IOException
	{
		
		res.setContentType( "text/html; charset=UTF-8" );
		req.setCharacterEncoding( "utf-8" ) ;
		
		
		HttpSession ses = req.getSession() ;
		
		PrintWriter out = res.getWriter() ;
		
		
		try {
			
			int num = 0 ;
			
			String product = "" ;
			
			
			// 受け取った商品の購入量を代入( 例：1 )
			num = Integer.parseInt( req.getParameter( "num" ) ) ;
			
			
			// 受け取った、商品IDを代入( 例：FOOD_01 )
			product = req.getParameter( "product" ) ;
			
			
			// セッションにセットしていた shoppingCart を取得
			ShoppingCart shoppingCart = ( ShoppingCart ) ses.getAttribute( "shoppingCart" ) ;
			
			
			// マイページから「一括削除ボタン」を入力した or 決済終了後に再度買い物を行う際の対処
			if( shoppingCart == null ) {
				
				shoppingCart = new ShoppingCart() ;
				
				ses.setAttribute( "shoppingCart" , shoppingCart ) ;
			}
			
			
			// 商品IDを引数に、商品情報( Product型 pro )を取得
			Product pro = Dao_product.serch_prodId( product ) ;
			
			
			// 買い物かご( shoppingCart )に商品( pro )と購入数( num )を追加
			shoppingCart.add( pro , num ) ;
			
			
			
			// かごに追加か、すぐ購入かを代入( 例：すぐに購入へ )
			String submit = req.getParameter( "submit" ) ;
			
			String url  = "" ;
			
			
			if( "すぐに購入へ".equals( submit ) ) {
				
				url = "payment.jsp" ;
			}
			else {
				url = "check.jsp" ;
			}
			
			
			res.sendRedirect( url ) ;
			
			
		}
		catch( Exception e ){
			out.println( "SystemError --- Top_controller ---" ) ;
			out.println( e ) ;
		}
		finally{
			out.println( "データベースへの接続を切断しました。" );
		}
		
		
		
		
	}
	
	
	
	
	
	
	
}




