import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join

import com.kms.katalon.core.testdata.CSVData
import com.kms.katalon.core.testdata.InternalData
import com.kms.katalon.core.logging.KeywordLogger


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.String


WebUI.openBrowser('')

CSVData data = findTestData("Plans")

def driver = DriverFactory.getWebDriver()

String baseUrl = baseURL

selenium = new WebDriverBackedSelenium(driver, baseUrl)

for (def index : (0..data.getRowNumbers() -1)) {

selenium.open(startURL)


//selenium.type('name=data[0][Practice][zip_code]', '11030')
//selenium.type('name=data[0][Practice][zip_code]', data.internallyGetValue("issuer", index))
selenium.click("id=0PracticeProviderPndsid")
selenium.select("id=0PracticeProviderPndsid", "label=" + data.internallyGetValue("issuer", index))

selenium.click('//button[@type=\'submit\']')
 

//WebUI.verifyTextPresent(data.internallyGetValue("Results", index), false)
//WebUI.verifyElementPresent(findTestObject("//span[@id = 'recordCount']"), 7)
//attribute = WebUI.getAttribute(findTestObject('//*[@id="recordCount"]'), 'id')
result = WebUI.getText(findTestObject('Page_PNDS/recordCount'))

KeywordLogger log = new KeywordLogger()
log.logInfo('Results: '+ data.internallyGetValue("issuer", index) + "," + result)

}

/*
FileInputStream file = new FileInputStream (new File("row_count_3_15_18.xlsx"))
XSSFWorkbook workbook = new XSSFWorkbook(file);
XSSFSheet sheet = workbook.getSheetAt(0);

'Read data from excel'
String Data_fromCell=sheet.getRow(1).getCell(1).getStringCellValue();
'Write data to excel'
sheet.getRow(1).createCell(1).setCellValue("Mahesh2");

file.close();
FileOutputStream outFile =new FileOutputStream(new File("row_count_3_15_18.xlsx"));
workbook.write(outFile);
*/

WebUI.closeBrowser()

