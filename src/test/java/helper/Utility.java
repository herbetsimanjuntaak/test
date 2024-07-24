package helper;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.Random;

public class Utility {
    static Faker faker = new Faker();
    public static WebDriver driver;

    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helper/JSONSchemaData/" + JSONFile);
    }

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    private static final String[] TITLES = {
            "mr", "ms", "mrs", "miss", "dr"
    };

    public static String generateRandomTitle() {
        Random random = new Random();
        int index = random.nextInt(TITLES.length);
        return TITLES[index];
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateGender() {
        String gender = faker.demographic().sex();
        gender = gender.toLowerCase();
        return gender;
    }

    public static String generatePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateEmails() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10); // Panjang email 10 karakter
        email = temp + "@testdata.com";
        return email;
    }


    public static void startDriver() {

        ChromeOptions options = new ChromeOptions();
        //untuk tidak menampilkan browser
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    public static void quitDriver() {
        driver.quit();
    }
}
