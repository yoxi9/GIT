package abc;

public class score {
	
	float ascore;//a的成绩；
	float bscore;//b的成绩；
	float cscore;//c的成绩；
	
	
	public float sum() {
		
		float sum=this.ascore+this.bscore+this.cscore;
		
		return sum;
		
		
	}
	
	public float ave(){
		
		float ave=(this.ascore+this.bscore+this.cscore)*1/3;
		
		return ave;
	}
	
	public void showsum() {
		
		System.out.println("总成绩为："+sum());
		
	}
	
    public void showave() {
		
		System.out.println("平均成绩为："+ave());
		
	}


}
