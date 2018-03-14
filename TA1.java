package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Leonela on 3/10/2018.
 */
public class TA1 {



    public static void main(String arg []){

        System.setProperty("webdriver.chrome.driver", "C:/Users/Leonela/Desktop/Selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://darksky.net");

        WebElement daysList=driver.findElement(By.xpath("//*[@id=\"week\"]/a[2]/span[1]/span[2]"));
        String day = daysList.getText(); //get tomorrow from the webpage

        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1); // to get tomorrows day
        Date tomorrow = cal.getTime();
        SimpleDateFormat simpleDate = new SimpleDateFormat("EEE"); // the day of the week spelled out completely
        String tom = (simpleDate.format(tomorrow)); // tomorrows date into string

//      if tomorrow date from the webpage and java system are the saem the days are showing properly
        boolean msg = (day.equals(tom.toString()));
        if (msg == true) {
            //compare days btwn webpage and the system
           System.out.println("Days are showing properly, today is  : " + now);

        } else {
            System.out.println("Please update the system, today is  : " + now);

        }

        driver.quit();

    }


}
