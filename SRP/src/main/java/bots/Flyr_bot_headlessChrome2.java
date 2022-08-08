package bots;
/**
 * @auth JBach
 */

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import entities.FlightDeparture;
import entities.Flights;
import services.Timer;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class Flyr_bot_headlessChrome2 {
    public static void main(String[] args) throws InterruptedException {

        //TODO Extend the program to use threads and check potential increace in efficiency

        //Create list of Norwegian airports
        List<String> airportsFlyr = new ArrayList<>();
        airportsFlyr.add("OSL"); //Oslo
        airportsFlyr.add("BGO"); //Bergen
        airportsFlyr.add("BOO"); //Bodø
        airportsFlyr.add("EVE"); //Harstad Narvik
        airportsFlyr.add("KSU"); //Kristiansund
        airportsFlyr.add("SVG"); //Stavanger
        airportsFlyr.add("TOS"); //Tromsø
        airportsFlyr.add("TRD"); //Trondheim


      //Table<"OSL-BGO", "yyyy-mm-dd", HashMap<"tt:mm", pris>>
        HashMap<String,Integer> specificDepartures = new HashMap<>();
        specificDepartures.put("12:00", 1000);
        specificDepartures.put("13:00", 800);
        Table<String, String, HashMap<String,Integer>> allFlights = HashBasedTable.create();
        allFlights.put("OSL-BGO", "2022-07-01", specificDepartures);
        System.out.println(allFlights);

        //TODO Create hashmap of possible connections between all airports
        /*Map<String, String> airportConnections = new HashMap<>(); //Map<String, String> = Map<flyavgang("OSL-BGO"),
        for (String airportDeparture : airportsFlyr) {
            for (String airportArrival : airportsFlyr) {
                airportConnections.put(airportDeparture, airportArrival);
            }
        }

        for (int i = 0; i < airportsFlyr.size(); i++) {
            for (int j = 0; j < airportsFlyr.size(); j++) {
                airportConnections.put(airportsFlyr.get(i), airportsFlyr.get(j));
            }
        }

        airportConnections.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });*/


        //Instantiate Flights and FlightDeparture class
        Flights flights;
        FlightDeparture flightDeparture;

        //Instansier timer klasse
        Timer timer = new Timer();

        //Start timer for how long the program takes
        long start = System.currentTimeMillis();
        long startTimerCreate = timer.startTimer();
        //set path for chromedriver
        String chromeDriverPath = "C:\\java\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        //Change settings for the chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        System.out.println(timer.endTimer(startTimerCreate) + " ms - Create");

        //create chromedriver object
        long startTimerStart = timer.startTimer();
        WebDriver driver = new ChromeDriver(options);
        System.out.println(timer.endTimer(startTimerStart) + " ms - start driver");



        long startTimerRetrive = timer.startTimer();
        String by_fra = "OSL";
        String by_til = "BGO";
        String dato = "2022-07";

        //all Flights for a month
        driver.get("https://flyr.com/booking?adults=1&children=0&infants=0&shoppingMode=youth&origin=" + by_fra + "&destination=" + by_til + "&returnFlight=false&targetMonth=" + dato);
        System.out.println(timer.endTimer(startTimerRetrive) + " ms - retrive site");

        //Waits for all elements(prices) to be loaded
        long startTimerWait = timer.startTimer();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        /*wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='css-10g51w1']")));*/
        System.out.println(timer.endTimer(startTimerWait) + " ms - wait for site to load");


        //Godta cookies (Unødvendig, kan hente data uten å godta cookies)
        /*driver.findElement(By.xpath("//button[@class='css-m0zmyx']")).click();*/
        //Timeout for the page to load
        /*TimeUnit.MILLISECONDS.sleep(2000);*/

        long startTimerGetPrice = timer.startTimer();
        //Find all prices based on css selector //equally fast as xpath
        List<WebElement> priserCss = driver.findElements(By.cssSelector(".css-10g51w1"));
        List<String> priserCssString = new ArrayList<>();
        for (WebElement p : priserCss) {
            priserCssString.add(p.getText());
        }
        System.out.println(Arrays.toString(priserCssString.toArray()));

        System.out.println(timer.endTimer(startTimerGetPrice) + " ms - Get prices");


        //Convert price object to String, then to int
        /*String prisString = prisXpath.getText();
        int prisInt = Integer.parseInt(prisString.replaceAll("[\\D]", ""));
        System.out.println(prisInt);*/

        //End chromedriver session

        long startTimerEndDriver = timer.startTimer();
        driver.quit();
        System.out.println(timer.endTimer(startTimerEndDriver) + " ms - close driver");


        //End timer
        long endTimeTot = System.currentTimeMillis();
        long totalTimeTot = endTimeTot - start;

        System.out.println(totalTimeTot + "ms end");


    }
}
