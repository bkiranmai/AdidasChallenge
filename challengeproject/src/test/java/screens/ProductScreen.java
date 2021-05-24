package screens;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductScreen 
{
	//Declare driver object
	public AndroidDriver driver;
	
	//Element Locators
	@AndroidFindBy(xpath="//*[@resource-id='com.example.challenge:id/productName']")
	public MobileElement prodname;
	
	@AndroidFindBy(xpath="//*[@resource-id='com.example.challenge:id/productPrice']")
	public MobileElement prodprice;
	
	@AndroidFindBy(xpath="//*[@resource-id='com.example.challenge:id/reviewsRecycler']")
	public MobileElement reviews;
	
	//Constructor Method
	public ProductScreen(AndroidDriver driver)
	{
		this.driver=driver;
		AppiumFieldDecorator ad=new AppiumFieldDecorator(driver);
		PageFactory.initElements(ad,this);
	}
}
