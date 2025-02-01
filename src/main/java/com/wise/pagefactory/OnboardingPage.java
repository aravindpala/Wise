package com.wise.pagefactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnboardingPage {

	private WebDriver driver;

	@FindBy(xpath = "//div[contains(text(),'Login')]")
	private WebElement loginLink;

	@FindBy(xpath = "//img[contains(@src,'mobile.svg')]//ancestor::button")
	private WebElement mobileBtn;

	@FindBy(css = "input[placeholder='Phone number']")
	private WebElement phoneNoTF;

	@FindBy(xpath = "//span[contains(text(),'Get OTP')]/parent::button")
	private WebElement getOTPBtn;

	@FindBy(css = "input[class |='otp-field']")
	private List<WebElement> OTPFields;

	@FindBy(xpath = "//span[contains(text(),'Verify')]/parent::button")
	private WebElement verifyBtn;

	public OnboardingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnLoginLink() {
		loginLink.click();
	}

	public void clickOnLoginWithMobileButton() throws InterruptedException {
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		try {
			ac.doubleClick(mobileBtn).perform();
		} catch (StaleElementReferenceException e) {
			ac.doubleClick(mobileBtn).perform();
		}
	}

	public void enterMobileNo(String mobileNo) {
		phoneNoTF.sendKeys(mobileNo);
	}

	public void clickOnGetOTPButton() {
		getOTPBtn.click();
	}

	public void enterOTP(String otp) {
		for (int i = 0; i < OTPFields.size(); i++) {
			OTPFields.get(i).sendKeys(String.valueOf(otp.charAt(i)));
		}
	}

	public void clickOnVerifyNowButton() {
		verifyBtn.click();
	}

}
