package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // ============================================================
    // LOCATORS
    // ============================================================

    @FindBy(name = "user_name")
    private WebElement username;

    @FindBy(name = "user_password")
    private WebElement password;

    @FindBy(id = "submitButton")
    private WebElement loginButton;

    // ============================================================
    // GETTER METHODS
    // ============================================================

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

}
