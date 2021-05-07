package week3.assingment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {
      
	public static void main(String[] args) throws InterruptedException {
		
//		Set the system property and Launch the URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
//		Click the 'sort on date' checkbox
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		clear and type in the from station text field
		 WebElement fromStation = driver.findElement(By.xpath("//input[@placeholder='from station']"));
		 //driver.findElement(By.xpath("//input[@placeholder='From Station']")).clear();
		 //driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys("Pondicherry");
	    	fromStation.clear();
	    	fromStation.sendKeys("Pondicherry");
	    	fromStation.sendKeys(Keys.TAB);
	    	Thread.sleep(2000);
//		clear and type in the to station text field
	    	WebElement tostation=driver.findElement(By.xpath("//input[@placeholder='to station']"));
	        
    		tostation.clear();
        	tostation.sendKeys("Pudukkotai");
        	tostation.sendKeys(Keys.TAB);
//    		Add a java sleep for 2 seconds
        	Thread.sleep(2000);

	    	driver.findElement(By.id("buttonFromTo")).click();

			System.out.println("Details");
//		Store all the train names in a list
			List<WebElement> eleTrainList = driver.findElements(By.xpath("//div[@id='divTrainsList']/table[1]//td[2]"));
			List<String> name = new ArrayList<String>();
			for (int i = 0; i < eleTrainList.size(); i++) {
				name.add(eleTrainList.get(i).getText());
			}
//		Get the size of it
			System.out.println("No.: " + eleTrainList.size());
//		Add the list into a new Set
			Set<String> set = new TreeSet<String>(name);

			set.addAll(name);
//		And print the size of it
			System.out.println("Size:" + name.size());
	}

}

