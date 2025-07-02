package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC0005_CarouselTest extends BaseClass {

    @Test(groups = "regression")
    public void carouselTest() {
        try {
            HomePage hp = new HomePage(driver);
            boolean isWorking = hp.isCarouselWorking();
            Assert.assertTrue(isWorking, "❌ Carousel did not show all expected images.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("❌ Test failed due to exception: " + e.getMessage());
        }
    }
}
