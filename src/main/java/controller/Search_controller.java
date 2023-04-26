package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao_product;
import model.Product;



// キーワード検索の結果を処理するコントロール
@WebServlet( "/search_controller" )
public class Search_controller extends HttpServlet{
	
	
	
	protected void doGet( HttpServletRequest req , HttpServletResponse res ) 
			throws ServletException , IOException
	{
		
		res.setContentType( "text/html; charset=UTF-8" );
		res.setCharacterEncoding( "utf-8" ) ;
		
		PrintWriter out = res.getWriter() ;
		
		
		try {
			
			ArrayList < Product > list ;
			
			
			// キーワード検索から入力された文字を取得
			String keyWord = req.getParameter( "key_word" ) ;
			
			
			// key_word が空文字( 何も入力されていない )なら、list を null とする
			if( keyWord.isEmpty() ) {
				
				list = null ;
			}
			
			// key_word が空文字ではないなら、keyWord を引数に、商品名に key_word を含むか検索
			else {
				
				list = Dao_product.keyWord_select( keyWord ) ;
			}
			
			
			req.setAttribute( "list" , list ) ;
			
			
			req.getRequestDispatcher( "result_key_word.jsp" ).forward( req , res ) ;
			
			
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




