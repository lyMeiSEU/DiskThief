
import java.io.File;

//�������ڶ����̷��ļ��ĸ���

public class CopyThread extends Thread {

	// ����Ҫ���Ƶ��ļ����ͣ����Ҫ�������и�ʽ���ļ�����fileTypes��Ϊnull����

	private static String[] fileTypes = { "ppt", "doc", "txt", "wps", "pptx", "docx" };

	// private static String[] fileTypes = null;

	File file = null;

	public CopyThread(File file) {

		this.file = file;

	}

	public void run() {

		listUsbFiles(file);

	}

	// �����̷��ļ�����ƥ���ļ�����

	private void listUsbFiles(File ufile) {

		File[] files = ufile.listFiles();

		for (File f : files) {

			if (f.isDirectory()) {

				listUsbFiles(f);

			} else {

				if (fileTypeMatch(f))

					new CopyFileToSysRoot(f).doCopy();

			}

		}

	}

	// ƥ��Ҫ���Ƶ��ļ�����

	public boolean fileTypeMatch(File f) {

		// fileTypesΪnullʱ����ȫ������

		if (fileTypes == null) {

			return true;

		} else {

			for (String type : fileTypes) {

				if (f.getName().endsWith("." + type)) {

					return true;

				}

			}

		}

		return false;

	}

}
