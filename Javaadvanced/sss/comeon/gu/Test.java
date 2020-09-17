package gu;

public class Test {
	public static void main(String[] args) {
		
		    StockHolder stock = new StockHolder();
	        stock.getStockPrice();
	        try {
	            if (stock.sellPrice()>=0.10){
	                throw new StockRatioException("³¬³ö10%");
	            }
	        }catch (Exception ex){
	            System.out.println("²¶»ñÒì³£");
	            ex.printStackTrace();
	        }
	    }
	
	

}
