package com.bestbuy;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DemoBestBuy {
	protected static String url="https://www.google.com/";	
	 WebDriver driver;
	@BeforeSuite
	 public void startChromeBrowser() {
		  WebDriverManager.chromedriver().setup();//setup required initially.
		 
		  driver=new ChromeDriver();
		  driver.navigate().to("https://www.bestbuy.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	 }
//	 @BeforeClass
//	 public void openUrl() {
//		  driver.get(url);	
//	 }
	 	
  @Test(priority=1)
  public void bestbuybrokenurl()throws IOException, InterruptedException {
	  
	   WebElement englishbuttonelement=driver.findElement(By.xpath("(//img[@alt=\"United States\"])[1]"));
	   englishbuttonelement.click();	   
	   WebElement newuserregisterelement=driver.findElement(By.xpath("//span[.='Account']"));
	   newuserregisterelement.click();
		 
//	Registration
	   
	   WebElement createaccountbutton=driver.findElement(By.xpath("//a[.='Create Account']"));
	   createaccountbutton .click();
	   Set<String> windowhandles= driver.getWindowHandles();
	   List<String> listwindows=new ArrayList<>(windowhandles);
	   driver.switchTo().window(listwindows.get(1));
	   
	   WebElement firstname=driver.findElement(By.id("firstName"));
	   firstname.sendKeys("maya");
	   WebElement lastname=driver.findElement(By.id("lastName"));
	   lastname.sendKeys("maya");
	   WebElement email=driver.findElement(By.id("email"));
	   email.sendKeys("maya@gmail.com");
	   WebElement password=driver.findElement(By.id("fld-p1"));
	   password.sendKeys("Maya@1234 -");
	   WebElement confirmpassword=driver.findElement(By.id("reenterPassword"));
	   confirmpassword.sendKeys("Maya@1234 -");
	   WebElement mobileno=driver.findElement(By.id("phone"));
	   mobileno.sendKeys("9580153271");
	   WebElement checkbox=driver.findElement(By.id("is-recovery-phone"));
	   checkbox.click();
	   WebElement submitbutton=driver.findElement(By.cssSelector("button[type='submit']"));
	   submitbutton.click();
	   driver.close();
		 
//login	 
		 WebElement signinbutton=driver.findElement(By.xpath("(//a[normalize-space()='Sign In'])[1]"));
		 signinbutton.click();
		 WebElement signinemail=driver.findElement(By.id("fld-e"));
		 signinemail.sendKeys("thomasphy@gmail.com");
		 WebElement signinpassword=driver.findElement(By.xpath("(//input[@id='fld-p1'])[1]"));
		 signinpassword.sendKeys("Raj@1234 -"); 
		 WebElement loginbutton=driver.findElement(By.xpath("//button[.='Sign In']"));
		 loginbutton.click();
		 driver.navigate().back();
	 }
		 
//Navigate to Menu and Validate		
	 @Test(priority=2)
	  public void menulinks()throws IOException, InterruptedException {
		try {
		 WebElement menu=driver.findElement(By.cssSelector("button[aria-label='Menu']"));
		 menu.click();
		 java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		 System.out.println(links.size());
		 for (int i = 1; i<=links.size(); i=i+1)
		 {
		 System.out.println(links.get(i).getText());
		 }
		}
		catch(Exception e) {
			
		}
		 
	 }
	 
	//Validate Bottom links
	 @Test(priority=3)
	  public void bottomlinks()throws IOException, InterruptedException {
		 try {
		 WebElement footer=driver.findElement(By.id("footer"));
		 List<WebElement> footerlinks = footer.findElements(By.tagName("a"));
		 System.out.println("Footer size is");
		 System.out.println(footerlinks.size());
		 for (int i = 1; i<=footerlinks.size(); i=i+1)
		 {
		 System.out.println(footerlinks.get(i).getText());
		 }
		 }
		 catch(Exception e) {
			 
			 
		 }
	 } 
	  
//	//Search and add an item to cart
	 @Test(priority=4)
	  public void addtocart()throws IOException, InterruptedException {
		 WebElement search=driver.findElement(By.id("gh-search-input"));
		 search.sendKeys("refrigerator");
		 search.click();
		 Thread.sleep(2000);
		 WebElement refrigeratorwhite=driver.findElement(By.xpath("//a[@title='refrigerator white']"));
		 refrigeratorwhite.click();
		 Thread.sleep(1000);
		 JavascriptExecutor js1= (JavascriptExecutor) driver;
		 js1.executeScript("window.scrollBy(0,500)", "");
		 WebElement addtocart=driver.findElement(By.xpath("(//button[text()='Add to Cart'])[2]"));
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		 wait.until(ExpectedConditions.visibilityOf(addtocart));		  
		 addtocart.click();
		 WebElement GoToCart=driver.findElement(By.xpath("//a[text()='Go to Cart']"));
		 GoToCart.click();
		 driver.navigate().back();
		 driver.navigate().back();
	 } 
		 		 
	 
	//Search and add an item to cart from department
		 @Test(priority=5)
		  public void selectitembydept()throws IOException, InterruptedException {
			 WebElement deptmenubutton=driver.findElement(By.cssSelector("button[aria-label='Menu']"));
			 deptmenubutton.click();	 
			 WebElement tvbutton=driver.findElement(By.xpath("//button[text()='TV & Home Theater']"));
			 tvbutton.click();
		     WebElement tvbrand=driver.findElement(By.xpath("//button[text()='TVs by Brand']"));
			 tvbrand.click();
			 WebElement samsung=driver.findElement(By.xpath("//a[text()='Samsung TVs']"));
			 samsung.click();
			 Thread.sleep(1000);
			 WebElement addtocartitem=driver.findElement(By.xpath("(//button[text()='Add to Cart'])[1]"));
			 addtocartitem.click();	
			 WebElement GoToCartDept=driver.findElement(By.xpath("//a[text()='Go to Cart']"));
			 GoToCartDept.click();
			 driver.navigate().back();
		     driver.navigate().back();
		 }
		 

		 
		//Search and add an item to cart from any brands
		 @Test(priority=6)
		  public void selectitembybrand()throws IOException, InterruptedException {
			 WebElement brandmenubutton=driver.findElement(By.cssSelector("button[aria-label='Menu']"));
			 brandmenubutton.click();
			 WebElement brands=driver.findElement(By.xpath("//button[text()='Brands']"));
			 brands.click();
			 Thread.sleep(1000);
			 WebElement lgbrand=driver.findElement(By.xpath("//a[.='LG']"));
			 lgbrand.click();		
			 JavascriptExecutor jslgbrand= (JavascriptExecutor) driver;
			 jslgbrand.executeScript("window.scrollBy(0,1500)", "");
			 Thread.sleep(1000);		
			 WebElement lgdishwasher=driver.findElement(By.xpath("//a[.='LG washers and dryers']"));
			 lgdishwasher.click();		  
			 WebElement lgaddtocart=driver.findElement(By.xpath("(//button[text()='Add to Cart'])[1]"));
			 lgaddtocart.click();
			
			 WebElement GoToCartBrand=driver.findElement(By.xpath("//a[text()='Go to Cart']"));
			 GoToCartBrand.click();		    
		 }
 
		 
		//checkout
		 @Test(priority=7)
		  public void checkout()throws IOException, InterruptedException {		 
			 WebElement Checkoutbutton=driver.findElement(By.xpath("//button[text()='Checkout']"));
			 Checkoutbutton.click();
			 Thread.sleep(1000);
			 WebElement signasguest=driver.findElement(By.xpath("//button[text()='Continue as Guest']"));
			 signasguest.click();
			
			 WebElement firstname=driver.findElement(By.xpath("//input[@id='firstName']"));
			 firstname.sendKeys("maya");
			 WebElement lastname=driver.findElement(By.xpath("//input[@id='lastName']"));
			 lastname.sendKeys("ammu");
			 WebElement Address=driver.findElement(By.id("street"));
			 Address.sendKeys("Green Villa, Third floor");
			 WebElement City=driver.findElement(By.id("city"));
			 City.sendKeys("bangalore");
			 WebElement selectelement=driver.findElement(By.id("state"));
			  Select select=new Select(selectelement);
			  select.selectByIndex(21);
			  Thread.sleep(1000);
			  WebElement zipcode=driver.findElement(By.id("zipcode"));
			  zipcode.sendKeys("56000");
			  WebElement billingaddress=driver.findElement(By.xpath("//span[text()='Use as billing address']"));
			  billingaddress.click();
			  WebElement SaveInformation=driver.findElement(By.xpath("//span[.='Save this information for next time']"));
			  SaveInformation.click();
			  WebElement apply=driver.findElement(By.xpath("//button[.='Apply']"));
			  apply.click();
			  
			  WebElement contactemail=driver.findElement(By.id("user.emailAddress"));
			  contactemail.sendKeys("thomasphy@gmail.com");
			  WebElement contactmobile=driver.findElement(By.id("user.phone"));
			  contactmobile.sendKeys("6282215068");
			  Alert al=driver.switchTo().alert();
			  al.accept();
			  Thread.sleep(2000);
			  System.out.println("Accept Alert");
			  WebElement serviceandappointmentbutton=driver.findElement(By.xpath("//label[text()='My orders, services and appointments']"));
			  serviceandappointmentbutton.click();
			  WebElement schedulebutton=driver.findElement(By.xpath("//span[text()='Continue to Schedule Delivery']"));
			  schedulebutton.click();
		 }
		 
  @AfterSuite		
  public void closeChromeBrowser() {
		  driver.quit();
  }
}

