package java.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.Utilities.BaseUtilities;


public class LoginPage extends BaseUtilities {

    WebDriver localdriver;
    LoginPage(WebDriver remotedriver)
    {
        this.localdriver = remotedriver;
        PageFactory.initElements(remotedriver,this);
    }

    public String url_loginpage = "https://acb-fe-urtjok3rza-wl.a.run.app/login";
    public String invalid_username_data = "Testuser";
    public String invalid_password_data = "Testuser@123";
    public String valid_username_data = "Singh";
    public String valid_password_data = "Singh123$";
    public String text_inside_password ="";
    public String username_xpath =  "//input[@formcontrolname='username']";
    public String password_xpath =  "//input[@placeholder='Enter Password']";
    public String login_xpath   =   "//button[text() = 'LOGIN']";
    public String logo_xpath = "/html/body/app-root/app-login/div/div[2]/img";
    public String eyeicon_xpath = "/html/body/app-root/app-login/div/div[2]/section/section/form/div[2]/div/nz-input-group/span/i";
    public String forgotpassword_xpath = "//p[text() ='Forgot Password?']";
    public String forgotpassword_link ="https://acb-fe-urtjok3rza-wl.a.run.app/forgot-password";




    public void launch_LoginPage(){
        BaseUtilities.launchUrl(url_loginpage);
    }

    public void find_Logo() {

        localdriver.findElement(By.xpath(logo_xpath));
    }


    public void find_UsernameField(){
        BaseUtilities.checkEnabled(username_xpath);
        BaseUtilities.click(username_xpath);

    }

    public void find_PasswordField(){
        BaseUtilities.checkEnabled(password_xpath);
        BaseUtilities.click(password_xpath);
    }

    public void loginwith_Empusername_Emppassword(){
        BaseUtilities.sendKeys(username_xpath,"");
        BaseUtilities.sendKeys(password_xpath,"");
        BaseUtilities.click(login_xpath);
    }


    public void loginwith_Username_Emppassword(){
        BaseUtilities.sendKeys(username_xpath,invalid_username_data);
        BaseUtilities.sendKeys(password_xpath,"");
        BaseUtilities.click(login_xpath);
    }

    public void loginwith_Empusername_password(){
        BaseUtilities.sendKeys(username_xpath,"");
        BaseUtilities.sendKeys(password_xpath,invalid_password_data);
        BaseUtilities.click(login_xpath);
    }

    public void loginwith_Validusername_Invalidpassword(){
        BaseUtilities.sendKeys(username_xpath,valid_username_data);
        BaseUtilities.sendKeys(password_xpath,invalid_password_data);
        BaseUtilities.click(login_xpath);
    }


    public void loginwith_Invalidusername_Validpassword(){
        BaseUtilities.sendKeys(username_xpath,invalid_username_data);
        BaseUtilities.sendKeys(password_xpath,valid_password_data);
        BaseUtilities.click(login_xpath);
    }

    public void loginwith_Invalidusername_Invalidpassword(){
        BaseUtilities.sendKeys(username_xpath,invalid_username_data);
        BaseUtilities.sendKeys(password_xpath,invalid_password_data);
        BaseUtilities.click(login_xpath);
    }

    public void loginwith_Validusername_Validpassword(){
        BaseUtilities.sendKeys(username_xpath,valid_username_data);
        BaseUtilities.sendKeys(password_xpath,valid_password_data);
        BaseUtilities.click(login_xpath);
    }

    public void verify_PasswordVisibility(){

         BaseUtilities.checkEnabled(eyeicon_xpath);
         BaseUtilities.click(eyeicon_xpath);
         text_inside_password =localdriver.findElement(By.xpath(eyeicon_xpath)).getText();

         if(text_inside_password.length()>0){
             Assert.assertTrue(true);
         }

         else {
             Assert.assertTrue(false);
         }
    }


    public void verify_ForgotPassword(){

        BaseUtilities.checkEnabled(forgotpassword_xpath);
        BaseUtilities.click(forgotpassword_xpath);

        if (forgotpassword_link.equals(driver.getCurrentUrl())){
            Assert.assertTrue(true);
        }

        else {
            Assert.assertTrue(false);
        }
    }




































    public static void main(String[] args) {

        BaseUtilities.initialSetup("C:\\Selenium\\chromedriver_win32\\chromedriver.exe");

    }


}
