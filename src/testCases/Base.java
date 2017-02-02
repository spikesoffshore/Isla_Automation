package testCases;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.basics.OS;
import org.sikuli.basics.Settings;
import org.sikuli.script.Env;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.TextRecognizer;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


//import com.aventstack.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.ExcelFunctions;
@SuppressWarnings("deprecation")
public class Base 
{
// Declaring member variables common among Test Classes	
	public String oSName;
	protected Robot robot;
	static String browserName;
	static String testUserName;
	static String isExtensionEnabled;
	static String serverName;
	public static String homedir;
	static String testPassword="Welcome@1";
	// Member variables for the Sikuli part
	public Screen screen=new Screen();
				
	Region reg,r,r1,reg_favicon;
	org.sikuli.script.Pattern pattern,pattern1,pattern2,pattern3;
	String mainTab,str,imgUrl;
	static String log4jConfigFile;
	//public static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExecutionReports\\IslaAutomationReport.html");
	//public static ExtentReports report = new ExtentReports(); 
	static String currentRunTimestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());;
	File currentRunTimestampedFolder;
	public static ExtentReports report=new ExtentReports(System.getProperty("user.dir")+"/ExecutionReports/CurrentRunReport/Isla AutomationReport.html",true);;
	
	int i;
	
	public static String patternpath;
	protected int flag=0;
	int key;
	public static String path;
	WebDriver driver;
	protected String baseurl;
	protected String siteURL;
	
	//Function to get the 'patternpath' for the Sikuli Patterns
			public static String patternpath(String pic){
				patternpath=path+pic;
				return patternpath;
			}
