import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SetupSelenium {
    public static void main(String[] args){
        //if you didn't update the Path system variable to add the full directory path to the executable as above mentioned then doing this directly through code
        System.setProperty("webdriver.gecko.driver", "/App/Selenium/geckodriver-v0.23.0-win64/geckodriver.exe");

//Now you can Initialize marionette driver to launch firefox
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        //WebDriver driver = new MarionetteDriver(capabilities);
        FirefoxDriver driver=new FirefoxDriver();


        FacebookRegistrationTest register = new FacebookRegistrationTest();
        register.FacebookRegistrationTestWrongName(driver);

    }
}