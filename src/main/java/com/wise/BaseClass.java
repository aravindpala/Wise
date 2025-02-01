package com.wise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.wise.pagefactory.GetStartedPage;
import com.wise.pagefactory.GroupCoursesPage;
import com.wise.pagefactory.OnboardingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;

	public GetStartedPage getStatedPage;
	public GroupCoursesPage groupCoursesPage;
	public OnboardingPage onboardingPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void lunchBrowser(String browser, String url) {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + browser.toLowerCase());
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		getStatedPage = new GetStartedPage(driver);
		groupCoursesPage = new GroupCoursesPage(driver);
		onboardingPage = new OnboardingPage(driver);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

//		@BeforeClass
//		public void lunchBrowser() {
//			switch ("chrome"){
//			case "chrome": 
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//			break;
//			case "firefox":
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//				break;
//			default:
//				throw new IllegalArgumentException("Unexpected value: ");
//			}
//			
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//			driver.get("https://staging-web.wise.live/signup");
//			getStatedPage = new GetStartedPage(driver);
//			groupCoursesPage = new GroupCoursesPage(driver);
//			onboardingPage = new OnboardingPage(driver);
//		}
}
