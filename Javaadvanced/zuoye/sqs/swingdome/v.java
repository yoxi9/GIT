package swingdome;

//��ƻ�Ա�Ǽ�¼�����
import java.awt.*;//����
import javax.swing.*;


public class v {
public static void main(String[] args) {
JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10;// ������ǩ���
JComboBox cb1, cb2;
String[] sj = { "2017-12-10" };// ���������б�����
String[] sf = { "��", "��" };// ���������б�����
JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;// �����ı����
JFrame jf = new JFrame("��Ա�Ǽ�¼��");
jf.setVisible(true);// ���ô���ɼ�
jf.setSize(500, 200);// ���ô��ڳ��Դ�С
jf.setLocationRelativeTo(null);


JPanel jp = new JPanel();
jp.setLayout(new BorderLayout(5, 0));// ����һ���߽粼��
JPanel jpTop = new JPanel();
jpTop.setLayout(new FlowLayout());// ����һ��������


JPanel jpcenter = new JPanel();
jpcenter.setLayout(new GridLayout(4, 2, 5, 5));// ����һ�����񲼾�


JPanel jpbottom = new JPanel();
jpbottom.setLayout(new GridLayout(1, 2, 5, 5));// ����һ�����񲼾�


lb1 = new JLabel("��Ա�Ǽ�¼��");// �����������ֵ
lb2 = new JLabel("�쿨����");
lb3 = new JLabel("��Ա����������");
lb4 = new JLabel("����");
lb5 = new JLabel("�Ա�");
lb6 = new JLabel("��ϵ�绰");
lb7 = new JLabel("����");
lb8 = new JLabel("�ۿ�");
lb9 = new JLabel("�Ƿ��ʧ");
lb10 = new JLabel("������λ");


cb1 = new JComboBox(sj);
cb2 = new JComboBox(sf);


tf1 = new JTextField("199802225210");
tf2 = new JTextField("BOB");
tf3 = new JTextField("MAN");
tf4 = new JTextField("1955214555021");
tf5 = new JTextField("��ͨ��Ա");
tf6 = new JTextField("0.9");
tf7 = new JTextField("������˾");


jpTop.add(lb1);// �������ӵ������
jpcenter.add(lb2);
jpcenter.add(cb1);
jpcenter.add(lb3);
jpcenter.add(tf1);
jpcenter.add(lb4);
jpcenter.add(tf2);
jpcenter.add(lb5);
jpcenter.add(tf3);
jpcenter.add(lb6);
jpcenter.add(tf4);
jpcenter.add(lb7);
jpcenter.add(tf5);
jpcenter.add(lb8);
jpcenter.add(tf6);
jpcenter.add(lb9);
jpcenter.add(cb2);
jpbottom.add(lb10);
jpbottom.add(tf7);
jp.add(jpTop, BorderLayout.NORTH);
jp.add(jpcenter, BorderLayout.CENTER);
jp.add(jpbottom, BorderLayout.SOUTH);
jf.add(jp);


}


}