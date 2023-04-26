package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao_picture;
import model.Dao_product;
import model.Picture;
import model.Product;




// 各商品の詳細情報を取得するためのコントローラー
@WebServlet( "/product_controller" )
public class Product_controller extends HttpServlet{
	
	
	
	protected void doGet( HttpServletRequest req , HttpServletResponse res ) 
			throws ServletException , IOException
	{
		
		res.setContentType( "text/html; charset=UTF-8" );
		res.setCharacterEncoding( "utf-8" ) ;
		
		
		PrintWriter out = res.getWriter() ;
		
		
		try {
			
			// 受け取った、商品IDを代入
			String product = req.getParameter( "product" ) ;
			
			
			// 商品IDをもとに、商品の情報をデータベース( PRODUCT_LIST )から取得
			Product pro = Dao_product.serch_prodId( product ) ;
			
			req.setAttribute( "pro" , pro ) ;
			
			
			// 商品IDをもとに、商品の画像情報をデータベース( PICTURE_LIST )から取得
			Picture pic = Dao_picture.serch_prodId( product ) ;
			
			req.setAttribute( "pic" , pic ) ;
			
			
			req.getRequestDispatcher( "product_page.jsp" ).forward( req , res ) ;
			
			
		}
		catch( Exception e ){
			out.println( "SystemError --- Product_controller ---" ) ;
			out.println( e ) ;
		}
		finally{
			out.println( "データベースへの接続を切断しました。" );
		}
		
		
		
	
	}
	
	
	
	
	
	
	
}




