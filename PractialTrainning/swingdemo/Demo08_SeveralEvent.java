package swingdemo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Demo08_SeveralEvent extends JFrame implements FocusListener,MouseListener{

	JTextField jtf = null;
	JTextArea jta = null;
	JButton jbgo = null;

	public Demo08_SeveralEvent() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demo08_SeveralEvent(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		jtf = new JTextField(20);
		jtf.setText("����������");
		jta = new JTextArea(20, 30);
		jta.setText("�м������򣬿��Զ�������");
		jbgo = new JButton("��һ����ť");
		// this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		Container jp = this.getContentPane();
		jp.setLayout(null);// �������ʾ����null���֣���ôȱʡ����BorderLayout

		JScrollPane jsp = new JScrollPane(jta);

		jp.add(jsp);
		jsp.setBounds(50, 20, 200, 180);

		jp.add(jtf);
		jtf.setBounds(50, 250, 200, 50);
		jtf.addMouseListener(this);

		jtf.addFocusListener(this);

		jtf.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				jta.setText(jta.getText() + "\n��������:��ĸΪ" + e.getKeyChar()
						+ ",ASC��Ϊ��" + e.getKeyCode());
			}
		});

		jp.add(jbgo);
		jbgo.setBounds(50, 320, 100, 60);
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				jta.setText(jta.getText() + "\n����ȥ�����ˣ�");
			}
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���ڹر���");
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���ڹر���");
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				jta.setText(jta.getText() + "\n���ڼ����ˣ�");
			}
		});

		this.setSize(400, 500);

		this.setLocation(200, 100);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Demo08_SeveralEvent("���񲼾�");
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		jta.setText(jta.getText() + "\n�ı������ʧȥ�����ˣ�");
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		jta.setText(jta.getText() + "\n�ı������õ������ˣ�");
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		jta.setText(jta.getText() + "\n���Ų���ı�������ˣ�");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		jta.setText(jta.getText() + "\n���Ų���ı�������ˣ�x=" + e.getX()
				+ ",y=" + e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		jta.setText(jta.getText() + "\n������ı�������ˣ�λ��Ϊx=" + e.getX()
				+ ",y=" + e.getY());
	}

}
