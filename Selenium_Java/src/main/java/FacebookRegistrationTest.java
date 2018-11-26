import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import io.quicktype.Converter;
import io.quicktype.Secrets;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class FacebookRegistrationTest
{
        @Test
        public void FacebookRegistrationTestWrongName(FirefoxDriver driver) {

            //I was using quicktype.io to generate the converter class
            //Reading Secrets.json to get username and password
            URL url = Resources.getResource("Secrets.json");
            Secrets jsonString = null;
            //Secrets data = Converter.fromJsonString(Secrets.json);
            try {
                String secretsContent = Resources.toString(url, Charsets.UTF_8);
                jsonString = Converter.fromJsonString(secretsContent);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Load homepage
            driver.get("https://www.facebook.com/");

            //Write first name
            WebElement firstName = driver.findElement(By.name("firstname"));
            firstName.sendKeys(jsonString.getFirstname());

            //Write last name
            WebElement lastName = driver.findElement(By.name("lastname"));
            lastName.sendKeys(jsonString.getLastname());

            // Write mobile or email
            WebElement email = driver.findElement(By.name("reg_email__"));
            email.sendKeys(jsonString.getEmail());

            //confirm email
            WebElement confirmEmail = driver.findElement(By.name("reg_email_confirmation__"));
            confirmEmail.sendKeys(jsonString.getEmail());

            //Write password
            WebElement loginPassword = driver.findElement(By.name("reg_passwd__"));
            loginPassword.sendKeys(jsonString.getPassword());

            //Select Month of birth from the dropdown
            Select monthOfBirth = new Select(driver.findElement(By.name("birthday_month")));
            monthOfBirth.selectByVisibleText(jsonString.getMonthofbirth());

            //Select Day of birth from the dropdown
            Select dayOfBirth = new Select(driver.findElement(By.name("birthday_day")));
            dayOfBirth.selectByVisibleText(jsonString.getDayofbirth());

            //Select Year of birth from the dropdown
            Select yearOfBirth = new Select(driver.findElement(By.name("birthday_year")));
            yearOfBirth.selectByVisibleText(jsonString.getYearofbirth());

            //Choose Radio button Male / Female
            WebElement genderMaleButton = driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
            genderMaleButton.click();

            //click Sign Up, if displayed
            WebElement signUp = driver.findElement(By.name("websubmit"));
            signUp.click();

            assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/confirmemail.php"));
            //Assert.assertEquals("Enter the code from your email", driver.findElement(By.tagName("body")).getText());
        }
}


