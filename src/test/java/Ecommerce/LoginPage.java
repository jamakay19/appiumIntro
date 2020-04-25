package Ecommerce;

import Utils.AndroidDriverUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage (AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    public AndroidElement country;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector())" +
            ".scrollIntoView(text(\"Bolivia\"));")
    public AndroidElement bolivia;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public  AndroidElement username;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    public AndroidElement genderF;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public AndroidElement signIn;

    @AndroidFindBy(xpath = "//android.widget.Toast")
    public AndroidElement toastMessage;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"))")
    public AndroidElement shoes;

    @AndroidFindBy(uiAutomator = "text(\"ADD TO CART\")")
    public AndroidElement addToCart;

    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    public AndroidElement cartBtn;

    @AndroidFindBy(uiAutomator = "text(\"Cart\")")
    public AndroidElement cart;







}
