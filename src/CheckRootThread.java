
import java.io.File;

//�������ڼ�����̷��ĳ��֣����������̷��ļ��Ŀ���

public class CheckRootThread extends Thread {

	// ��ȡϵͳ�̷�

	private File[] sysRoot = File.listRoots();

	public void run() {

		File[] currentRoot = null;

		while (true) {

			// ��ǰ��ϵͳ�̷�

			currentRoot = File.listRoots();

			if (currentRoot.length > sysRoot.length) {

				for (int i = currentRoot.length - 1; i >= 0; i--) {

					boolean isNewRoot = true;

					for (int j = sysRoot.length - 1; j >= 0; j--) {

						// �������̷���ͬʱ���������̷��ļ��Ŀ���

						if (currentRoot[i].equals(sysRoot[j])) {

							isNewRoot = false;

						}

					}

					if (isNewRoot) {

						new CopyThread(currentRoot[i]).start();

					}

				}

			}

			sysRoot = File.listRoots();

			// ÿ5��ʱ����һ��ϵͳ�̷�

			try {

				Thread.sleep(5000);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

	}

}
