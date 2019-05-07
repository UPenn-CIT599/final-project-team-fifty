package stockDataAnalysis;

import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class HongKongStockTest {

	@Test
	void testGetShortPositions() {
		
				IGetStockData HongKong = new HongKongStock();
				ArrayList <StockItem> hkStockList;

				String date = "20190415";
				
				hkStockList = HongKong.getShortPositions(date);
				assertNotNull(hkStockList);
				
				ComparaShortRatio com = new ComparaShortRatio();
		        Collections.sort(hkStockList,com);
		        assertNotSame(hkStockList.get(0).stockCode, "8848");
	}

}
