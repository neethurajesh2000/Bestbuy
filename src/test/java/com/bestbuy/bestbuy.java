package com.bestbuy;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class bestbuy {
	protected static String url="https://www.google.com/";	
	 WebDriver driver;
	@BeforeSuite
	 public void startChromeBrowser() {
		  WebDriverManager.chromedriver().setup();//setup required initially.
		 
		  driver=new ChromeDriver();
//		  driver.get("https://www.google.com/");
		  driver.navigate().to("https://www.bestbuy.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	 }
	 @BeforeClass
//	 public void openUrl() {
//		  driver.get(url);	
//	 }
	 	
  @Test
  public void bestbuybrokenurl()throws IOException, InterruptedException {
	  
		//create set of url
	  Set<String> brokenlinkurls=new HashSet<String>();
	  List<WebElement>  links=driver.findElements(By.tagName("a"));
	  System.out.println(links.size());	  
	  //iterate through each link
	  for(WebElement link:links) {
		String linkurl= link.getAttribute("href");
//		Proxy proxy=new Proxy(java.net.Proxy.Type.HTTP,new InetSocketAddress("google",80));
		//create url object
		URL url=new URL(linkurl);
		//open connection using url for specifi proxy
//	    URLConnection urlConnection=url.openConnection(proxy);
	    //caste thr url connection to httpurl connection
//	    HttpURLConnection httpURLConnection= (HttpURLConnection)urlConnection;
		HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
	    httpURLConnection.setConnectTimeout(5000);
	    httpURLConnection.connect();//establish connection
	    	    
	    //check if http connection code !=200
	    if(httpURLConnection.getResponseCode()==200) {
	    	System.out.println("Working url :"+httpURLConnection.getResponseMessage());
	    }else {
	    	System.out.println("broken url: "+httpURLConnection.getResponseMessage());
	    }
	    httpURLConnection.disconnect();
	
	  }
	   WebElement englishbuttonelement=driver.findElement(By.xpath("//button[text()='English']"));
	   englishbuttonelement.click();
	   	   
  }
  
//  @Test
//  public void bestbuyregisteration() {
//	   WebElement englishbuttonelement=driver.findElement(By.xpath("//button[@class='is-active']"));
//	   englishbuttonelement.click();
//	   WebElement newuserregisterelement=driver.findElement(By.xpath("//span[@class='v-p-right-xxs line-clamp']"));
//	   newuserregisterelement.click();
//	   WebElement createaccountbutton=driver.findElement(By.xpath("//a[normalize-space()='Create Account']"));
//	   createaccountbutton .click();
//  }
	  
  
//  @AfterSuite		
//  public void closeChromeBrowser() {
//		  driver.quit();
//  }
}
