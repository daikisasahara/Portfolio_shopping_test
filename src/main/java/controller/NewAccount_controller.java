package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao_user;



// 新規会員登録成功かを、処理するコントロール

@WebServlet( "/newAccount_controller" )
public class NewAccount_controller extends HttpServlet{
	
	
	protected void doPost( HttpServletRequest req , HttpServletResponse res ) 
			throws ServletException , IOException
	{
		
		res.setContentType( "text/html; charset=UTF-8" );
		
		// 受けたリクエストを utf-8 に変換 
		// → データベース( LOGIN_USER )にインサートした際のデータベース上の文字化けを防ぐ
		req.setCharacterEncoding( "utf-8" ) ;
		
		
		PrintWriter out = res.getWriter() ;
		
		
		try {
			
			String email = req.getParameter( "email" ) ;
			String pass = req.getParameter( "pass" ) ;
			String name = req.getParameter( "name" ) ;
			String address = req.getParameter( "address" ) ;
			
			
			// 受け取った情報を、データベース( LOGIN_USER )にインサートする
			int count = 0 ;
			
			count = Dao_user.insert( email , pass , name , address ) ;
			
			
			String msg = "" ;
			
			
			// count が 1 なら会員登録成功のメッセージを送る
			if( count == 1 ) {
				
				msg = "会員登録に成功しました。ログインページより再度ログインをお願いします。" ;
			}
			else {
				msg = "会員登録に失敗しました。ログインページより最初からやり直してください。" ;
			}
			
			req.setAttribute( "msg" , msg ) ;
			
			
			req.getRequestDispatcher( "result_new_account.jsp" ).forward( req , res ) ;
			
			
		}
		catch( Exception e ){
			out.println( "SystemError --- NewAccount_controller ---" ) ;
			out.println( e ) ;
		}
		finally{
			out.println( "データベースへの接続を切断しました。" );
		}
	
	}
	
	
	
	
	
	
	
}




