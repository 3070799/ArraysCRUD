public class Main {
    public static void main(String[] args) {

//        String[] arr = new String[10];
        Human[] humans = new Human[10];
        Menu menu = new Menu();
        HumanRouter humanRouter = new HumanRouter();

        while (!humanRouter.theEndProgram) {
            humanRouter.mainMenu();
            humans = humanRouter.router(humans);
        }
    }
}
