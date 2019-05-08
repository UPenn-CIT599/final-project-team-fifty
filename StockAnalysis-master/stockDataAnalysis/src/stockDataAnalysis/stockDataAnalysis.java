package stockDataAnalysis;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class stockDataAnalysis {
	
	public static void main(String[] args) {
		
		String date_JP = "20190319"; // Date for Japan (JP)
		 System.out.println("Request date for JP: " + date_JP);
		  
		//Get short position for Japan
		IGetStockData Japan = new JapanStock(); //'Japan' is an instance of JapanStock class
		ArrayList <StockItem> japanStockList; //Short position for JP is stored in the JapanStockList ArrayList
		japanStockList = Japan.getShortPositions(date_JP);
		//System.out.println(japanStockList);
		
		//Sort the stock list for JP based on short ratio
        ComparaShortRatio com = new ComparaShortRatio();
        //System.out.println(com);
        Collections.sort(japanStockList,com);
	   
		String date_HK = "20190415"; // Date for HK
		System.out.println("Request date for HK: " + date_HK);
		
		//Get short position for Hong Kong (HK)
		IGetStockData HongKong = new HongKongStock(); // 'HongKong' is an instance of HongKongStock class		
		ArrayList <StockItem> hkStockList; //Short position for HK is stored in the HongStockList ArrayList
		hkStockList = HongKong.getShortPositions(date_HK);
		
		//Sort the stock list for HK based on short ratio
        com = new ComparaShortRatio();
        Collections.sort(hkStockList,com);
        
        // Change the format for the shortRatio property for each item in the hkStockList
        for (StockItem item:hkStockList) {
        	String ratio = String.format("%.2f", item.shortRatio);
        	item.shortRatio = Double.parseDouble(ratio);
        }

        // Print the result
        int top_n = 5;
        System.out.println("******************* TOP " + top_n + " Stocks by Short Ratio *******************");
        System.out.println("*****Japan Market*****  " + "  ***** HongKong Market *****");
        System.out.println("    Code " + "   Short Ratio" + "    Code" + "     Short Ratio");
        for (int i=0; i <top_n; i++) {
        	System.out.println("    " +japanStockList.get(i).stockCode + "       " + japanStockList.get(i).shortRatio
        			+ "       " + hkStockList.get(i).stockCode + "      " + hkStockList.get(i).shortRatio);
        }
	}
}
