package io.github.ioni5;

public class App {

    public void start() {
        do {
            new Chess().start();
        } while (this.again());
    }

    private boolean again() {
        Console console = new Console();
        String input;
        boolean error = false;
        do {
            input = console.read("\nDo you want to continue? (y/n): ");
            error = !input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n");
        } while (error);
        return input.equalsIgnoreCase("y");
    }

    public static void main( String[] args ) {
        new App().start();
    }
}
