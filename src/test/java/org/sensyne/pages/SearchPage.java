package org.sensyne.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 30);
    }

    @AndroidFindBy(accessibility = "Search")
    private MobileElement iconSearch;

    @AndroidFindBy(id = "com.sensynehealth.hospitals:id/search_src_text")
    private MobileElement txtSearch;

    @AndroidFindBy(xpath = "//*[@resource-id='com.sensynehealth.hospitals:id/hospitalName']")
    private List<MobileElement> listHospitals;

    public void waitForAppLaunch(){
        wait.until(ExpectedConditions.visibilityOf(iconSearch));
    }

    public void searchFor(String searchText){
        iconSearch.click();
        txtSearch.sendKeys(searchText);
    }

    public List<String> hospitalResults(){
        return listHospitals.stream().map(RemoteWebElement::getText).collect(Collectors.toList());
    }

    public void selectHospital(String name){
        listHospitals.stream().filter(ele -> ele.getText().equalsIgnoreCase(name)).findFirst().get().click();
    }

}
