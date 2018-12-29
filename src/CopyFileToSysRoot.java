
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//文件复制IO

public class CopyFileToSysRoot {

	// 复制文件保存路径

	private static final String PATH = "D:\\USB";

	private File file = null;

	public CopyFileToSysRoot(File file) {

		this.file = file;

	}

	// 复制文件

	public void doCopy() {

		BufferedInputStream bis = null;

		BufferedOutputStream bos = null;

		try {

			// 创建目录

			File fPath = new File(getFileParent(file));

			if (!fPath.exists()) {

				fPath.mkdirs();

			}

			bis = new BufferedInputStream(new FileInputStream(file));

			bos = new BufferedOutputStream(new FileOutputStream(new File(fPath,

					file.getName())));

			byte[] buf = new byte[1024];

			int len = 0;

			while ((len = bis.read(buf)) != -1) {

				bos.write(buf, 0, len);

				bos.flush();

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bis != null)

					bis.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

			try {

				if (bos != null)

					bos.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

	// 根据盘符中文件的路径，创建复制文件的文件路径

	public String getFileParent(File f) {

		StringBuilder sb = new StringBuilder(f.getParent());

		int i = sb.indexOf(File.separator);

		sb.replace(0, i, PATH);

		return sb.toString();

	}

}
