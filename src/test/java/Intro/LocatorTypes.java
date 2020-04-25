package Intro;

import Utils.AndroidDriverUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LocatorTypes {

    DesiredCapabilities desiredCapabilities;
    URL appiumServerUrl;
    AndroidDriver<AndroidElement> driver;
    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps =  AndroidDriverUtil.setupDesiredCapabilities("ApiDemos-debug");
        driver = AndroidDriverUtil.getAndroidDriver(caps);
    }

    @Test
    public void locators(){

        AndroidElement accessibility = driver.findElementByAccessibilityId("Accessibility");
        accessibility.click();

        AndroidElement customView = driver.findElement(By.xpath("//android.widget.TextView[@text='Custom View']"));
        customView.click();

    }
    @Test
    public void locators2 (){

        //resource-id == id in Selenium
        AndroidElement views = driver.findElementById("android:id/text1");
        views.click();
       // "attribute("value")"
        AndroidElement customView = driver.findElementByAndroidUIAutomator("attribute(\"Chronometer\")");
        
    }
}
