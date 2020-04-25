package Intro;

import Utils.AndroidDriverUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Gestures {

    DesiredCapabilities desiredCapabilities;
    URL appiumServerUrl;
    AndroidDriver<AndroidElement> driver;
    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps =  AndroidDriverUtil.setupDesiredCapabilities("ApiDemos-debug");
        driver = AndroidDriverUtil.getAndroidDriver(caps);
    }

    @Test
    public void tapGestures (){

        AndroidElement media=driver.findElementByAccessibilityId("Media");
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(media))).perform();

    }
    @Test
    public void tapGestures2 (){

        AndroidElement media=driver.findElementByAccessibilityId("Views");
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(media))).perform();
        AndroidElement expendibleText = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expendibleText))).perform();
        AndroidElement customAdapter = driver.findElementById("1. Custom Adapter");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapter))).perform();
        AndroidElement catNames = driver.findElement(By.xpath("//android.widget.TextView[@text='Cat Names']"));
        Assert.assertEquals("Cat Names", catNames.getText());


    }
    @Test
    public void longPress (){

        AndroidElement media=driver.findElementByAccessibilityId("Views");
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(media))).perform();
        AndroidElement expendibleText = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expendibleText))).perform();
        AndroidElement customAdapter = driver.findElementById("1. Custom Adapter");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapter))).perform();
        AndroidElement peopleNames  = driver.findElementByAndroidUIAutomator("text(\"People Names\")");
        touchAction.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(2)).
                withElement(ElementOption.element(peopleNames))).perform();
        AndroidElement sampleMenu=driver.findElementByAndroidUIAutomator("text(\"Sample menu\")");
        Assert.assertTrue("Failed to sample menu is displayed",sampleMenu.isDisplayed());
        Assert.assertEquals("Failed to verify sample menu text","Sample menu",sampleMenu.getText());
    }
    @Test
    public void longPress2 (){

        AndroidElement media=driver.findElementByAccessibilityId("Views");
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(media))).perform();
        AndroidElement expendableText = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expendableText))).perform();
        AndroidElement customAdapter = driver.findElementById("1. Custom Adapter");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapter))).perform();
        AndroidElement fishNames  = driver.findElementByAndroidUIAutomator("text(\"Fish Names\")");

        List<AndroidElement> elements=driver.findElements(("text(\"Goldy\")"),("text(\"Bubbles\")"));

        for(AndroidElement element:elements){
            Assert.assertTrue(element.isDisplayed());
        }
        touchAction.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(2)).
                withElement(ElementOption.element(fishNames))).perform();

        AndroidElement sampleMenu = driver.findElementByAndroidUIAutomator("text(\"Sample Menu\")");
        Assert.assertTrue(sampleMenu.isDisplayed());
    }



}

