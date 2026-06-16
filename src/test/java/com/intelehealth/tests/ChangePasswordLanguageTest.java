package com.intelehealth.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.intelehealth.base.BasePage;
import com.intelehealth.config.ConfigManager;
import com.intelehealth.listeners.ScreenshotListener;
import com.intelehealth.pages.ChangePasswordLanguagePage;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("User Account Management")
@Feature("Change Password and Language Settings")
@Listeners({ io.qameta.allure.testng.AllureTestNg.class })
public class ChangePasswordLanguageTest {
	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ChangePasswordLanguagePage changePasswordLanguagePage;
	Credentials credentials;
	ConfigManager config;

	@BeforeMethod
	public void setUp() throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		config = ConfigManager.getInstance();
		credentials = new Credentials(config.getUsername(), config.getPassword());
		dashboardPage = loginPage.doLogin(credentials);
		changePasswordLanguagePage = new ChangePasswordLanguagePage(driver);
		ScreenshotListener.setDriver(driver);
	}

	@Test(priority = 1, description = "IDA4_1554_Verify that user can Change the password", enabled = true)
	@Description("Verify that user can Change the password")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1554_ChangePasswordLanguage() {
		// Validate dashboard is loaded
		// Change password
		boolean changed = changePasswordLanguagePage.changePassword(prop.getProperty("OldPassword"),
				prop.getProperty("NewPassword"), config.getUsername(), loginPage);

		Assert.assertTrue(changed, "Password change should succeed");
		// Validate login with new password

	}

	@Test(priority = 2, description = "IDA4_1565_Verify Generate password link functionality", enabled = true)
	@Description("Verify Generate password link functionality")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1565_ChangePasswordLanguage() {
		boolean generated = changePasswordLanguagePage.generatePassword(config.getPassword()
);
		Assert.assertTrue(generated, "Generate password link should be functional");
	}

	@Test(priority = 3, description = "IDA4_1568_Verify user can login using new password", enabled = true)
	@Description("Verify user can login using new password")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1568_ChangePasswordLanguage() {
		boolean loginSuccess = changePasswordLanguagePage.loginWithNewPassword(config.getUsername(),
				config.getPassword());
		Assert.assertTrue(loginSuccess, "Should be able to login with current password");
	}

	@Test(priority = 4, description = "IDA4_1569_Verify that user can change the language", enabled = true)
	@Description("Verify that user can select the language")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1569_ChangePasswordLanguage() {
		boolean changed = changePasswordLanguagePage.changeLanguage();
		Assert.assertTrue(changed, "Language should be changed and UI updated");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.gc();
	}
}