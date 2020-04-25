package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class APIDemosMainPage {

    public APIDemosMainPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Accessibility']")
    public AndroidElement accessibility;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Animation']")
    public AndroidElement animation;
    @AndroidFindBy(accessibility = "App")
    public AndroidElement app;
    @AndroidFindBy(uiAutomator = "text(\"Content\")")
    public AndroidElement content;
    @AndroidFindBy(accessibility = "Graphics")
    public AndroidElement graphics;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Media']")
    public AndroidElement media;
    @AndroidFindBy(accessibility = "NFC")
    public AndroidElement NFC;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='OS']")
    public AndroidElement OS;
    @AndroidFindBy(accessibility = "Preference")
    public AndroidElement preference;
    @AndroidFindBy(accessibility = "Text")
    public AndroidElement text;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
    public AndroidElement views;
}


