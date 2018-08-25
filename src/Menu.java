import java.util.Scanner;

public class Menu {
    Redactor redactor = new Redactor();
    boolean theEndProgram = false;

    public void mainMenu() {
        System.out.println("Menu: \n" +
                "please enter command for action \n" +
                "c - create \n" +
                "r - read \n" +
                "u - update \n" +
                "d - delete \n" +
                "exit - for finish program");
    }

    public String[] route(String[] arr) {
        String command = readConsoleValue();
        if (command.equalsIgnoreCase("c")) {
            arr = createElement(arr);
        } else if (command.equalsIgnoreCase("r")) {
            readElement(arr);
        } else if (command.equalsIgnoreCase("u")) {
            arr = updateElement(arr);
        } else if (command.equalsIgnoreCase("d")) {
            arr = delete(arr);
        } else if (command.equalsIgnoreCase("exit")) {
            theEndProgram = true;
        } else {
            System.out.println("Incorrect command try again: ");
        }
        return arr;
    }

    private String[] createElement(String[] arr) {
        String value;

        System.out.println("Please enter value for create element: ");
        value = readConsoleValue();
        return redactor.create(arr, value);
    }

    private void readElement(String[] arr) {
        redactor.read(arr);
    }

    private String[] updateElement(String[] arr) {
        String value;
        int index;

        System.out.println("Please enter index: ");
        index = Integer.parseInt(readConsoleValue());
        System.out.println("Please enter new value for update element: ");
        value = readConsoleValue();
        return redactor.update(arr, index, value);

    }

    private String[] delete(String[] arr) {
        int index;

        System.out.println("Please enter index for delete element: ");
        index = Integer.parseInt(readConsoleValue());
        return redactor.delete(arr, index);
    }

    protected String readConsoleValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
