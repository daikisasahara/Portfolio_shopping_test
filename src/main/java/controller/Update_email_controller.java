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

@WebServlet( "/update_email_controller" )
public class Update_email_controller extends HttpServlet{
	
	
	
	protected void doPost( HttpServletRequest req , HttpServletResponse res ) 
			throws ServletException , IOException
	{
		
		res.setContentType( "text/html; charset=UTF-8" );
		
		// 受けたリクエストを utf-8 に変換 
		// → データベース( LOGIN_USER )にインサートした際のデータベース上の文字化けを防ぐ
		req.setCharacterEncoding( "utf-8" ) ;
		
		
		PrintWriter out = res.getWriter() ;
		
		
		try {
			
			String old_email = req.getParameter( "old_email" ) ;
			String new_email = req.getParameter( "new_email" ) ;
			
			
			// 受け取ったパスワードとメアドを引数に、データベース( LOGIN_USER )のパスワードを更新する
			int count = 0 ;
			
			count = Dao_user.update_mailaddress( new_email , old_email ) ;
			
			
			String msg = "" ;
			
			
			// count が 1 なら更新成功のメッセージを送る
			if( count == 1 ) {
				
				msg = "メールアドレス更新に成功しました。ログインページより再度ログインをお願いします。" ;
			}
			else {
				msg = "メールアドレス更新に失敗しました。ログインページより最初からやり直してください。" ;
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







