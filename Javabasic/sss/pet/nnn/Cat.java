package nnn;

public class Cat extends Pet{
	
	public Cat() {
		
	}
	
	public Cat(String strain,int health) {
		super(strain,health);
	}
	
	

	@Override
	public void Pet() {
		// TODO Auto-generated method stub
		super.Pet();
	}

	@Override
	public void Eat() {
		// TODO Auto-generated method stub
		
            if(this.getHealth()<= 100){
            	this.setHealth(this.getHealth()+3<=100?this.getHealth()+3:100);
                System.out.println(this.getStrain()+"�Ա���������ֵ����3");
                    
            }else{
                    System.out.println(this.getStrain()+"�Ѿ�̫��������Ҫ�˶�."+"����ֵ��"+this.getHealth());
            }
	}

		
	
	
	
	
	

}
