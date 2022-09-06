package selenium;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Abinav Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver web = new ChromeDriver();
		
		web.navigate().to("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		
		WebElement wikipediaReleaseDate = web.findElement(By.xpath("/html/body/div[3]/div[3]/div[5]/div[1]/table[1]/tbody/tr[12]/td/div/ul/li"));
		WebElement wikipediaCountry = web.findElement(By.xpath("/html/body/div[3]/div[3]/div[5]/div[1]/table[1]/tbody/tr[14]/td"));
		List<String> releaseDate = new ArrayList<>();
	    releaseDate.add(wikipediaReleaseDate.getText());
	    List<String> country = new ArrayList<>();
	    country.add(wikipediaCountry.getText());
	    
	    System.out.println("Release Date From Wikipedia = " + releaseDate.get(0));
	    System.out.println("Country From Wikipedia = " + country.get(0));
	    
	    web.navigate().to("https://www.imdb.com/title/tt9389998/releaseinfo");
	    
	    WebElement imdbReleaseDate = web.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[1]/div[1]/div[2]/table[1]/tbody/tr[6]/td[2]"));
	    WebElement imdbCountry = web.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[1]/div[1]/div[2]/table[1]/tbody/tr[6]/td[1]"));
	    
	    releaseDate.add(imdbReleaseDate.getText());
	    country.add(imdbCountry.getText());
	    
	    System.out.println("Release Date From IMDB = " + releaseDate.get(1));
	    System.out.println("Country From IMDB = " + country.get(1));
	    
	    
	    Assert.assertEquals(releaseDate.get(0),releaseDate.get(1));
	    Assert.assertEquals(country.get(0),country.get(1));
	    
	    System.out.println("Both Country and Release Date are same ");
	    
	}

}
