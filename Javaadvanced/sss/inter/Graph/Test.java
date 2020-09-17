package Graph;

public class Test {
	public static void main(String[] args) {
		
		Circle C=new Circle(2);
		C.Circle();
		C.Area();
		C.SideLength();
		System.out.println("------------------");
		
		Triangle T=new Triangle(3,4,5);
		T.Triangle();
		T.Area();
		T.SideLength();
		System.out.println("------------------");
		
		Square S=new Square(4);
		S.Square();
		S.Area();
		S.SideLength();
	}

}
