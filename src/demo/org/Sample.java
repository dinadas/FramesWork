package demo.org;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sony\\Karthik\\Workspace\\FramesWork\\chromedriver.exe"	);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		WebElement a = driver.findElement(By.xpath("//input[@type='text']"));
		a.sendKeys("mobiles");
		
		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='_3wU53n'])[1]")).click();
		Set<String> allhandles = driver.getWindowHandles();
		System.out.println(allhandles);
		for(String childWindow : allhandles) {
			if(!parent.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				//"Good Job"
				//"Great"
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
	}				

}
