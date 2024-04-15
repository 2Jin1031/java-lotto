package lotto.IO.appConfig;

public class ConsoleMessagePrinter implements MessagePrinter {

    public void message(String message) {
        System.out.println(message);
    }

    public void error(String message) {
        System.out.println(PromptConstants.ERROR_PREFIX + message);
    }
}
