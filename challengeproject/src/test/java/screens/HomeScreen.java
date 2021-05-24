package screens;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen
{
	//Declare driver object
	public AndroidDriver driver;

	//Element Locators
	@AndroidFindBy(xpath="//*[@resource-id='com.example.challenge:id/productImage']")
	public MobileElement prodimg;
	
	//Constructor Method
	public HomeScreen(AndroidDriver driver)
	{
		this.driver=driver;
		AppiumFieldDecorator ad=new AppiumFieldDecorator(driver);
		PageFactory.initElements(ad,this);
	}
}
