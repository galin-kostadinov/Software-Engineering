package homework.bookshopsystem.util;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileUtilImpl implements FileUtil {
    @Override
    public String[] fileContent(String path) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> fileInfo = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            fileInfo.add(line);
        }

        return fileInfo.stream()
                .filter(l->!l.trim().equals(""))
                .toArray(String[]::new);
    }
}
