package java.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;




public class SendToClientPage {


    WebDriver local_driver;
    SendToClientPage(WebDriver remote_driver)
    {
        this.local_driver = remote_driver;
        PageFactory.initElements(remote_driver,this);
    }

    By send_to_client_button = By.xpath("//*[text()=' SEND TO CLIENT ']");
    By choose_month = By.xpath("//*[text()='Choose Month']");
    By choose_year = By.xpath("//*[text()='Choose Year']");
    By choose_bill = By.xpath("//*[text()='Choose from Unverified Bills']");
    By month_list = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/div[2]/div[1]/div[2]/select");
    By year_list = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/div[2]/div[2]/div[2]/select");
    By bill_list = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/div[2]/div[3]/div[2]/select");
    By submit_button = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/div[2]/button");
    By send_for_approval = By.xpath("//*[text()='SEND FOR APROVAL']");


    // cases to check if buttons are clickable
    public void client_button() {
        Assert.assertTrue(local_driver.findElement(send_to_client_button).isEnabled());
    }

    public void month073() {
        Assert.assertTrue(local_driver.findElement(month_list).isEnabled());
    }

    public void year075() {
        Assert.assertTrue(local_driver.findElement(year_list).isEnabled());
    }

    public void bill077() {
        Assert.assertTrue(local_driver.findElement(bill_list).isEnabled());
    }

    public void submit() {
        Assert.assertTrue(local_driver.findElement(submit_button).isEnabled());
    }

    public void approval094() {
        Assert.assertTrue(local_driver.findElement(send_for_approval).isEnabled());
    }

    // cases to check if data is visible
    public void month074() {
        Assert.assertTrue(local_driver.findElement(choose_month).isDisplayed());
    }

    public void year076() {
        Assert.assertTrue(local_driver.findElement(choose_year).isDisplayed());
    }

    public void bill078() {
        Assert.assertTrue(local_driver.findElement(choose_bill).isDisplayed());
    }

}
