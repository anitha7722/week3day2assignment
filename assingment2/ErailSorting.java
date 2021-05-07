package week3.assingment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSorting {

	public static void main(String[] args) throws InterruptedException {
//			Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
//			Launch the URL - https://erail.in/
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			Uncheck the check box - sort on date
		driver.manage().window().maximize();
		driver.findElement(By.id("chkselectdateonly")).click();
		Thread.sleep(2000);
		System.out.println("unchecked the sort on date");
		Thread.sleep(2000);
//			clear and type in the source station 
		    WebElement fromStation=driver.findElement(By.xpath("//input[@placeholder='from station']"));
		    Thread.sleep(2000);
	    	fromStation.clear();
	    	fromStation.sendKeys("Pondicherry");
	    	fromStation.sendKeys(Keys.TAB);
	    	Thread.sleep(2000);
//			clear and type in the destination station
	        WebElement tostation=driver.findElement(By.xpath("//input[@placeholder='to station']"));
	        Thread.sleep(2000);
    		tostation.clear();
        	tostation.sendKeys("Pudukkotai");
        	tostation.sendKeys(Keys.TAB); 
        	Thread.sleep(2000);
//			Find all the train names using xpath and store it in a list
        	driver.findElement(By.id("buttonFromTo")).click();
        	driver.findElement(By.id("chkselectdateonly")).click();
        	List<WebElement> eleTrainList = driver.findElements(By.xpath("//div[@id='divTrainsList']/table[1]//td[2]"));
    		System.out.println("Train count: " + eleTrainList.size());
    		ArrayList<String> trainName = new ArrayList<String>();
    		for (int i = 0; i < eleTrainList.size(); i++) {
    	    trainName.add(eleTrainList.get(i).getText());
    		}
//			Use Java Collections sort to sort it and then print it
    		
    		Collections.sort(trainName);
    		System.out.println("sorted: ");
    		trainName.forEach(System.out::println);

	

}
}
