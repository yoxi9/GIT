package sss;

public class tang {
	public static void main(String[] args) {
		char[][] chunxiao=new char[4][];
		chunxiao[0]=new char[5];
		chunxiao[0][0]='��';
		chunxiao[0][1]='��';
		chunxiao[0][2]='��';
		chunxiao[0][3]='��';
		chunxiao[0][4]='��';
		chunxiao[1]=new char[]{'��','��','��','��','��'};
		chunxiao[2]=new char[]{'ҹ','��','��','��','��'};
		chunxiao[3]=new char[]{'��','��','֪','��','��'};
		
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
