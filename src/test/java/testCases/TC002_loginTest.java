package testCases;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MyAccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import org.openqa.selenium.NoSuchElementException;

public class TC002_loginTest extends BaseClass {

    @Test(groups = {"regression", "Master"})
    public void verifyLogin() throws IOException {

        logger.info("TC002_loginTest is started...");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickmyAccount();
            hp.clickLogin();

            LoginPage login = new LoginPage(driver);
            login.provideEmail(p.getProperty("email"));
            login.providePass(p.getProperty("pass"));
            login.clickLogin();

            MyAccountPage myacc = new MyAccountPage(driver);
            boolean targetPage = myacc.isMyAccountdisplayed();

            Assert.assertEquals(targetPage, true, "Login failed - MyAccount page not displayed.");

        } catch (NoSuchElementException e) {
            logger.error("Element not found: " + e.getMessage());
            captureScreen("verifyLogin");
            Assert.fail("Test failed due to missing web element", e);

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            captureScreen("verifyLogin");
            throw e;

        } catch (Exception e) {
            logger.error("Unexpected error during login test: " + e.getMessage());
            captureScreen("verifyLogin");
            Assert.fail("Test failed due to unexpected exception", e);
        }

        logger.info("TC002_loginTest is successful");
    }
}
