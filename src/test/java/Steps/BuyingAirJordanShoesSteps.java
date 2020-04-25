package Steps;

import Ecommerce.CartPage;
import Ecommerce.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BuyingAirJordanShoesSteps {

    AndroidDriver<AndroidElement>driver;
    LoginPage loginPage=new LoginPage(driver);

    @Given("user sign in to EcommerceApp using password {string}")
    public void user_sign_in_to_EcommerceApp_using_password(String password) {
        CartPage cartPage=new CartPage(driver);

        loginPage.username.sendKeys(password);
        loginPage.genderF.click();
        loginPage.signIn.click();
    }

    @Given("user add to cart shoes {string}")
    public void user_add_to_cart_shoes(String string) {

        loginPage.shoes.click();
        loginPage.addToCart.click();
        loginPage.cartBtn.click();
        String expectedShoe = "Air Jordan 9 Retro";
    }

    @Then("user verify that shoes are in the cart")
    public void user_verify_that_shoes_are_in_the_cart() {

    }


}
