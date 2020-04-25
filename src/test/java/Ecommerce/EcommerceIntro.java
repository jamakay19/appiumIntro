package Ecommerce;

import Utils.AndroidDriverUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

public class EcommerceIntro {

    AndroidDriver<AndroidElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = AndroidDriverUtil.setupDesiredCapabilities("ecommerceApp");
        driver = AndroidDriverUtil.getAndroidDriver(desiredCapabilities);
    }

    @Test
    public void loginTestPositive() throws InterruptedException {

        LoginPage page = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
       // page.country.click();
       // page.bolivia.click();
        page.username.sendKeys("techtorial");

        if (driver.isKeyboardShown()) {
            driver.hideKeyboard(); }

        //page.genderF.click();
        page.signIn.click();

        page.addToCart.click();
        page.cartBtn.click();

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions()
                .withDuration(Duration.ofSeconds(3)).withElement(ElementOption.element(cartPage.generalTerms))).perform();

        Assert.assertTrue(cartPage.term.isDisplayed());

        cartPage.closeButton.click();
        Set<String> context=driver.getContextHandles();
        System.out.println(context);
        cartPage.visitWebsite.click();
        Thread.sleep(3000);
        Set<String> context1=driver.getContextHandles();
        System.out.println(context1);

        driver.context("WEBVIEW_com.androidsample.generalstore");

    }

    @Test
    public void loginTestNegative() {
        LoginPage page = new LoginPage(driver);
        page.signIn.click();
        String message = page.toastMessage.getAttribute("name");
        Assert.assertEquals("Please enter your name", message);
    }
}


