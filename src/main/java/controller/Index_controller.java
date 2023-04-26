package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dao_user;
import model.ShoppingCart;
import model.User;



// ログイン成功かどうかを、判断・処理するコントロール

@WebServlet( "/index_controller" )
public class Index_controller extends HttpServlet{
	
	
	
	protected void doPost( HttpServletRequest req , HttpServletResponse res ) 
			throws ServletException , IOException
	{
		
		res.setContentType( "text/html; charset=UTF-8" );
		res.setCharacterEncoding( "utf-8" ) ;
		
		
		HttpSession ses = req.getSession() ;
		
		PrintWriter out = res.getWriter() ;
		
		User user = null ;
		
		
		// ShoppingCart 型の shoppingCart をインスタンス化、その後セッションにセット( 買い物かごの準備 )
		ShoppingCart shoppingCart = new ShoppingCart() ;
		
		ses.setAttribute( "shoppingCart" , shoppingCart ) ;
		
		
		try {
			
			String email = req.getParameter( "email" ) ;
			String pass = req.getParameter( "pass" ) ;
			
			
			// 受け取ったメールアドレス( ID )をもとに DB から検索
			// 検索結果の User の情報を取得
			user = Dao_user.serch_mail_address( email ) ;
			
			
			// 検索結果の User型の user をセッションにセット
			ses.setAttribute( "user" , user ) ;
			
			
			
			// 遷移先画面( login_error.jsp または、top.jsp )の判定　↓
			
			String forward_url = "" ;
			String ng_page = "login_jsp/login_error.jsp" ;
			String ok_page = "top.jsp" ;
			
			
			String msg = "" ;
			
			
			// メールアドレスが未入力かどうかの判定
			if( ( email == null ) || ( email.isEmpty() ) ) {
				msg = "メールアドレスが未入力です。" ;
				forward_url = ng_page ;
			}
			// パスワードが未入力かどうかの判定
			else if( ( pass == null ) || ( pass.isEmpty() ) ) {
				msg = "パスワードが未入力です。" ;
				forward_url = ng_page ;
			}
			// メールアドレス( Dao の Serchメソッドの引数 )が登録されていないものかどうかの判定
			else if( user == null ) {
				msg = "メールアドレスが登録されていません。" ;
				forward_url = ng_page ;
			}
			// パスワードが一致しているかの判定
			else if( !( pass.equals( user.getPassword() ) ) ) {
				msg = "パスワードが一致していません。" ;
				forward_url = ng_page ;
			}
			else {
				forward_url = ok_page ;
			}
			
			
			req.setAttribute( "msg" , msg ) ;
			
			req.getRequestDispatcher( forward_url ).forward( req , res ) ;
			
			
		}
		catch( Exception e ){
			out.println( "SystemError --- Index_controller ---" ) ;
			out.println( e ) ;
		}
		finally{
			out.println( "データベースへの接続を切断しました。" );
		}
	
	}
	
	
	
	
	
	
	
}




