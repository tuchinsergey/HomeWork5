package HomeWork5;

import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        AppData appData = new AppData();
        appData.load("HomeWork.txt");
        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData()));
        appData.save("HW5");
    }
}
