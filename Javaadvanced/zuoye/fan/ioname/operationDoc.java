package ioname;

import java.io.File;
import java.io.IOException;
import org.junit.Test;


public class operationDoc {
    @Test
    public void CreatDirectory() {
        File dir1 = new File("D:\\Case\\myDir");
        if (dir1.exists()) {
            System.out.println("��⵽�༶Ŀ¼���ڣ�ɾ��");
            dir1.delete();
        }
        if (!dir1.exists()) {
            System.out.println("��⵽�༶Ŀ¼�����ڣ��½�");
            dir1.mkdirs();
        }

        File file1 = new File("D:\\Case\\myDir\\��ι��.txt");
        if (file1.exists()) {
            System.out.println("��⵽�ı��ļ��Ѿ����ڣ�ɾ��");
            file1.delete();
        }
        if (!file1.exists()) {
            System.out.println("��⵽�ļ������ڣ��½�");
        }
        try {
            file1.createNewFile();
            System.out.println("����·��Ϊ��" + file1.getAbsolutePath());
            System.out.println("�ļ�����" + file1.getName());
            System.out.println("��·��Ϊ��" + file1.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
         if (file1.exists()) {
                System.out.println("��⵽�ı��ļ��Ѿ����ڣ����������������ɾ��");
                file1.delete();
            }
    }
}
