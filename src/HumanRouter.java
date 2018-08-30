public class HumanRouter {
    Menu menu = new Menu();
    HumanRedactor humanRedactor = new HumanRedactor();
    boolean theEndProgram = false;

    public void mainMenu() {
        System.out.println("Menu: \n" +
                "please enter command for action \n" +
                "c - create \n" +
                "r - read \n" +
                "u - update \n" +
                "d - delete \n" +
                "sort - sort array \n" +
                "exit - for finish program");
    }
    public Human[] router(Human[] humans) {
        String command = menu.readConsoleValue();
        if (command.equalsIgnoreCase("c")) {
            humans = addHumanRouting(humans);
        } else if (command.equalsIgnoreCase("r")) {
            readHumansRouter(humans);
        } else if (command.equalsIgnoreCase("u")) {
            humans = updateHumanRouting(humans);
        } else if (command.equalsIgnoreCase("d")) {
            humans = deleteHumanRouting(humans);
        }else if (command.equalsIgnoreCase("sort")){
            humans = sortHumanRouting(humans);
        }else if (command.equalsIgnoreCase("exit")) {
            theEndProgram = true;
        } else {
            System.out.println("Incorrect command try again");
        }

        return humans;
    }

    private Human[] addHumanRouting(Human[] humans) {
        Human tempHuman = new Human();

        System.out.println("Enter Data for new Human");
        System.out.println("Name");
        tempHuman.setName(menu.readConsoleValue());
        System.out.println("LastName");
        tempHuman.setLastName(menu.readConsoleValue());
        System.out.println("age");
        tempHuman.setAge(Integer.parseInt(menu.readConsoleValue()));

        return humanRedactor.addHuman(humans, tempHuman);
    }

    private void readHumansRouter(Human[] human) {
        humanRedactor.readHumans(human);
    }

    private Human[] updateHumanRouting(Human[] humans) {
        Human human;

        System.out.println("Enter Data for update Human");
        System.out.println("Enter ID for update");
        human = humanRedactor.findById(humans, Integer.parseInt(menu.readConsoleValue()));
        if(human != null) {
            System.out.println("Enter new Name");
            human.setName(menu.readConsoleValue());
            System.out.println("Enter new LastName");
            human.setLastName(menu.readConsoleValue());
            System.out.println("Enter new age");
            human.setAge(Integer.parseInt(menu.readConsoleValue()));
        }else {
            System.out.println("Incorrect ID");
            return humans;
        }

        return humanRedactor.updateHuman(humans, human);
    }

    private Human[] deleteHumanRouting(Human[] humans) {
        Human human;
        System.out.println("Please enter ID for delete Human");
        human = humanRedactor.findById(humans,Integer.parseInt(menu.readConsoleValue()));
        if(human == null){
            System.out.println("Incorrect ID");
            return humans;
        }
        return humanRedactor.deleteHuman(humans, human);
    }
    private Human[] sortHumanRouting(Human[] humans){
        System.out.println("What parameter to sort array? \n" +
                "id - sort by ID");
        String command = menu.readConsoleValue();
        if (command.equalsIgnoreCase("id")){
            humans = humanRedactor.sortHumanID(humans);
            humanRedactor.readHumans(humans);
        }

        return humans;
        }
}
