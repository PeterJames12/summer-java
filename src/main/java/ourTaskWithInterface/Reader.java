package ourTaskWithInterface;

/**
 * author Igor
 */
public class Reader implements IReader {

    private final String str;

    public Reader(String str) {
        this.str = str;
    }

    @Override
    public String read() {
        return str;
    }
}
