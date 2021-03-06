import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class webpage {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void webpage() {
        wd.get("http://demosite.center/wordpress/wp-login.php");
        wd.findElement(By.id("user_login")).click();
        wd.findElement(By.id("user_login")).clear();
        wd.findElement(By.id("user_login")).sendKeys("user");
        wd.findElement(By.id("user_pass")).click();
        wd.findElement(By.id("user_pass")).clear();
        wd.findElement(By.id("user_pass")).sendKeys("passwd");
        wd.findElement(By.id("wp-submit")).click();
        wd.findElement(By.id("login_error")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
