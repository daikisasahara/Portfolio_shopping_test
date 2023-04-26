package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ShoppingCart;



// 買い物かご( cartList )から商品を削除した際の処理を行うコントロール

@WebServlet( "/cansel_controller" )
public class Cansel_controller extends HttpServlet{
	
	
	
	protected void doGet( HttpServletRequest req , HttpServletResponse res ) 
			throws ServletException , IOException
	{
		
		res.setContentType( "text/html; charset=UTF-8" );
		res.setCharacterEncoding( "utf-8" ) ;
		
		
		HttpSession ses = req.getSession() ;
		
		
		try {
			
			// 削除ボタンによって送られた買い物かご番号を受け取る
			int cansel_num =  Integer.parseInt( req.getParameter( "cansel_num" ) ) ;
			
			
			ShoppingCart shoppingCart = ( ShoppingCart ) ses.getAttribute( "shoppingCart" ) ;
			
			
			// 受け取った買い物かご番号に対応する商品を、買い物かごから削除
			shoppingCart.remove( cansel_num ) ;
			
			
			// お買い物かご( cartList )の中身を削除して、空っぽになった場合はトップ画面に遷移する
			
			String url = "" ;
			
			if( shoppingCart.size() == 0 ) {
				
				url = "top.jsp" ;
			}
			else {
				url = "my_page.jsp" ;
			}
			
			
			req.getRequestDispatcher( url ).forward( req , res ) ;
			
			
		}
		catch( Exception e ){
			PrintWriter out = res.getWriter() ;
			out.println( "SystemError --- Cansel_controller ---" ) ;
			out.println( e ) ;
		}
		
		
		
		
		
	}
	
	
	
	
	
}




