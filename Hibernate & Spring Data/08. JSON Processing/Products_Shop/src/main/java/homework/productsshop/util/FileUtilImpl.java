package homework.productsshop.util;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileUtilImpl implements FileUtil {
    @Override
    public String readContent(String filePath) throws IOException {
        File file = new File(filePath);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        StringBuilder sb = new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString().trim();
    }

    @Override
    public void writeContent(String text, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(text);

        writer.close();
    }
}
