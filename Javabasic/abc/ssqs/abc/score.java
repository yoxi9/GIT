package abc;

public class score {
	
	float ascore;//a�ĳɼ���
	float bscore;//b�ĳɼ���
	float cscore;//c�ĳɼ���
	
	
	public float sum() {
		
		float sum=this.ascore+this.bscore+this.cscore;
		
		return sum;
		
		
	}
	
	public float ave(){
		
		float ave=(this.ascore+this.bscore+this.cscore)*1/3;
		
		return ave;
	}
	
	public void showsum() {
		
		System.out.println("�ܳɼ�Ϊ��"+sum());
		
	}
	
    public void showave() {
		
		System.out.println("ƽ���ɼ�Ϊ��"+ave());
		
	}


}
