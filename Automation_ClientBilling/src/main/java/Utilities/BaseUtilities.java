package java.Utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;


public class BaseUtilities {


    public static WebDriver driver;
    public static FileInputStream fileinput;
    public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static XSSFRow row;
    public static XSSFCell cell;


    public static WebDriver initialSetup(String path) {

        System.setProperty("webdriver.chrome.driver",path);
        driver = new ChromeDriver();
        System.out.println("Web driver initialized");
        return driver;

    }



    public static int getRowCount(String FilePath, String xlsheetname) throws IOException {
        int rowcount;
        fileinput = new FileInputStream(FilePath);

        workbook = new XSSFWorkbook(fileinput);
        worksheet = workbook.getSheet(xlsheetname);
        rowcount = worksheet.getLastRowNum();
        workbook.close();
        fileinput.close();
        return rowcount;

    }

    public static String getCellvalue(String FilePath, String SheetName, int rownum, int colnum) throws IOException {

        fileinput = new FileInputStream(FilePath);
        workbook = new XSSFWorkbook(fileinput);
        worksheet = workbook.getSheet(SheetName);
        row = worksheet.getRow(rownum);
        cell = row.getCell(colnum);
        DataFormatter formatter = new DataFormatter();
        String values = formatter.formatCellValue(cell);
        return values;
    }

    public static void click(String Xpath)

    /**
     * This is a demo doc string
     * @param Xpath
     * @return clicks the element
     */
    {
        driver.findElement(By.xpath(Xpath)).click();
    }


    public static void dropdown(String id,String text)
    {

        Select dropdown =new Select(driver.findElement(By.id(id)));
        dropdown.selectByVisibleText(text);
    }


    public static void quit()
    {
        driver.quit();
    }

    public static void close()
    {
        driver.close();
    }


    public static void launchUrl(String url){
        driver.get(url);
    }


    public static void sendKeys(String Xpath ,String data){

        driver.findElement(By.xpath(Xpath)).sendKeys(data);

    }


    public static void checkEnabled(String Xpath){

        if(driver.findElement(By.xpath(Xpath)).isEnabled())
        {
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }

    }




}
