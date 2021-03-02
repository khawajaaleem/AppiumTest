package org.sensyne.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HospitalDetailsPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public HospitalDetailsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 30);
    }

    @AndroidFindBy(className = "android.widget.TextView")
    private List<MobileElement> details;

    public String getHospitalName() {
        return getSplitText(details.get(1).getText());
    }

    public String getType() {
        return getSplitText(details.get(2).getText());
    }

    public String getSector() {
        return getSplitText(details.get(3).getText());
    }

    public String getPhone() {
        return getSplitText(details.get(details.size() - 1).getText());
    }

    private String getSplitText(String text) {
        return text.split(":")[1].trim();
    }
}

