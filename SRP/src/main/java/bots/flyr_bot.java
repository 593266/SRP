package bots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flyr_bot {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\47416\\Documents\\StudentReisePlanlegger\\Python shit\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        String by_fra = "OSL";
        String by_til = "BGO";
        String dato = "2022-08-13";
        driver.navigate().to("https://flyr.com/booking?currency=NOK&onlyDirectFlights=false&returnFlight=false&adults=1&children=0&infants=0&origin=" + by_fra + "&destination=" + by_til + "&shoppingMode=youth&departureDay=" + dato + "T22%3A00%3A00.000Z");

        //Godta cookies (Unødvendig, kan hente data uten å godta cookies)
        /*driver.findElement(By.xpath("//button[@class='css-m0zmyx']")).click();*/

        //Finn pris på avgang
        WebElement pris = driver.findElement(By.xpath("//*[@class='css-10g51w1']"));
        String prisString = pris.getText();
        System.out.println(prisString);
        int prisInt = Integer.parseInt(prisString.replaceAll("[\\D]", ""));
        System.out.println(prisInt);
/*
        System.out.println((pris.getText().replaceAll("[\\D]", "")));
*/

        driver.quit();

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        long timeInMs = (totalTime/1000000);
        System.out.println(timeInMs);



    }
}
