
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

 

public class USBMain {

 

	public static void main(String[] args) {

		USBMain u = new USBMain();

		u.launchFrame();

		//�����̷�����߳�

		new CheckRootThread().start();

	}

 

	// ����

	private void launchFrame() {

		final JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLocation(450, 250);

		JButton hide = new JButton("������ش���");

		// �����ť�����ش����¼�����

		hide.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);

			}

		});

		frame.add(hide);

		frame.pack();

		frame.setVisible(true);

	}

}
