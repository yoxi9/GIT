package now;

import java.util.Scanner;

public class MotoVehicleTest {
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入你要租车的类型：1.轿车 2.客车");
		int cartype=scan.nextInt();
		
		if(cartype==1) {
			
			System.out.println("请输入轿车的品牌和型号");
			Scanner scan1=new Scanner(System.in);
			String brand=scan.next();
			Scanner scan2=new Scanner(System.in);
			String type=scan.next();
			
			System.out.println("请输入租车天数");
			Scanner scan3=new Scanner(System.in);
			int days=scan.nextInt();
			
			newCar car=new newCar(brand,type);
			int rentfee=car.calcRent(days);
			
			System.out.println("品牌："+car.getBrand());
			System.out.println("型号："+car.getType());
			System.out.println("天数："+days);
			System.out.println("总租金为："+rentfee);
			
		}else {
			
			System.out.println("请输入承载人数");		
			Scanner scan7=new Scanner(System.in);
			int seats=scan.nextInt();
			
			System.out.println("请输入租车天数");
			Scanner scan9=new Scanner(System.in);
			int days=scan.nextInt();
			
			Bus bus=new Bus(seats);
			int rentfee=bus.calcRent(days);
			
			System.out.println("承载人数为："+bus.getSeats());
			System.out.println("总租金为："+rentfee);
			
		}
	}

}
