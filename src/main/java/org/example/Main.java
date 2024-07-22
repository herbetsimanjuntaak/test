package org.example;



import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String[] TITLES = {
            "Mr.", "Mrs.", "Ms.", "Miss", "Dr.", "Sir", "Lord", "Lady"
    };

    public static String generateRandomTitle() {
        Random random = new Random();
        int index = random.nextInt(TITLES.length); // Pilih indeks acak
        return TITLES[index];
    }

    public static void main(String[] args) {
        // Menampilkan beberapa contoh title
        for (int i = 0; i < TITLES.length; i++) {
            String title = generateRandomTitle();
            System.out.println("Example Title: " + title);
        }
    }
}