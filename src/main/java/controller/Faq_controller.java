package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// 新規会員登録成功かを、処理するコントロール

@WebServlet( "/faq_controller" )
public class Faq_controller extends HttpServlet{
	
	
	protected void doPost( HttpServletRequest req , HttpServletResponse res ) 
			throws ServletException , IOException
	{
		
		res.setContentType( "text/html; charset=UTF-8" );
		
		// 受けたリクエストを utf-8 に変換 
		// → データベース( LOGIN_USER )にインサートした際のデータベース上の文字化けを防ぐ
		req.setCharacterEncoding( "utf-8" ) ;
		
		
		PrintWriter out = res.getWriter() ;
		
		
		try {
			
			int faq_no = Integer.parseInt( req.getParameter( "faq_no" ) ) ;
			
			
			// faq_no の違いによって遷移先のURLを変更する
			
			String url = "" ;
			
			if( faq_no == 1 ) {
				
				url = "update_jsp/update_mail_address.jsp" ;
			}
			else if ( faq_no == 2 ){
				
				url = "update_jsp/update_name.jsp" ;
			}
			else if ( faq_no == 3 ){
				
				url = "update_jsp/update_address.jsp" ;
			}
			else {
				return ;
			}
			
			req.getRequestDispatcher( url ).forward( req , res ) ;
			
		}
		catch( Exception e ){
			out.println( "SystemError --- Faq_controller ---" ) ;
			out.println( e ) ;
		}
		finally{
			out.println( "データベースへの接続を切断しました。" );
		}
	
	}
	
	
	
	
	
	
	
}




