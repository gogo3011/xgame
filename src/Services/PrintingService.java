package Services;

import Utils.Helpers.ConsoleColorInterface;
import Utils.Helpers.PrintingStyle;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

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

    public void print(String message, PrintingStyle style) {
        switch (style){
            case NORMAL -> print(message);
            case FAST -> {
                for (int i = 0; i < message.length(); i++){
                    try {
                        TimeUnit.MILLISECONDS.sleep(40);
                    } catch (InterruptedException ex) {
                        print(ex.getMessage());
                    }
                    print(message.charAt(i));
                }
            }
            case SLOW -> {
                for (int i = 0; i < message.length(); i++){
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException ex) {
                        print(ex.getMessage());
                    }
                    print(message.charAt(i));
                }
            }
            case WARN -> {
                String warnLine = ConsoleColorInterface.C_YELLOW +
                        "!-!-!-!-!-!-!\n" + ConsoleColorInterface.C_END;
                print(warnLine);
                print(message);
                print(warnLine);
            }
        }
    }
}
