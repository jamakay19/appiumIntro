package Intro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumIntro {

    DesiredCapabilities desiredCapabilities;
    URL appiumServerUrl;
    AndroidDriver<AndroidElement> driver;
    @Before
    public void setup() throws MalformedURLException {
        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
        desiredCapabilities=new DesiredCapabilities();

        //device name to connect
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Jamby");

        //platform to use
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,Platform.ANDROID);

        //automation name
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator1");

        //android application to test
        desiredCapabilities.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());

        //setting the server URL to connect to
        appiumServerUrl=new URL("http://localhost:4723/wd/hub");

        //instatiating driver
        driver = new AndroidDriver(appiumServerUrl,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void firstCall() throws MalformedURLException {

        AndroidElement preference=driver.findElementByAccessibilityId("Preference");
        preference.click();

        AndroidElement defaultVal=driver.findElementByXPath("//android.widget.TextView[@content-desc=\"4. Default values\"]");
        defaultVal.click();
        AndroidElement uncheck=driver.findElementById("android:id/widget_frame");
        uncheck.click();

    }
    @Test
    public void secondCall(){
        AndroidElement media=driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Media\"]");
        media.click();
    }


}
