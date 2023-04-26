package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





// すべてのセッションスコープを削除し、ログイン画面への遷移処理を行うコントロール

@WebServlet( "/log_out_controller" )
public class Log_out_controller extends HttpServlet{
	
	
	
	protected void doGet( HttpServletRequest req , HttpServletResponse res ) 
			throws ServletException , IOException
	{
		
		res.setContentType( "text/html; charset=UTF-8" );
		req.setCharacterEncoding( "utf-8" ) ;
		
		
		HttpSession ses = req.getSession() ;
		
		
		
		// セッションインスタンスを削除
		ses.invalidate() ;
		
		
		req.getRequestDispatcher( "index.html" ).forward( req , res ) ;
		
		
		
	}
	
	
	
	
	
	
	
}