//Function to run before suite to instantiate reporting objects	

	
	/*public static void instantiateReport(){
		
		report = new ExtentReports("D:\\Framework\\Isla\\ExecutionReports\\automationreport.html", false);
	}*/
	
	//Function to invoke Chrome Driver with Isla Extension		
	public static WebDriver invokeChromeBrowserwithExtension(){
		
		 ChromeOptions options = new ChromeOptions();
		    options.addExtensions(new File("./Extensions/extension_1_0_10.crx"));

		    DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		    ChromeDriver driver = new ChromeDriver(capabilities);
		   
		    driver.manage().window().maximize();
		    org.sikuli.script.Screen screen=new org.sikuli.script.Screen();
		    Pattern p =new Pattern("/Extensions/Patterns/btnCancel.PNG");
		    Region r=screen.exists(p);
		    r.click();
		    	    
		    p=new Pattern("/Extensions/Patterns/IslaExtension.PNG");
		    r=screen.exists(p);
		    r.click();
		    
		    p=new Pattern("/Extensions/Patterns/IslaServerAddition.PNG");
		    r=screen.exists(p);
		    r.click();
		    try {
				r.type("https://"+getServer()+"/client.html"+Key.ENTER);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		    Sleep(2000);
		    return driver;
	}
	
	
	//Function to get the user directory
	public static String getHomeDirectory(){

    File f= new File(System.getProperty("user.dir"));
    do {
	        f = f.getParentFile();
	    } while (f.getParentFile() != null);
    return f.getPath();

      } 
//Function to get the Browser selected by the user for the current test execution
   public static String getBrowser() throws IOException{
	 
	browserName = ExcelFunctions.getSpecificCellValue(homedir+"Framework/CurrentTestRun.xlsx","Sheet1", 1, 3);
	return browserName;
    }
 //Function to get the Test User selected by the user for the current test execution
   public static String getTestUser() throws IOException{
	   
		//System.out.println(System.getProperty("homedir"));
		testUserName = ExcelFunctions.getSpecificCellValue(homedir+"Framework/CurrentTestRun.xlsx","Sheet1", 1, 5);
		return testUserName;
	    }
 //Function to get the Isla Server selected by the user for the current test execution
    public static String getServer() throws IOException{
	
	serverName = ExcelFunctions.getSpecificCellValue(homedir+"Framework/CurrentTestRun.xlsx","Sheet1", 1, 4);
	return serverName;
   }
    
  // Function to set the BaseURL for the current Isla server selected by the user for the current test execution
	public void setbaseURL(){
		if(isExtensionEnabled.equals("true")){
		baseurl="";
		}
		else{
	try{
		
			baseurl = "https://"+getServer()+"/client.html#";
		
	}catch(IOException e){
		
		e.printStackTrace();
	}
	}
		
	}
	
// Function to read Text from Pattern using Sikuli; to enable OCR 
	public void textRecognizition(){
		Settings.OcrTextRead=true;
		Settings.OcrTextSearch=true;
		//Settings.OcrLanguage=''
		TextRecognizer.reset();
	}
	
//Function to create new robot instance
	public void robotCreation(){
		try{
			robot=new Robot();
			
		}catch(Exception e){
			System.out.println("During robot "+e);
		}
	}

	//Function to get the OS Name
	public String getOSName(){
		
		return System.getProperty("os.name");
	}
//Function to check the OS for current test execution
	public void OScheck(){
				
		try{
			OS Os=Env.getOS();
			//System.out.println(Os);
			Keyset(Os);	
			oSName = Os.toString();
		}catch(IOException e){
			//System.out.println(e);					
		}
			
	}


//Function to set the 'path' for the OS and enable the KeyCombination as OS specific 
	public void Keyset(OS os) throws IOException{
		switch (os){
		case WINDOWS:
					
			flag=0;
			path=path+"/Win";
			break;
			
		case LINUX:
			flag=0;
			path=path+"/Linux";
			break;
			
		case MAC:
			flag=1;
			path=path+"/Mac";
			break;

		default:
			System.out.println(OS.values()+" not supported");
			break;
		}
	}

//Function to get the 'path' of the current User Directory 
	public void pathSet(){
		path=System.getProperty("user.dir");
		
	}	
	
	
	//Function to set isExtensionEnabled true
	public static void isExtensionEnabled(){
		
		try {
			
			{isExtensionEnabled=(ExcelFunctions.getSpecificCellValue(homedir+"Framework/CurrentTestRun.xlsx","Sheet1", 1, 6));
			
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

//Function to instantiate the WebDriver instance based on the Browser selected for Windows
	public WebDriver driverInsWindows(){
		isExtensionEnabled();
		setbaseURL();
		
		
		try {
			switch(getBrowser()+isExtensionEnabled.toString()){
				case "Chromefalse":
					System.setProperty("webdriver.chrome.driver", "./Win/Drivers/chromedriver.exe");
					
					driver=new ChromeDriver();
					driver.get(baseurl);
					break;
					
				case "Chrometrue":
					
					System.setProperty("webdriver.chrome.driver", "./Win/Drivers/chromedriver.exe");
					driver=invokeChromeBrowserwithExtension();
					
					driver.get("https://www.google.com");
					break;
			
				case "Internet Explorer":
					System.setProperty("webdriver.internetexplorer.driver", "./Win/Drivers/internetexplorerdriver.exe");
					driver=new InternetExplorerDriver();
					driver.get(baseurl);
				break;
				case "Firefox":
					driver=new FirefoxDriver();
					driver.get(baseurl);
					break;
					default:
						//new PascalBaseClass();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//driver.get(baseurl);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().window().maximize();
		Sleep(2000);
		driver.manage().window().setSize(new Dimension(1366,460));
		Sleep(2000);
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().window().maximize();
		
		return driver;
	}

//Function to instantiate the WebDriver instance based on the Browser selected for Linux
	public WebDriver driverInsLinux(){
		setbaseURL();
		
		try {
			switch(getBrowser()){
				case "Chrome":
					System.setProperty("webdriver.chrome.driver", "./Linux/Drivers/chromedriverLinux");
					driver=new ChromeDriver();
					break;
					
				case "ChromeWithExtension":
					System.setProperty("webdriver.chrome.driver", "./Linux/Drivers/chromedriverLinux");
					driver=invokeChromeBrowserwithExtension();
					break;
			
				case "Internet Explorer":
					System.setProperty("webdriver.internetexplorer.driver", "./Linux/Drivers/internetexplorerdriver.exe");
					driver=new InternetExplorerDriver();
					break;
				case "Firefox":
					driver=new FirefoxDriver();
					break;
					default:
						//new PascalBaseClass();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		driver.get(baseurl);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().window().maximize();
		return driver;
	}
	
//Function to instantiate the WebDriver instance based on the Browser selected for Mac
	public WebDriver driverInsMac(){
		setbaseURL();
		
		try {
			switch(getBrowser()){
				case "Chrome":
					System.setProperty("webdriver.chrome.driver", "./Mac/Drivers/chromedriver");
					driver=new ChromeDriver();
					driver.manage().deleteAllCookies();
					break;
					
				case "ChromeWithExtension":
					System.setProperty("webdriver.chrome.driver", "./Mac/Drivers/chromedriver");
					driver=invokeChromeBrowserwithExtension();
					break;
			
				case "Internet Explorer":
					System.setProperty("webdriver.internetexplorer.driver", "./Mac/Drivers/internetexplorerdriver.exe");
					driver=new InternetExplorerDriver();
					driver.manage().deleteAllCookies();
					break;
				
				case "Firefox":
					driver=new FirefoxDriver();
					driver.manage().deleteAllCookies();
					break;
					
					default:
						//new PascalBaseClass();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		driver.get(baseurl);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().window().maximize();
		return driver;
	}
	
//Function to Login onto the Isla Server
	public void spikeLogin(){
		// enter Username
		driver.findElement(By.xpath("//input[@class='signinUsernameText']")).sendKeys(testUserName);//+"@spikes.com");
			
		//enter password
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Welcome@1");
										
		//click sign in
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
//Function to hold on the current thread execution for the time provided(in milliseconds)
	public static void Sleep(int time){
		try{
			System.out.println("sleeping time");
			Thread.sleep(time);
		}catch(Exception e){System.out.println(e);
			
		}
	}


	
// Function to quit the WebDriver instance
	public void quitDriver(WebDriver driver){
		driver.quit();
	}

//Function to instantiate the WebDriver based on the OS
	public WebDriver driverIns(){
		
		switch (oSName) {
			
		case "WINDOWS": driver =driverInsWindows();
			break;
		case "LINUX" : driver =driverInsLinux();
			break;
		case "MAC" : driver =driverInsMac();
			break;
			
		}
		return driver;
			
	}
		
//Base Class Constructor:
	public Base()  {
		
		
		homedir = getHomeDirectory();
		try {
			getTestUser();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}		
		textRecognizition();
		robotCreation();
		//instantiateReport();
		try {
			getServer();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Settings.WaitScanRate=5;
		screen.setAutoWaitTimeout(20);
		
		pathSet();
		OScheck();	
		/*try {
			report.setSystemInfo("Browser", ExcelFunctions.getSpecificCellValue(homedir+"Framework/CurrentTestRun.xlsx",0, 1, 3));
			report.setSystemInfo("TestServer", ExcelFunctions.getSpecificCellValue(homedir+"Framework/CurrentTestRun.xlsx",0, 1, 4));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}*/
		/*htmlReporter.config().setDocumentTitle("Isla Test Execution Report");
		htmlReporter.config().setReportName("Isla Automation Report");
		htmlReporter.config().setCSS("main.css");
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", getOSName());*/
		}		
	@BeforeSuite
	public void beforeSuite(){
		try {
			getTestUser();
		} catch (IOException e2) {
				e2.printStackTrace();
		}
		log4jConfigFile = System.getProperty("user.dir")
	            + File.separator + "log4j.properties";
		
		PropertyConfigurator.configure(log4jConfigFile);
			
		currentRunTimestampedFolder = new File(System.getProperty("user.dir")+"/ExecutionReports/OlderRuns/Report_"+currentRunTimestamp);
		currentRunTimestampedFolder.mkdir();
		File currentRunReportFolder= new File(System.getProperty("user.dir")+"/ExecutionReports/CurrentRunReport");
		try {
			FileUtils.cleanDirectory(currentRunReportFolder);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		/*report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("OS", "Windows 10");*/
		
		try {
			report.addSystemInfo("TestServerName",getServer());
			report.addSystemInfo("Browser", getBrowser());
			report.addSystemInfo("RAC_Info", "AIRGAP");
			report.addSystemInfo("Browser_Info", "BROWSERWA");
			
		} catch (IOException e) {
				e.printStackTrace();
		}
	
	}
	@AfterSuite
	public void afterSuite() {
		reportingAirgapAndChromeInfo();
        
        try {
            
            //String existingReportText = Files.readFile(new File(System.getProperty("user.dir")+"/ExecutionReports/CurrentRunReport/*.html"));
            String existingReportText= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"/ExecutionReports/CurrentRunReport/Isla AutomationReport.html"));
            
            //existingReportText.replace("AIRGAP", "<img src=/ExecutionReports/CurrentRunReport/AirGapInfo.PNG"+"/>");
            String myNewReport=existingReportText.replace("AIRGAP", "<a href=./AirGapInfo.PNG"+">"+"<img border=\"0\" src=./AirGapInfo.PNG"+" width=\"100\" height=\"50\"</a>");
            String myAgainNewReport=  myNewReport.replace("BROWSERWA", "<a href=./BrowserInfo.PNG"+">"+"<img border=\"0\" src=./BrowserInfo.PNG"+" width=\"100\" height=\"50\"</a>");
                      
            //Files.writeFile(existingReportText, new File(System.getProperty("user.dir")+"/ExecutionReports/CurrentRunReport/IslaAutomationReport.html"));
            FileUtils.writeStringToFile(new File(System.getProperty("user.dir")+"/ExecutionReports/CurrentRunReport/Isla AutomationReport.html"), myAgainNewReport);
           
            
        } catch (IOException e1) {
           
            e1.printStackTrace();
        }
		File currentRunFolder = new File(System.getProperty("user.dir")+"/ExecutionReports/CurrentRunReport");
		try {
			FileUtils.copyDirectory(currentRunFolder, currentRunTimestampedFolder);
			String myCurrentOldReport = FileUtils.readFileToString(new File((currentRunTimestampedFolder).getPath()+"/Isla AutomationReport.html"));
            String mynewOldReport = myCurrentOldReport.replaceAll("CurrentRunReport", "OlderRuns/Report_"+currentRunTimestamp);
            FileUtils.writeStringToFile(new File(System.getProperty("user.dir")+"/ExecutionReports/OlderRuns/Report_"+currentRunTimestamp+"/Isla AutomationReport.html"), mynewOldReport);

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
public void reportingAirgapAndChromeInfo(){
        
		
    //    System.setProperty("webdriver.chrome.driver",path+"/Drivers/chromedriver.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
       
        //driver.get("https://"+getServer()+".spikes.eng//client.html#airgap://about");
		try {
			driver.get("https://"+getServer()+"//client.html#airgap://about");
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
       
		Sleep(5000);
        spikeLogin();
       
        Sleep(10000);
        Pattern airgapInfoLink = new Pattern(path+"/AirgapAndChrome/airgapInfoLink.PNG");
        r = screen.exists(airgapInfoLink);
        r.highlight(2);
        r.click();
        screen.wheel(1, 10);            
        Sleep(4000);
        
        File airgapInfoImage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(airgapInfoImage, new File("./ExecutionReports/CurrentRunReport/AirGapInfo.PNG"));
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        driver.navigate().to("chrome://version/");
        Sleep(2000);
        File browserInfoImage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            org.apache.commons.io.FileUtils.copyFile(browserInfoImage, new File("./ExecutionReports/CurrentRunReport/BrowserInfo.PNG"));
        } catch (IOException e) {
            
            e.printStackTrace();
        }Sleep(2000);
        driver.quit();
    }
}