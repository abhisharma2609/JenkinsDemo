package step_definitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BrowserStackAndroid {

	public static String userName = "praveenqa1";
	public static String accessKey = "kSNuvtpRs4dxaj7vy6eT";

	public static void main(String args[]) throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("device", "Google Pixel 3");
		caps.setCapability("os_version", "9.0");
		caps.setCapability("project", "My First Project");
		caps.setCapability("build", "My First Build");
		caps.setCapability("name", "Bstack-[Java] Sample Test");
		caps.setCapability("app", "bs://01d7d3257930afb9465d4a6965365e2cc52d8bab");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);
		AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
		searchElement.click();
		AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
		insertTextElement.sendKeys("BrowserStack");
		Thread.sleep(5000);
		List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
		assert (allProductsName.size() > 0);
		driver.quit();
	}
}