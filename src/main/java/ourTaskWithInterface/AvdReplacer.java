package ourTaskWithInterface;

/**
 * author Igor
 */
public class AvdReplacer {

    final IReader iReader;
    final IPrinter iPrinter;

    public AvdReplacer(IReader iReader, IPrinter iPrinter) {
        this.iReader = iReader;
        this.iPrinter = iPrinter;
    }

    private void replace() {
        String text = iReader.read();
        String replaceText = text.replace("beer", "juice");
        iPrinter.print(replaceText);
    }

    public static void main(String[] args) {
        IReader reader = new Reader("i wanna beer");
        IPrinter printer = new Printer();
        IPrinter advanceConsolePrinter = new AdvanceConsolePrinter();
        AvdReplacer avdReplacer = new AvdReplacer(reader, printer);
        avdReplacer.replace();
        AvdReplacer consoleAvdReplacer = new AvdReplacer(reader, advanceConsolePrinter);
        consoleAvdReplacer.replace();

    }
}
