package ourTaskWithInterface;

/**
 * author Igor
 */
public class AvdReplacer {

    final private IReader iReader;
    final private IPrinter iPrinter;

    private AvdReplacer(IReader iReader, IPrinter iPrinter) {
        this.iReader = iReader;
        this.iPrinter = iPrinter;
    }

    private void replace() {
        String text = iReader.read();
        String replaceText = text.replace("beer", "juice");
        iPrinter.print(replaceText);
    }

    public static void main(String[] args) {
        IReader reader = new Reader("i hate beer");
        IPrinter printer = new Printer();
        IPrinter advanceConsolePrinter = new AdvanceConsolePrinter();
        AvdReplacer avdReplacer = new AvdReplacer(reader, printer);
        avdReplacer.replace();
        AvdReplacer consoleAvdReplacer = new AvdReplacer(reader, advanceConsolePrinter);
        consoleAvdReplacer.replace();

    }
}
