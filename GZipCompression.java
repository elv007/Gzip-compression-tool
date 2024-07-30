
import java.io.*;
import java.util.zip.GZIPOutputStream;
import java.util.zip.GZIPInputStream;
import java.io.IOException;

public class GZipCompression {

    public void compressFile(String sourceFile, String destFile) throws IOException {
        byte[] buffer = new byte[1024];
        try (FileOutputStream fos = new FileOutputStream(destFile);
             GZIPOutputStream gos = new GZIPOutputStream(fos);
             FileInputStream fis = new FileInputStream(sourceFile)) {

            int len;
            while ((len = fis.read(buffer)) > 0) {
                gos.write(buffer, 0, len);
            }
        }
    }

    public void decompressFile(String compressedFile, String destFile) throws IOException {
        byte[] buffer = new byte[1024];
        try (GZIPInputStream gis = new GZIPInputStream(new FileInputStream(compressedFile));
             FileOutputStream fos = new FileOutputStream(destFile)) {

            int len;
            while ((len = gis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        }
    }
}


