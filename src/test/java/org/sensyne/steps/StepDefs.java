package org.sensyne.steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sensyne.pages.HospitalDetailsPage;
import org.sensyne.pages.SearchPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class StepDefs {

    private AndroidDriver driver;
    private SearchPage searchPage;
    private HospitalDetailsPage hospitalDetailsPage;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability( "platformName", "Android");
        capabilities.setCapability( "platformVersion", "11.0");
        capabilities.setCapability( "deviceName","emulator-5554");
        capabilities.setCapability( "automationName", "UiAutomator2");
        capabilities.setCapability( "app", System.getProperty("user.dir")+"/src/test/resources/apps/android/app-release.apk");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        searchPage  = new SearchPage(driver);
        hospitalDetailsPage = new HospitalDetailsPage(driver);


    }

    @Given("^user launches the application$")
    public void userLaunchesTheApplication() {
        searchPage.waitForAppLaunch();
    }

    @When("user searches for {string}")
    public void userSearchesFor(String searchText) {
        searchPage.searchFor(searchText);
    }

    @Then("user sees {string} in the results")
    public void userSeesInTheResults(String result) {
        Assert.assertEquals(result, searchPage.hospitalResults().get(0));
    }

    @When("user selects {string} from the results")
    public void userSelectsFromTheResults(String hospital) {
        searchPage.selectHospital(hospital);
    }

    @Then("user sees name as {string}, subtype as {string}, sector as {string} and phone number as {string}")
    public void userSeesNameAsSubtypeAsSectorAsAndPhoneNumberAs(String name, String type, String sector, String phone) {
        Assert.assertEquals(name, hospitalDetailsPage.getHospitalName());
        Assert.assertEquals(type, hospitalDetailsPage.getType());
        Assert.assertEquals(sector, hospitalDetailsPage.getSector());
        Assert.assertEquals(phone, hospitalDetailsPage.getPhone());
    }
}
