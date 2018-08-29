public class HumanRedactor {

    public Human[] addHuman(Human[] humans, Human human) {
        for (int i = 0; i < humans.length; i++) {
            if (humans[i] == null) {
                humans[i] = human;
                break;
            }
        }
        return humans;
    }

    public void readHumans(Human[] humans) {
        for (int i = 0; i < humans.length; i++) {
            if (humans[i] != null) {
                System.out.println(humans[i]);
            }
        }
    }

    public Human[] updateHuman(Human[] humans, Human human) {
        for (int i = 0; i < humans.length; i++) {
            if (humans[i] != null && humans[i].getId() == human.getId()) {
                humans[i] = human;
                break;
            }
        }
        return humans;
    }

    public Human findById(Human[] humans, int id) {
        Human human = null;
        for (int i = 0; i <humans.length ; i++) {
            if (humans[i] != null && humans[i].getId() == id) {
                human = humans[i];
                break;
            }
        }
        return human;
    }

    public Human[] deleteHuman(Human[] humans, Human human) {
        for (int i = 0; i < humans.length; i++) {
            if (humans[i] != null && humans[i].getId() == human.getId()) {
                humans[i] = null;
                break;
            }
        }
        return humans;
    }

    public Human[] sortHumanID (Human [] humans){
        Human [] tmpHumans = new Human[humans.length];
        Human human;
        int countIndex = 0;
        for (int i = 0; i <humans.length ; i++) {
            if(humans[i] != null){
                tmpHumans[countIndex] = humans[i];
                countIndex++;
            }
        }
        for (int j = 0; j <tmpHumans.length ; j++) {
            int count = 0;
            for (int i = 1; i <tmpHumans.length ; i++) {
                Human human1;
                human = tmpHumans[i];
                human1 = tmpHumans[i-1];
                if(human != null && human1.getId() > human.getId()){
                    tmpHumans[i-1] = human;
                    tmpHumans[i] = human1;
                    count++;
                }
            }
            if (count == 0){
                break;
            }
        }


        return tmpHumans;
    }
}
