import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn1 = userDir + "\\res\\inputOne.txt";
        String pathIn2 = userDir + "\\res\\inputTwo.txt";
        String pathIn3 = userDir + "\\res\\input.txt";

        String pathZip = userDir + "\\res\\files.zip";

        try (FileOutputStream fos = new FileOutputStream(pathZip);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ZipOutputStream zos = new ZipOutputStream(bos)) {

            zos.putNextEntry(new ZipEntry("inputOne.txt"));
            FileInputStream inputStream = new FileInputStream(pathIn1);
            zos.write(inputStream.readAllBytes());
            inputStream.close();

            zos.putNextEntry(new ZipEntry("inputTwo.txt"));
            inputStream = new FileInputStream(pathIn2);
            zos.write(inputStream.readAllBytes());
            inputStream.close();

            zos.putNextEntry(new ZipEntry("input.txt"));
            inputStream = new FileInputStream(pathIn3);
            zos.write(inputStream.readAllBytes());
            inputStream.close();

            zos.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
