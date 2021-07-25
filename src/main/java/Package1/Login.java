package Package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {

    //create an instance of a driver information to other classes
    private WebDriver driver;

    //constructor to pass driver information to other classes
    public Login(WebDriver driver){
        this.driver=driver;
    }

    //Locate all elements for login screen
    @FindBy(xpath = "//a[contains(.,'SIGN-ON')]")
    WebElement signOn;

    @FindBy(xpath = "//input[@name='userName']")
    WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement loginSubmit;

    @FindBy(xpath = "//b[contains(.,'Thank you for Loggin.')]")
    WebElement SuccessLogin;

    //Create a method to click log-in link
    public void clicking_signOn_button(){
        //Wait for up to 30 seconds as set below for the element to be visible....if it becomes available on the 3rd seconds it will go to the next line/block of code
        WebDriverWait sign=new WebDriverWait(driver,30);
        sign.until(ExpectedConditions.visibilityOf(signOn));
        signOn.click();
    }

    //Create a method to capture username field
    public void enter_username(){
        //Wait for specified seconds for username field to be displayed
        WebDriverWait User=new WebDriverWait(driver,30);
        User.until(ExpectedConditions.visibilityOf(userName));
        userName.sendKeys("princeM");
    }

    //Create method to enter password....no need to waitUntil, as it is on same page
    public void enter_password(){
        password.sendKeys("123456");
    }

    //Create method to click submit button
    public void  submit_login(){

        //Wait for specified seconds for submit button to be enabled
        WebDriverWait submit=new WebDriverWait(driver,30);
        submit.until(ExpectedConditions.visibilityOf(loginSubmit));

        loginSubmit.click();
    }

    //Create method to verify a user is logged in successfully
    public void welcome() {

        //Wait for specified seconds for confirmation message to display
        WebDriverWait welcome = new WebDriverWait(driver, 30);
        welcome.until(ExpectedConditions.visibilityOf(SuccessLogin));

        //Assert or verify that welcome message is displayed. This is the shorter form of if statement
        Assert.assertTrue(SuccessLogin.isDisplayed());
        //Assert.assertEquals("",SuccessLogin.getText());

    }
}
