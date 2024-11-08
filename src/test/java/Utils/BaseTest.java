package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObject.loginPagePageObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public Properties prop;
	public static Logger log = LogManager.getLogger(BaseTest.class);

	@BeforeClass
	public void ConfigureAppium() throws InterruptedException, IOException {

		// Load Properties File
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\Resources\\data.properties");
		prop.load(fis);

		// Load log4j.properties file
		PropertyConfigurator
				.configure(System.getProperty("user.dir") + "\\src\\test\\java\\Resources\\log4j.properties");

		// Start Appium Server
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\mitangi.patel\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(prop.getProperty("ipAddress")).usingPort(Integer.parseInt(prop.getProperty("Port")))
				.withLogFile(new File("AppiumLog.txt")).withTimeout(Duration.ofSeconds(50)).build();

		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\Resources\\SauceLabs.apk");
		options.setAppActivity("com.swaglabsmobileapp.MainActivity");

		driver = new AndroidDriver(service.getUrl(), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void tearDown() {
		// Close Appium Server
		driver.quit();
		service.stop();
	}

	public void appLogin() throws InterruptedException {
		loginPagePageObject loginpage = new loginPagePageObject(driver);
		loginpage.enterUsername(prop.getProperty("Username"));
		loginpage.enterPassword(prop.getProperty("Password"));
		loginpage.clickLoginButton();
	}

	// Get Data From Json File
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenshotPath(String testCaseName, AndroidDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
