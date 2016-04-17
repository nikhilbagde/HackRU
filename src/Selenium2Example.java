import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class Selenium2Example  {
    public static String[] get1(String url, WebDriver driver) {
        String word = "world";
        String word2 = "hello";

        driver.get(url);

        WebElement element = driver.findElement(By.id("res-translit"));

        String trt = element.getText();

        trt = repWierd(trt);

        //System.out.println(trt);

        trt = trt.substring(4);

        trt = trt.replace(". "," - ");

        String[] ret = trt.split(" - ");

        return ret;
    }

    public static String[] get2(String url, WebDriver driver) {


        String word = "world";
        String word2 = "hello";

        driver.get(url);

        WebElement element = driver.findElement(By.id("result_box"));

        String trt = element.getText();

        trt = repWierd(trt);

        trt = trt.replace(" . ",". ");
        trt = trt.replace("<span>","");
        trt = trt.replace("</span>","");

        trt = trt.replace("'","");

        trt = trt.substring(2);

        trt = trt.replace(". "," - ");

        //System.out.println(trt);

        String[] ret = trt.split(" - ");

        //System.out.println(Arrays.toString(ret));

        return ret;
    }

    public static String repWierd(String trt) {
        trt = trt.toLowerCase();

        trt = trt.replace('ā','a');
        trt = trt.replace('á','a');
        trt = trt.replace('à','a');
        trt = trt.replace('á','a');

        trt = trt.replace('ě','e');
        trt = trt.replace('é','e');
        trt = trt.replace('è','e');
        trt = trt.replace('ē','e');

        trt = trt.replace('ǐ','i');
        trt = trt.replace('ì','i');
        trt = trt.replace('ī','i');
        trt = trt.replace('í','i');

        trt = trt.replace('ǒ','o');
        trt = trt.replace('ō','o');
        trt = trt.replace('ò','o');
        trt = trt.replace('ó','o');

        trt = trt.replace('ð','o');

        trt = trt.replace('ū','u');
        trt = trt.replace('ú','u');
        trt = trt.replace('ŭ','u');
        trt = trt.replace('ù','u');

        trt = trt.replace('ǖ','u');
        trt = trt.replace('ǘ','u');
        trt = trt.replace('ǚ','u');
        trt = trt.replace('ǜ','u');

        trt = trt.replace('ḍ','d');
        trt = trt.replace('ṭ','t');

        trt = trt.replace('ṇ','n');

        trt = trt.replace('ñ','n');

        return trt;
    }
}