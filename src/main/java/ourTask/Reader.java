package ourTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * author Igor
 */
public class Reader {

    public String read() throws IOException {

        String path = "/home/james/workspace/SummerJavaTest/src/main/java/ourTask/info.txt";

        BufferedReader reader = Files.newBufferedReader(Paths.get(path));

        StringBuilder stringBuilder = new StringBuilder();
        String info;
        while ((info = reader.readLine()) != null) {
            stringBuilder.append(info);

        }
        return stringBuilder.toString();
    }
}
