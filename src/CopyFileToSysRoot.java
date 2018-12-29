
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//�ļ�����IO

public class CopyFileToSysRoot {

	// �����ļ�����·��

	private static final String PATH = "D:\\USB";

	private File file = null;

	public CopyFileToSysRoot(File file) {

		this.file = file;

	}

	// �����ļ�

	public void doCopy() {

		BufferedInputStream bis = null;

		BufferedOutputStream bos = null;

		try {

			// ����Ŀ¼

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

	// �����̷����ļ���·�������������ļ����ļ�·��

	public String getFileParent(File f) {

		StringBuilder sb = new StringBuilder(f.getParent());

		int i = sb.indexOf(File.separator);

		sb.replace(0, i, PATH);

		return sb.toString();

	}

}
