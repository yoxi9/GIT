package gu;

import java.util.Scanner;

public class StockHolder {

	 Scanner price = new Scanner(System.in);

	    private double stockPrice;
	    public Double getStockPrice(){
	        System.out.println(" ‰»Îº€∏Ò");
	        stockPrice = price.nextDouble();
	        return stockPrice;
	    }
	    
	    public double sellPrice(){
	        double stock1 = 1000.00;
	        double ratio = (stockPrice/stock1)-1.00;
	        return ratio;
	    }

}
