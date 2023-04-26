package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao_user;



// メールアドレスとパスワードを受け取り、パスワードの更新を行うコントロール

@WebServlet( "/update_name_controller" )
public class Update_name_controller extends HttpServlet{
	
	
	
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
			String name = req.getParameter( "name" ) ;
			
			
			// 受け取ったメアドと新たなユーザー名義を引数に、データベース( LOGIN_USER )の氏名を更新する
			int count = 0 ;
			
			count = Dao_user.update_name( name , email ) ;
			
			
			String msg = "" ;
			
			
			// count が 1 なら更新成功のメッセージを送る
			if( count == 1 ) {
				
				msg = "お客様名義更新に成功しました。ログインページより再度ログインをお願いします。" ;
			}
			else {
				msg = "お客様名義更新に失敗しました。ログインページより最初からやり直してください。" ;
			}
			
			req.setAttribute( "msg" , msg ) ;
			
			
			req.getRequestDispatcher( "result_update_user.jsp" ).forward( req , res ) ;
			
			
		}
		catch( Exception e ){
			out.println( "SystemError --- Update_email_controller ---" ) ;
			out.println( e ) ;
		}
		finally{
			out.println( "データベースへの接続を切断しました。" );
		}
	
	}
	
	
	
	
	
	
	
	
	
}







