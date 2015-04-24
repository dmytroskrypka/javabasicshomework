package streams_HW_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainBISDemo {

	public static void main(String[] args) {
		try {
			copyFile("c:\\Users\\edmiskr\\Documents\\Programming\\output\\IOStream1.txt",
					"c:\\Users\\edmiskr\\Documents\\Programming\\output\\IOStream1Copy.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void copyFile(String src, String dest) throws Exception {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
		try {
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
			
			try {
				byte[] buf= new byte[1024]; // 1 KB
				int r;
				do {
					r = in.read(buf, 0, buf.length);
					if (r > 0)
						out.write(buf, 0, r);
				} while (r > 0);
			} finally {
				out.close();
			}
		} finally {
		in.close();
		}
	}
}
