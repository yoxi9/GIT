package gu;

public class Test {
	public static void main(String[] args) {
		
		    StockHolder stock = new StockHolder();
	        stock.getStockPrice();
	        try {
	            if (stock.sellPrice()>=0.10){
	                throw new StockRatioException("����10%");
	            }
	        }catch (Exception ex){
	            System.out.println("�����쳣");
	            ex.printStackTrace();
	        }
	    }
	
	

}
