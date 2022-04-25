//import Utils.Config;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;
import org.testng.*;
//import Utils.*;

public class ProjectListeners implements ITestListener {

    public static ExtentReports extent;
    public static ExtentTest test;



    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest("" + result.getName());

    }



    @Override
    public void onTestFailure(ITestResult result)  {
        try {

            ITestListener.super.onTestFailure(result);
//            Utilities.takeScreenshot("C:\\Users\\akashyab\\BankManagement_MainAssignment\\screenshots\\" ,"Failed test");
        }
        catch (Exception e){
            System.out.println(e);
        }

//        Log4j2_class.logger.error("Test Failed !");

    }

    @Override
    public void onTestSuccess(ITestResult result)  {
        test.pass("Test passed");
        ITestListener.super.onTestFailure(result);

        try {
//            Utilities.takeScreenshot("C:\\Users\\akashyab\\BankManagement_MainAssignment\\screenshots\\", "SS");
            test.pass("Screenshot captured");
        }catch (Exception e ){
//            Log4j2_class.logger.error((String.valueOf(e)));
        }

//        Log4j2_class.logger.info("Test passed");



    }


    @Override
    public void onStart(ITestContext context) {
        extent = Extent_Report.ReportGenerator();

    }


    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

    }


}
