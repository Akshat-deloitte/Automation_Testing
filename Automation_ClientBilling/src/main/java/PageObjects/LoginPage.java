package PageObjects;
import Utilities.BaseUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;


public class LoginPage extends BaseUtilities{

    WebDriver localdriver;
    WebDriverWait w = new WebDriverWait(driver, 5);
    public LoginPage(WebDriver remotedriver)
    {
        this.localdriver = remotedriver;
        PageFactory.initElements(remotedriver,this);
    }

    public String url_loginpage = "https://acb-fe-urtjok3rza-wl.a.run.app/login";
    public String text_inside_password ="";
    public String username_xpath =  "//input[@formcontrolname='username']";
    public String password_xpath =  "//input[@placeholder='Enter Password']";
    public String login_xpath   =   "//button[text() = 'LOGIN']";
    public String logo_xpath = "/html/body/app-root/app-login/div/div[2]/img";
    public String eyeicon_xpath = "/html/body/app-root/app-login/div/div[2]/section/section/form/div[2]/div/nz-input-group/span/i";
    public String forgotpassword_xpath = "//p[text() ='Forgot Password?']";
    public String forgotpassword_link ="https://acb-fe-urtjok3rza-wl.a.run.app/forgot-password";
    By Logout_dropdown =  By.xpath("//app-header/div[1]/div[3]/a[1]/i[1]/*[1]");
    By Logout_Button =  By.xpath("//li[contains(text(),'Logout')]");
    public String url_after_login;

    /**
     * Row1 - Credentials for Admin
     * Row2 - Credentials for client
     * Row3 - Credentials for TeamLead
     * Row4 - Invalid Credentials
     */

    public  void Logout_page()
    {
        localdriver.findElement(Logout_dropdown).click();
        localdriver.findElement(Logout_Button).click();
    }

    public void check_for_Alert(){
        try {
            w.until(ExpectedConditions.alertIsPresent());
            Assert.assertTrue(true,"Caught and alert , Test Passed");

        }catch (Exception e){
            clear_Fields();
            Assert.assertTrue(false,"No alert exists");
        }
    }

    public void clear_Fields(){
        localdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        localdriver.findElement(By.xpath(username_xpath)).clear();
        localdriver.findElement(By.xpath(password_xpath)).clear();
    }


    public void assert_ValidLogin(){
        BaseUtilities.wait_by_Xpath("/html/body/app-root/app-dashboard/app-header/div/div[2]/div[1]");
        if(localdriver.getCurrentUrl().equals("https://acb-fe-urtjok3rza-wl.a.run.app/admin/monthly-expense")){
            Logout_page();
            clear_Fields();
            Assert.assertTrue(true,"logged in with valid credentials");
        }
        else {
            Assert.assertTrue(false);
        }

    }


    public void assert_TeamLeadLogin() throws IOException {
        BaseUtilities.wait_by_Xpath("/html/body/app-root/app-not-found/div/div/div/div/h1");
        System.out.println(localdriver.getCurrentUrl());
        if(localdriver.getCurrentUrl().equals("https://acb-fe-urtjok3rza-wl.a.run.app/team-lead/team-dashboard")) {

            try {
                localdriver.findElement(By.xpath("//a[text() =' Team Lead Dashboard ']"));
            } catch (Exception e) {
                localdriver.navigate().back();
                clear_Fields();
                Assert.assertTrue(false);
            }
        }
    }


    public void assert_ClientLogin() throws IOException {
        BaseUtilities.wait_by_Xpath("/html/body/app-root/app-not-found/div/div/div/div/h1");
        System.out.println(localdriver.getCurrentUrl());
        if(localdriver.getCurrentUrl().equals("https://acb-fe-urtjok3rza-wl.a.run.app/client/client-dashboard")) {

            try {
                localdriver.findElement(By.xpath("//a[text() =' Client Dashboard ']"));
            } catch (Exception e) {

                localdriver.navigate().back();
                clear_Fields();
                Assert.assertTrue(false);
            }
        }
    }



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

    public void loginwith_Empusername_Emppassword()throws TimeoutException {
        BaseUtilities.sendKeys(username_xpath,"");
        BaseUtilities.sendKeys(password_xpath,"");
        BaseUtilities.click(login_xpath);
        check_for_Alert();
    }


    public void loginwith_Invalidusername_Emppassword() throws IOException {
        BaseUtilities.sendKeys(username_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name ,4 , 0));
        BaseUtilities.sendKeys(password_xpath,"");
        BaseUtilities.click(login_xpath);
        check_for_Alert();
    }


    public void loginwith_Empusername_Invalidpassword() throws IOException {
        BaseUtilities.sendKeys(username_xpath,"");
        BaseUtilities.sendKeys(password_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name,4,1));
        BaseUtilities.click(login_xpath);
        check_for_Alert();
    }


    public void loginwith_Validusername_Invalidpassword() throws IOException {
        BaseUtilities.sendKeys(username_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name,1,0));
        BaseUtilities.sendKeys(password_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name,4,1));
        BaseUtilities.click(login_xpath);
        check_for_Alert();
    }


    public void loginwith_Invalidusername_Validpassword() throws IOException {
        BaseUtilities.sendKeys(username_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name ,4 , 0));
        BaseUtilities.sendKeys(password_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name ,1 , 1));
        BaseUtilities.click(login_xpath);
        check_for_Alert();
    }

    public void loginwith_Invalidusername_Invalidpassword() throws IOException {
        BaseUtilities.sendKeys(username_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name ,4 , 0));
        BaseUtilities.sendKeys(password_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name,4,1));
        BaseUtilities.click(login_xpath);
        check_for_Alert();
    }


    public void loginwith_Validusername_Validpassword() throws IOException {
        BaseUtilities.sendKeys(username_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name,1,0));
        BaseUtilities.sendKeys(password_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name ,1 , 1));
        BaseUtilities.click(login_xpath);
//        assert_ValidLogin();
    }

    public void loginwith_Admin() throws IOException {
        BaseUtilities.sendKeys(username_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name,1,0));
        BaseUtilities.sendKeys(password_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name ,1 , 1));
        BaseUtilities.click(login_xpath);
        assert_ValidLogin();
    }

    public void loginwith_TeamLead() throws IOException {
        BaseUtilities.sendKeys(username_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name,3,0));
        BaseUtilities.sendKeys(password_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name ,3 , 1));
        BaseUtilities.click(login_xpath);
        assert_TeamLeadLogin();
    }

    public void loginwith_Client() throws IOException {
        BaseUtilities.sendKeys(username_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name,2,0));
        BaseUtilities.sendKeys(password_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name ,2 , 1));
        BaseUtilities.click(login_xpath);
        assert_ClientLogin();
    }


    public void PasswordVisibility() throws IOException {

         BaseUtilities.checkEnabled(eyeicon_xpath);
         BaseUtilities.sendKeys(password_xpath,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name ,2 , 1));
         BaseUtilities.click(eyeicon_xpath);
         text_inside_password =localdriver.findElement(By.xpath(password_xpath)).getAttribute("value");
         System.out.println(text_inside_password);

         if(text_inside_password.equals(BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name ,2 , 1))){
             Assert.assertTrue(true);
         }

         else {
             Assert.assertTrue(false);
         }
    }


    public void ForgotPassword(){
        BaseUtilities.checkEnabled(forgotpassword_xpath);
        BaseUtilities.click(forgotpassword_xpath);

        if (forgotpassword_link.equals(driver.getCurrentUrl())){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }
}
