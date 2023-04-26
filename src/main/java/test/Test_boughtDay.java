package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test_boughtDay {

	public static void main(String[] args) throws Exception{
		
		
		// 購入日付算出　考案1
		//String date ="" ;
		//ZonedDateTime now = ZonedDateTime.now() ;
		//int year = now.getYear() ;
		//int month = now.getMonthValue() ;
		//int day = now.getDayOfMonth() ;
		//date = year + "-" + month + "-" + day ;
		
		
		
		// 購入日付算出　考案2( 採用 )
		
		LocalDate now = LocalDate.now() ;
		
		LocalDate date = LocalDate.of( now.getYear() , now.getMonthValue() , now.getDayOfMonth() ) ;
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ;
		
		String d = f.format( date ) ;
		
		System.out.println( d );
	}

}
