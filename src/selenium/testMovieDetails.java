package selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestListener;

import org.testng.annotations.Test;


public class testMovieDetails implements ITestListener {
	
	public static String formatWikiDate(String Date) {
	    String[] split_date_format= Date.split(" ");
	    String Valid_Date_Month = split_date_format[0]+ " " + split_date_format[1] + " " +split_date_format[2].substring(0, 4);
	    return Valid_Date_Month;
	}
	
	public static String formatImdbDate(String Date) {
	    String[] split_imdb_date_format= Date.split(",");
	    String[] split_date_month = split_imdb_date_format[0].split(" ");
	    String Valid_Date_Month = split_date_month[1] + " " + split_date_month[0];
	    Valid_Date_Month +=  split_imdb_date_format[1].substring(0, 5);
	    return Valid_Date_Month;
	}
	
	@Test
	public static void testCountryReleaseDate()  throws InterruptedException {
		
		ResourceBundle bundle = ResourceBundle.getBundle("link");
		String imdb = bundle.getString("imdb_link");
		String wikipedia = bundle.getString("wikipedia_link");
		String[] months = new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November","December"};
		List<WebElement> imdbReleaseDate = Collections.emptyList();
		List<String> country = new ArrayList<>();
		List<String> releaseDate = new ArrayList<>();
		
		System.setProperty("webdriver.chrome.driver", "D:\\Abinav Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver web = new ChromeDriver();
		
		web.navigate().to(wikipedia);
																							
		WebElement wikipediaReleaseDate = web.findElement(By.xpath("//div[contains(text(),'Release date')]//parent::th//following-sibling::td/div/ul/li"));
		String Formatted_Wiki_Date = formatWikiDate(wikipediaReleaseDate.getText()); 
		releaseDate.add(Formatted_Wiki_Date);
	    
		WebElement wikipediaCountry = web.findElement(By.xpath("//th[contains(text(),'Country')]/following-sibling::td"));
	    country.add(wikipediaCountry.getText());
	    
	    web.navigate().to(imdb);
	    
	    for(String month : months) {
	    	imdbReleaseDate = web.findElements(By.xpath("//a[contains(text(),'"+month+"')]"));
	    	if(!imdbReleaseDate.isEmpty()) break;
	    }
	    

	    String Formatted_IMDB_Date = formatImdbDate(imdbReleaseDate.get(0).getText());
	    releaseDate.add(Formatted_IMDB_Date);
	    
	    WebElement imdbCountry = web.findElement(By.xpath(".//a[@href='/search/title/?country_of_origin=IN&ref_=tt_dt_cn']"));
	    country.add(imdbCountry.getText());
	    
	    
	    Assert.assertEquals(country.get(0),country.get(1));
	    System.out.println("Country is same for both IMDB and Wikipedia");
	    
	    Assert.assertEquals(releaseDate.get(0),releaseDate.get(1));

	}
}
