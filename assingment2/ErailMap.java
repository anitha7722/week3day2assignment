package week3.assingment2;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailMap {

	public static void main(String[] args) {
//1) Set the property
		WebDriverManager.chromedriver().setup();
//	2) Initiate ChromeDriver class
		ChromeDriver driver = new ChromeDriver();
//	3) Launch the URL - https://erail.in/
		driver.get("https://erail.in/");
//	4) Maximize the browser
		driver.manage().window().maximize();
//	5) Add implicityWait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	6) Clear and type in the from station
		WebElement fromStation = driver.findElement(By.xpath("//input[@placeholder='From Station']"));
		fromStation.clear();
		fromStation.sendKeys("Pondicherry");
		fromStation.sendKeys(Keys.TAB);
//	7) Clear and type in the to station
		WebElement toStation = driver.findElement(By.xpath("//input[@placeholder='To Station']"));
		toStation.clear();
		toStation.sendKeys("Pudukkotai");
		toStation.sendKeys(Keys.TAB);
//	8) Uncheck the 'Sort on Date' checkbox		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
//	9) Declare a Map
		Map<String,String> map = new HashMap<String,String>();
//	10) Store the table in a web element
		 List<WebElement>Train=driver.findElements(By.xpath("//table[@class='DataTable TrainListHeader']"));
		

//	11) Get all the rows and store it in a List
		
		for(WebElement row :Train) {
					List<WebElement>coloums=row.findElements(By.tagName("td"));
					for (WebElement cols:coloums) {
					if(cols.getText().startsWith("m")) {
						map.put(cols.getText(), cols.getText());
						System.out.println(map.values());
					}
					}
		}
	}
}

	

					
		
	
