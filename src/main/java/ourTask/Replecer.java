package ourTask;

import java.io.IOException;

/**
 * author Igor
 */
public class Replecer {

    private boolean where = false;

    public static void main(String[] args) throws IOException {

        new Replecer().replace();
    }

    private void replace() throws IOException {

        String read = new Reader().read();
        String replaceText = read.replace("beer", "juice");
        if (where) {
            new Printer().print(replaceText);
        } else if (!where) {
            new ConsolePrinter().print(replaceText);
        }
    }
}
