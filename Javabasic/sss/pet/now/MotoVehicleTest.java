package now;

import java.util.Scanner;

public class MotoVehicleTest {
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("��������Ҫ�⳵�����ͣ�1.�γ� 2.�ͳ�");
		int cartype=scan.nextInt();
		
		if(cartype==1) {
			
			System.out.println("������γ���Ʒ�ƺ��ͺ�");
			Scanner scan1=new Scanner(System.in);
			String brand=scan.next();
			Scanner scan2=new Scanner(System.in);
			String type=scan.next();
			
			System.out.println("�������⳵����");
			Scanner scan3=new Scanner(System.in);
			int days=scan.nextInt();
			
			newCar car=new newCar(brand,type);
			int rentfee=car.calcRent(days);
			
			System.out.println("Ʒ�ƣ�"+car.getBrand());
			System.out.println("�ͺţ�"+car.getType());
			System.out.println("������"+days);
			System.out.println("�����Ϊ��"+rentfee);
			
		}else {
			
			System.out.println("�������������");		
			Scanner scan7=new Scanner(System.in);
			int seats=scan.nextInt();
			
			System.out.println("�������⳵����");
			Scanner scan9=new Scanner(System.in);
			int days=scan.nextInt();
			
			Bus bus=new Bus(seats);
			int rentfee=bus.calcRent(days);
			
			System.out.println("��������Ϊ��"+bus.getSeats());
			System.out.println("�����Ϊ��"+rentfee);
			
		}
	}

}
