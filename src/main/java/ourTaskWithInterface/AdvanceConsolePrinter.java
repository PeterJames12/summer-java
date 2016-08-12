package ourTaskWithInterface;

/**
 * author Igor
 */
public class AdvanceConsolePrinter implements IPrinter {

    @Override
    public void print(String text) {
        System.out.println(text);
        System.out.println(String.format("Length: %d", text.length()));
    }
}
