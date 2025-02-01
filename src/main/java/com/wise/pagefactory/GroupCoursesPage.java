package com.wise.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GroupCoursesPage {

	private WebDriver driver;

	@FindBy(css = "input[placeholder='Search course']")
	private WebElement couseSearchField;

	@FindBy(css = "a.hover-underline")
	private List<WebElement> classroomList;

	@FindBy(xpath = "//button[contains(@class,'mdi-arrow-left')]/following-sibling::div/div/div")
	private WebElement classRoomName;

	@FindBy(css = "a[href='#livesessions']")
	private WebElement livesessionsBtn;

	@FindBy(xpath = "//span[contains(text(),'Schedule Sessions')]/ancestor::button")
	private WebElement scheduleSessionsBtn;

	@FindBy(xpath = "//span[text()='Schedule Sessions ']/parent::button")
	private WebElement scheduleSessionsBtn1;

	@FindBy(xpath = "//span[text()='Add session ']/parent::button")
	private WebElement addSessionBtn;

	@FindBy(css = ".timing-card .v-select__slot")
	private WebElement timeField;

	@FindBy(css = "[role='listbox'] .v-list-item__title")
	private List<WebElement> timeList;

	@FindBy(css = "button.primary-bg")
	private WebElement createBtn;

	@FindBy(css = ".session-container")
	private WebElement sessionCard;

	@FindBy(css = ".session-container div div.greySecondary--text div:first-child")
	private WebElement seesionMonth;

	@FindBy(css = ".session-container div div.greySecondary--text div:last-child")
	private WebElement seesionDate;

	@FindBy(css = ".session .text-uppercase")
	private WebElement hostName;

	@FindBy(css = ".session .text-no-wrap")
	private WebElement dayAndTime;

	public GroupCoursesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterCourseName(String couseName) {
		couseSearchField.sendKeys(couseName);
	}

	public void clickOnclassRoomLink(String classroom) throws Exception {
		WebElement ele = classroomList.stream().filter(s -> s.getText().contains(classroom)).findAny().orElse(null);
		if (ele != null) {
			ele.click();
		} else {
			throw new Exception(classroom + " Not Dispayed");
		}
	}

	public void verifyClassRoomIsOpenedOrNot(String classroom) throws Exception {
		try {
			Assert.assertEquals(classRoomName.getText().trim(), classroom.trim(), "Class Room Name");
		} catch (AssertionError e) {
			throw new Exception(e.getMessage());
		}
		System.out.println("classroom is opened successfully");
	}

	public void clickOnLiveSession() {
		livesessionsBtn.click();
	}

	public void clickOnSheduleSessionsButton() {
		try {
			scheduleSessionsBtn.click();
		} catch (NoSuchElementException e) {
			scheduleSessionsBtn1.click();
		}
	}

	public void clickOnAddSession() throws InterruptedException {
		Thread.sleep(2000);
		addSessionBtn.click();
	}

	public void selectTime(String time) {
		timeField.click();
		try {
			timeField.findElement(By.tagName("input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			timeField.findElement(By.tagName("input")).sendKeys(time);
		} catch (StaleElementReferenceException e) {
			timeField.findElement(By.tagName("input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			timeField.findElement(By.tagName("input")).sendKeys(time);
		}
		for (WebElement tim : timeList) {
			if (tim.getText().equalsIgnoreCase(time)) {
				tim.click();
				break;
			}
		}
	}

	public void clickOnCreateButton() {
		createBtn.click();
	}

	public void verifytheSessionCardDisplayedOrNot() throws Exception {
		try {
			Assert.assertTrue(sessionCard.isDisplayed(), "sessionCard");
		} catch (AssertionError e) {
			throw new Exception(e.getMessage());
		}
	}

	public void verifyTheSessionMonth(String sessionMont) throws Exception {
		try {
			Assert.assertEquals(seesionMonth.getText().trim().toLowerCase(), sessionMont.toLowerCase(), "Session Month");
		} catch (AssertionError e) {
			throw new Exception(e.getMessage());
		}
	}

	public void verifyTheSessionDate(String sessionDate) throws Exception {
		try {
			Assert.assertEquals(seesionDate.getText(), sessionDate, "Session Date");
		} catch (AssertionError e) {
			throw new Exception(e.getMessage());
		}
	}

	public void verifyTheHostName(String hostname) throws Exception {
		try {
			Assert.assertEquals(hostName.getText(), hostname, "host Name");
		} catch (AssertionError e) {
			throw new Exception(e.getMessage());
		}
	}

	public void verifyTheSessionDayAndTime(String dayandTime) throws Exception {
		try {
			Assert.assertEquals(dayAndTime.getText(), dayandTime, "Date and time");
		} catch (AssertionError e) {
			throw new Exception(e.getMessage());
		}
	}

//	public void verifyTheSessionDayAndTime(String dayandTime) throws Exception {
//		try {
//			Assert.assertEquals(dayAndTime.getText(), dayandTime, "Date and time");
//			}catch (AssertionError e) {
//				throw new Exception(e.getMessage());
//			}
//	}

}
