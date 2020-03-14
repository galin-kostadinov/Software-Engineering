package homework.productsshop.util;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUtil {
    String readContent(String filePath) throws IOException;

    void writeContent(String text, String filePath) throws IOException;
}
