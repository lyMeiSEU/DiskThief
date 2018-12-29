
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

 

public class USBMain {

 

	public static void main(String[] args) {

		USBMain u = new USBMain();

		u.launchFrame();

		//开启盘符检查线程

		new CheckRootThread().start();

	}

 

	// 界面

	private void launchFrame() {

		final JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLocation(450, 250);

		JButton hide = new JButton("点击隐藏窗口");

		// 点击按钮后隐藏窗口事件监听

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
