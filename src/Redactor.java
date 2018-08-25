import java.util.Arrays;

public class Redactor {

    public String[] create(String[] arr, String value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = value;
                break;
            }
        }
        return arr;
    }

    public void read(String[] arr) {
        System.out.println(Arrays.asList(arr));
    }

    public boolean checkIndex(String[] arr, int index) {
        boolean checker = index < arr.length && index >= 0;
        if (!checker) {
            System.out.println("incorrect index: " + index);
        }
        return checker;
    }

    public String[] update(String[] arr, int index, String value) {
        if (checkIndex(arr, index)) {
            arr[index] = value;
        }
        return arr;
    }

    public String[] delete(String[] arr, int index) {
        if (checkIndex(arr, index)) {
            arr[index] = null;
        }
        return arr;
    }
}
