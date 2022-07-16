package javaAssignments.week2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		String title = driver.getTitle();
			System.out.println(title);
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Ranjini");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Rajendran");
		
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select drop1 = new Select(source);
		drop1.selectByVisibleText("Conference");
		
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("RR");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("_infinity");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Ms.");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Selenium");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("JAVA");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Welcome to Selenium with JAVA Learning");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("ranjini.1213@gmail.com");
		
		WebElement stateprovincegeo = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select statedrop = new Select(stateprovincegeo);
		statedrop.selectByVisibleText("New York");
		
		driver.findElement(By.className("smallSubmit")).click();
		
		String title2 = driver.getTitle();
		System.out.println(title2);
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("I confirm the title has View Lead");
		}else
			System.out.println("The title has no View Lead");
	}
		
		
	

}
