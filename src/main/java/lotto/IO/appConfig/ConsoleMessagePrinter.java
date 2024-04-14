package lotto.IO.appConfig;

public class ConsoleMessagePrinter implements MessagePrinter {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        System.out.println(Messages.ERROR_PREFIX + message);
    }
}
