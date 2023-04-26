package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dao_history;
import model.History;
import model.User;




// ログインユーザーの購入履歴を取得するためのコントローラー
@WebServlet( "/history_controller" )
public class History_controller extends HttpServlet{
	
	
	
	protected void doGet( HttpServletRequest req , HttpServletResponse res ) 
			throws ServletException , IOException
	{
		
		res.setContentType( "text/html; charset=UTF-8" );
		res.setCharacterEncoding( "utf-8" ) ;
		
		
		PrintWriter out = res.getWriter() ;
		
		HttpSession ses = req.getSession() ;
		
		
		// Index_controller にてセッションに保存していた User型 user を受け取る
		User user = ( User ) ses.getAttribute( "user" ) ;
		
		
		try {
			// ログインしているユーザーが持つメールアドレス( ID )を取得
			String id = user.getMailaddress() ;
			
			
			// ログインしているユーザーが持つメールアドレス( ID )を引数に、購入履歴をデータベース( USER_HISTORY )から取得
			ArrayList < History > list = Dao_history.serch_cartId( id ) ;
			
			
			// 取得した購入履歴が null or 空っぽならエラーページへ遷移
			// 購入履歴検索の結果メッセージをリクエストにセット
			
			String url = "" ;
			
			String historyMsg = "" ;
			
			if( ( list == null ) || ( list.isEmpty() ) ) {
				
				historyMsg = "お客様の購入履歴はございません。" ;
				
				req.setAttribute( "historyMsg" , historyMsg ) ;
				url = "history_error.jsp" ;
			}
			else {
				
				historyMsg = "お客様の購入履歴は以下の通りです。" ;
				
				req.setAttribute( "historyMsg" , historyMsg ) ;
				req.setAttribute( "list" , list ) ;
				url = "history.jsp" ;
			}
			
			
			req.getRequestDispatcher( url ).forward( req , res ) ;
			
			
		}
		catch( Exception e ){
			out.println( "SystemError --- History_controller ---" ) ;
			out.println( e ) ;
		}
		finally{
			out.println( "データベースへの接続を切断しました。" );
		}
		
		
		
	
	}
	
	
	
	
	
	
	
}




