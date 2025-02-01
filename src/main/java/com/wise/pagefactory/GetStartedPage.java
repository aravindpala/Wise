package com.wise.pagefactory;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GetStartedPage {

	private WebDriver driver;

	@FindBy(css = "span.institute-title")
	private WebElement instituteTitle;

	@FindBy(css = "a[href$='live-courses']")
	private WebElement groupCoursebtn;

	public GetStartedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyInstituteTitle(String instituteName) throws Exception {
		String valu = null;
		Thread.sleep(3000);
		try {
			valu = instituteTitle.getText().trim();
		} catch (StaleElementReferenceException e) {
			valu = instituteTitle.getText().trim();
		}
		try {
			Assert.assertEquals(valu, instituteName.trim(), "Institute Name");
		} catch (AssertionError e) {
			throw new Exception(e.getMessage());
		}
		System.out.println("Login successfully, Institute Name Validated");
	}

	public void clickOnGroupCourseButton() {
		groupCoursebtn.click();
	}

}
