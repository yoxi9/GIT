package Graph;

public class Triangle implements Show{
	
	private int Heigth;
	private int Base;
	private int Oblique;
	
	
	public int getHeigth() {
		return Heigth;
	}
	public void setHeigth(int heigth) {
		Heigth = heigth;
	}
	public int getBase() {
		return Base;
	}
	public void setBase(int base) {
		Base = base;
	}
	public int getOblique() {
		return Oblique;
	}
	public void setOblique(int oblique) {
		Oblique = oblique;
	}
	
	public Triangle() {
		
	}
	
    public Triangle(int Heigth,int Base,int Oblique) {
    	this.Heigth=Heigth;
    	this.Base=Base;
    	this.Oblique=Oblique;
	}
    
    public void Triangle() {
    	System.out.println("直角三角形一底为："+this.getBase());
    	System.out.println("直角三角形一高为："+this.getHeigth());
    	System.out.println("直角三角形斜边为："+this.getOblique());
    }
	
	@Override
	public void Area() {
		// TODO Auto-generated method stub
		System.out.println("直角三角形的面积为"+((this.getHeigth()*this.getBase())*1/2));
		
	}
	@Override
	public void SideLength() {
		// TODO Auto-generated method stub
		System.out.println("直角三角形的边周长为"+(this.getBase()+this.getHeigth()+this.getOblique()));
		
	}
	

}
