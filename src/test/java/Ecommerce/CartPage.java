package Ecommerce;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id ="com.androidsample.generalstore:id/termsButton")
    public AndroidElement generalTerms;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/alertTitle")
    public AndroidElement term;

    @AndroidFindBy(id = "android:id/button1")
    public AndroidElement closeButton;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
    public AndroidElement visitWebsite;

}
