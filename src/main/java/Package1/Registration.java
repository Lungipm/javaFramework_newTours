package Package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {

    //Create an Instance of a driver information to other classes
     public WebDriver driver;

    //add a constructor to pass the driver information to other classes
     public Registration(WebDriver driver){
         this.driver=driver;
     }

    //paging to registration of guru demo site newTours...........
    @FindBy(xpath = "//a[contains(.,'REGISTER')]")
    WebElement register;

//Locate all elements for contact information on registration page.......
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstname;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastname;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement phone;

    @FindBy(xpath = "//input[@name='userName']")
    WebElement email;

//Locate all elements for Mailing Information on registration page......
    @FindBy(xpath = "//input[@name='address1']")
    WebElement address1;

    @FindBy(xpath = "//input[@name='city']")
    WebElement city;

    @FindBy(xpath = "//input[@name='state']")
    WebElement state;

    @FindBy(xpath = "//input[@name='postalCode']")
    WebElement postal;

    //@FindBy(xpath = "//select[@name='country']")
    WebElement country;

//Locate all elements for user information on registration page.......
    @FindBy(xpath = "//input[@name='email']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitRegister;

    //Locate confirmation message of successful registration
    @FindBy(xpath = "//b[contains(.,'Note: Your user name is .')]")
    WebElement registered;

    //Create a method to click register tab. as a next page it requires Web driver wait
    public  void click_register(){
        WebDriverWait registering=new WebDriverWait(driver,20);
        registering.until(ExpectedConditions.visibilityOf(register));
        register.click();
    }

//METHODS: CONTACT INFORMATION

    //Create a method to enter firstname. as a next page it requires web driver wait
    public void enter_firstName(){
        WebDriverWait name=new WebDriverWait(driver, 20);
        name.until(ExpectedConditions.visibilityOf(firstname));
        firstname.sendKeys("Patience");
    }

    //Create a method to enter lastname. DO NOT NEED Web driver wait, since all the fields are on same screen
    public void enter_LastName(){
        lastname.sendKeys("Brown");
    }

    //Create method to enter phone number
    public  void enter_phone(){
        phone.sendKeys("01245678932");
    }

    //Create a method to enter email as a user ID for login
    public void enter_email(){
        email.sendKeys("lungi@gmail.com");
    }


//METHODS: MAILING INFORMATION

    //Create method to enter address
    public void enter_address(){
        address1.click();
    }

    //Create method to enter city
    public void enter_city(){
        city.sendKeys("Pretoria");
    }

    //Create method to enter state
    public  void enter_state(){
        state.sendKeys();
    }

    //Create method to enter postal code
    public void enter_postalCode(){
        postal.sendKeys("90078");
    }

    //Create method to enter country
    public void select_country(){

    }

//METHODS: USER INFORMATION

    //Create method to enter username
    public void enter_username(){
        username.sendKeys("lungim");
    }

    //Create method to enter password
    public void enter_password(){
        password.sendKeys("123456");
    }

    //Create method to enter confirm password
    public void enter_confirmPassword(){
        confirmPassword.sendKeys("123456");
    }

    //Create method to enter submit
    public void submit_registration(){
        WebDriverWait application=new WebDriverWait(driver, 20);
        application.until(ExpectedConditions.visibilityOf(submitRegister));
        submitRegister.click();
       }

    //Create method to that a user has been registered successfully
    public void confirm_registration(){
        WebDriverWait confirmed=new WebDriverWait(driver, 20);
        confirmed.until(ExpectedConditions.visibilityOf(registered));
        registered.isDisplayed();
   }

}
