package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




// 決済完了後、買い物かご( shoppingCart )の商品を削除し、top.jsp へ遷移する処理を行うコントロール

@WebServlet( "/finish_controller" )
public class Finish_controller extends HttpServlet{
	
	
	
	protected void doGet( HttpServletRequest req , HttpServletResponse res ) 
			throws ServletException , IOException
	{
		
		res.setContentType( "text/html; charset=UTF-8" );
		res.setCharacterEncoding( "utf-8" ) ;
		
		
		HttpSession ses = req.getSession() ;
		
		ses.removeAttribute( "shoppingCart" ) ;
		
		req.getRequestDispatcher( "top.jsp" ).forward( req , res ) ;
		
		
	
	}
	
	
	
	
	
	
}






