package week3.assingment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		/*Assignment 4:Myntra*
		1) Open https://www.myntra.com/
		2) Mouse over on WOMEN 
		3) Click Jackets & Coats
		4) Find the total count of item 
		5) Validate the sum of categories count matches
		6) Check Coats
		7) Click + More option under BRAND	
		8) Type MANGO and click checkbox
		9) Close the pop-up x
		10) Confirm all the Coats are of brand MANGO
		11) Sort by Better Discount
		12) Find the price of first displayed item
		13) Mouse over on size of the first item
		14) Click on WishList Now
		15) Close Browser
*/
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		 //1) Open https://www.myntra.com/
		 driver.get("https://www.myntra.com/");
		  driver.manage().window().maximize();
		
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		  2) Mouse over on WOMEN 
		  Actions actions = new Actions(driver);
           WebElement women = driver.findElement(By.xpath("//a[text() = 'Women']"));
			actions.moveToElement(women).perform();
			Thread.sleep(2000);
//			3) Click Jackets & Coats
			driver.findElement(By.xpath("//a[text() = 'Jackets & Coats']")).click();
//			4) Find the total count of item 
			WebElement totalCount = driver.findElement(By.xpath("(//main[@class='search-base']//div)[3]"));
			System.out.print(totalCount.getText());
			Thread.sleep(2000);
//			5) Validate the sum of categories count matches	
			String jackets = driver.findElement(By.xpath("//label[text()='Jackets']")).getText();
			jackets = jackets.replaceAll("\\D", "");
			String coats = driver.findElement(By.xpath("//label[text()='Coats']")).getText();
			coats = coats.replaceAll("\\D", "");
			int sumOfCategories = Integer.parseInt(jackets) + Integer.parseInt(coats);
			System.out.println(" ");
			System.out.println(jackets + " + " + coats + " = " + sumOfCategories);
//			6) Check Coats		
			driver.findElement(By.xpath("//label[text()='Coats']")).click();
			
//			7) Click + More option under BRAND	
			driver.findElement(By.xpath("(//span[@class='vertical-filters-header'])[2]")).click();
			
 //         8) Type MANGO and click checkbox
			driver.findElement(By.xpath("//label[text()='MANGO']")).click();	
//          9) Close the pop-up x
			driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]")).click();
//         10) Confirm all the Coats are of brand MANGO
			String filterMango = driver.findElement(By.xpath("(//div[@class='filter-summary-filter'])[2]")).getText();
			// System.out.println(filterMango);
			if (filterMango.equalsIgnoreCase("MANGO")) {
				System.out.println("yes");
			} else {
				System.out.println("check");
			}

	// 11) Sort by Better Discount
			WebElement sortBy = driver.findElement(By.className("sort-sortBy"));
			WebElement betterDiscount = driver.findElement(By.xpath("//label[text()='Better Discount']"));
			actions.moveToElement(sortBy).moveToElement(betterDiscount).click().perform();
			System.out.println("Sort to Better Discount");
			Thread.sleep(2000);

	// 12) Find the price of first displayed item
			String firstDisplayedPrice = driver.findElement(By.xpath("(//div[@class='product-price']//span)[2]")).getText();
			System.out.println("first displayed item: " + firstDisplayedPrice);

	// 13 a) Move scroll bar to downwards to view the text using actions
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)");
			// actions.sendKeys(Keys.PAGE_DOWN).build().perform(); // Page Down
			// System.out.println("Perform Scroll down");
			Thread.sleep(3000);

	// 13 b) Mouse over on size of the first item

			WebElement firstDisplayeditem = driver.findElement(By.xpath("(//div[@class='product-price']//span)[2]"));

	// 14) Click on WishList Now
			WebElement wishList = driver
					.findElement(By.xpath("//span[contains(@class,'product-wishlistFlex product-actionsButton')]"));
			actions.moveToElement(firstDisplayeditem).moveToElement(wishList).click().perform();
			
			

	// 15) Close Browser
			driver.close();

	}

}
