package bots;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class flyr_bot_headlessHtmlUnit {
    public static void main(String[] args) throws IOException, Exception {
        WebClient client = new WebClient();

        client.getOptions().setCssEnabled(true);
        client.getOptions().setJavaScriptEnabled(false);

        String by_fra = "OSL";
        String by_til = "BGO";
        String dato = "2022-08-13";
        HtmlPage page = client.getPage("https://flyr.com/booking?currency=NOK&onlyDirectFlights=false&returnFlight=false&adults=1&children=0&infants=0&origin=" + by_fra + "&destination=" + by_til + "&shoppingMode=youth&departureDay=" + dato + "T22%3A00%3A00.000Z");
        /*page.getByXPath("//button[@class='css-m0zmyx']").*/

        System.out.println(page.asXml());

        //xpath for pris
       /* System.out.println(page.getByXPath("//*[@class='css-10g51w1']"));*/


        /*System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\47416\\Documents\\StudentReisePlanlegger\\Python shit\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();*/


        //Godta cookies
        /*driver.findElement(By.xpath("//button[@class='css-m0zmyx']")).click();

        //Finn pris på avgang
        WebElement pris = driver.findElement(By.xpath("//*[@class='css-10g51w1']"));
        String prisString = pris.getText();
        System.out.println(prisString);
        int prisInt = Integer.parseInt(prisString.replaceAll("[\\D]", ""));
        System.out.println(prisInt);*/
    }
}
