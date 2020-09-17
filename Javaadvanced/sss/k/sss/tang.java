package sss;

public class tang {
	public static void main(String[] args) {
		char[][] chunxiao=new char[4][];
		chunxiao[0]=new char[5];
		chunxiao[0][0]='春';
		chunxiao[0][1]='眠';
		chunxiao[0][2]='不';
		chunxiao[0][3]='觉';
		chunxiao[0][4]='晓';
		chunxiao[1]=new char[]{'处','处','闻','啼','鸟'};
		chunxiao[2]=new char[]{'夜','来','风','雨','声'};
		chunxiao[3]=new char[]{'花','落','知','多','少'};
		
		for(char[] c:chunxiao) {
			for(char w:c) {
				System.out.print(" "+w);
			}
			System.out.println();
		}
		for(int i=0;i<chunxiao[0].length;i++) {
			for(int j=0;j<chunxiao.length;j++) {
				System.out.print(" "+chunxiao[chunxiao.length-1-j][i]);
				
			}
			System.out.println();
			
		}

	}

}
