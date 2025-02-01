package com.wise.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.LocalDate;

import org.testng.annotations.Test;

import com.wise.BaseClass;

public class EndtoEndCases extends BaseClass {

	@Parameters({"mobileNum","OTP"})
	@Test(description = "Perform login as a tutor")
	public void performLogin(String mobileNum,String OTP) throws Exception {
		onboardingPage.clickOnLoginLink();
		onboardingPage.clickOnLoginWithMobileButton();
		onboardingPage.enterMobileNo(mobileNum);
		onboardingPage.clickOnGetOTPButton();
		onboardingPage.enterOTP(OTP);
		onboardingPage.clickOnVerifyNowButton();
		getStatedPage.verifyInstituteTitle("Testing Institute");
	}
	
	@Test(description = "Go to the classroom",dependsOnMethods = "performLogin")
	public void classRoom() throws Exception {
		getStatedPage.clickOnGroupCourseButton();
		groupCoursesPage.enterCourseName("Classroom for Automated testing");
		groupCoursesPage.clickOnclassRoomLink("Classroom for Automated testing");
		groupCoursesPage.verifyClassRoomIsOpenedOrNot("Classroom for Automated testing");
	}
	
	@Test(description = "Schedule a session", dependsOnMethods = "classRoom")
	public void scheduleSession() throws Exception {
		groupCoursesPage.clickOnLiveSession();
		groupCoursesPage.clickOnSheduleSessionsButton();
		groupCoursesPage.clickOnAddSession();
		groupCoursesPage.selectTime("10:00");
		groupCoursesPage.clickOnCreateButton();		
	}
	
	@Test(description = "Assert the session",dependsOnMethods = "scheduleSession")
	public void assertSession() throws Exception {
		groupCoursesPage.verifytheSessionCardDisplayedOrNot();
		groupCoursesPage.verifyTheSessionDate(String.valueOf(LocalDate.now().getDayOfMonth()));
		groupCoursesPage.verifyTheSessionMonth(String.valueOf(LocalDate.now().getMonth()).substring(0, 3));
		groupCoursesPage.verifyTheHostName("HOSTED BY WISE TESTER");
	}
}
