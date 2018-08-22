public class Main {
    public static void main(String[] args) {

        String[] arr = new String[10];
        Menu menu = new Menu();

        while (!menu.theEndProgram){
            menu.mainMenu();
            arr = menu.route(arr);
        }
    }
}
