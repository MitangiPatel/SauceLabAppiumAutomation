package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public Properties prop;

	@BeforeClass
	public void ConfigureAppium() throws IOException, URISyntaxException  {

		// Load Properties File
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\Resources\\data.properties");
		prop.load(fis);

		// Start Appium Server
		service = new AppiumServiceBuilder().withAppiumJS(new File(prop.getProperty("AppiumMainJSPath")))
				.withIPAddress(prop.getProperty("ipAddress")).usingPort(Integer.parseInt(prop.getProperty("Port")))
				.withLogFile(new File("AppiumLog.txt")).withTimeout(Duration.ofSeconds(50)).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setAutoGrantPermissions(true);
		options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\Resources\\AltaVideoapp.apk");

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void tearDown() {
		// Close Appium Server
		driver.quit();
		// Stop Server
		service.stop();
	}

	public String getScreenshotPath(String testCaseName, AndroidDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
