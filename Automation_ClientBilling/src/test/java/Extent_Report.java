import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public  class Extent_Report {


    public static ExtentReports ReportGenerator() {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\akashyab\\Desktop\\Automation_ClientBilling\\Automation_Testing\\Automation_ClientBilling\\ExtentReport\\report1.html");
        extentReports.attachReporter(reporter);
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Client Billing");
        reporter.config().setReportName("Client Billing_report");
        return extentReports;

    }

}
