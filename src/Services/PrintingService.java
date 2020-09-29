package Services;

import java.io.PrintStream;

public class PrintingService {
    PrintStream printer;

    public PrintingService() {
        printer = System.out;
    }

    public PrintingService(PrintStream printer) {
        this.printer = printer;
    }

    public <T> void print(T message) {
        printer.print(message);
    }
}
