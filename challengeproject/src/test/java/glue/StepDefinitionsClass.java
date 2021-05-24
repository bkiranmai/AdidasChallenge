package glue;

import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.HomeScreen;
import screens.ProductScreen;

public class StepDefinitionsClass
{
	public AndroidDriver driver;
	public HomeScreen hs;
	public ProductScreen ps;
	public Scenario s;
	public Properties p;
	public WebDriverWait wait;
	public URL u;
	DesiredCapabilities dc;
	
	@Before
	public void beforeMethod(Scenario s) throws Exception
	{
		this.s=s;
		FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		p=new Properties();
		p.load(fi);
		
		//Start appium server programmatically
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		
		//Get appium server address
		u=new URL("http://0.0.0.0:4723/wd/hub");
	}
	
	@Given("^launch challenge app$")
	public void launchApplication() throws Exception
	{
		//Details of app and device
		dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("platformName",p.getProperty("platformName"));
		dc.setCapability("platformVersion",p.getProperty("platformVersion"));
		dc.setCapability("deviceName",p.getProperty("deviceName"));
		dc.setCapability("appPackage",p.getProperty("appPackage"));
		dc.setCapability("appActivity",p.getProperty("appActivity"));
		
		//Create driver object
		while(true)
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception ex)
			{
			}
		}
		
		//Create Screen class objects
		hs=new HomeScreen(driver);
		ps=new ProductScreen(driver);
		
		//Create wait object
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(hs.prodimg));
	}
	
	@Then("^verify products name and price of each product$")
	public void productDetailsValidation()
	{
		try
		{
			int seh=0;
			for(int j=0;j<17;j++)
			{
				List<MobileElement> l=driver.findElements(By.xpath("//*[@class='androidx.recyclerview.widget.RecyclerView']/child::*"));
				System.out.println(l.size());
				if(j==0)
				{
					for(int i=0;i<l.size();i++)
					{
						List<MobileElement> l1=driver.findElements(By.xpath("//*[@class='androidx.recyclerview.widget.RecyclerView']/child::*"));
						seh=l1.get(0).getRect().getHeight();
						String pronamehs=driver.findElement(By.xpath("//*[@class='androidx.recyclerview.widget.RecyclerView']/child::*["+(i+1)+"]/child::*[2]")).getText();
						String propricehs=driver.findElement(By.xpath("//*[@class='androidx.recyclerview.widget.RecyclerView']/child::*["+(i+1)+"]/child::*[3]")).getText();
						l1.get(i).click();
						wait.until(ExpectedConditions.visibilityOf(ps.reviews));
						String pronameps=(ps.prodname).getText();
						String propriceps=(ps.prodprice).getText();
						if(pronamehs.equals(pronameps))
						{
							s.write("Product name test passed for "+pronamehs);
						}
						else
						{
							byte[] b=driver.getScreenshotAs(OutputType.BYTES);
							s.embed(b,"Product name test failed for "+pronamehs);
							Assert.assertTrue(false);
						}
						if(propricehs.equals(propriceps))
						{
							s.write("Product price test passed for "+pronamehs);
						}
						else
						{
							byte[] b=driver.getScreenshotAs(OutputType.BYTES);
							s.embed(b,"Product price test failed for "+pronamehs);
							Assert.assertTrue(false);
						}
						
						KeyEvent k1=new KeyEvent(AndroidKey.BACK);
						driver.pressKey(k1);
						wait.until(ExpectedConditions.visibilityOf(hs.prodimg));
					}
					
					//Swipe
					TouchAction ta=new TouchAction(driver);
					WaitOptions wo=new WaitOptions();
					wo.withDuration(Duration.ofMillis(5000));
					int w=driver.manage().window().getSize().getWidth();
					int h=driver.manage().window().getSize().getHeight();
					int x1=w/2;
					int y1=(int) (h*0.9);
					int x2=w/2;
					int y2=y1-seh-30;
					ta.press(ElementOption.point(x1,y1)).waitAction(wo).moveTo(ElementOption.point(x2,y2)).release().perform();
				}
				else
				{
					for(int i=2;i<3;i++)
					{
						List<MobileElement> l1=driver.findElements(By.xpath("//*[@class='androidx.recyclerview.widget.RecyclerView']/child::*"));
						seh=l1.get(0).getRect().getHeight();
						String pronamehs=driver.findElement(By.xpath("//*[@class='androidx.recyclerview.widget.RecyclerView']/child::*["+(i+1)+"]/child::*[2]")).getText();
						String propricehs=driver.findElement(By.xpath("//*[@class='androidx.recyclerview.widget.RecyclerView']/child::*["+(i+1)+"]/child::*[3]")).getText();
						l1.get(i).click();
						wait.until(ExpectedConditions.visibilityOf(ps.reviews));
						String pronameps=(ps.prodname).getText();
						String propriceps=(ps.prodprice).getText();
						if(pronamehs.equals(pronameps))
						{
							s.write("Product name test passed for "+pronamehs);
						}
						else
						{
							byte[] b=driver.getScreenshotAs(OutputType.BYTES);
							s.embed(b,"Product name test failed for "+pronamehs);
							Assert.assertTrue(false);
						}
						if(propricehs.equals(propriceps))
						{
							s.write("Product price test passed for "+pronamehs);
						}
						else
						{
							byte[] b=driver.getScreenshotAs(OutputType.BYTES);
							s.embed(b,"Product price test failed for "+pronamehs);
							Assert.assertTrue(false);
						}
						
						KeyEvent k1=new KeyEvent(AndroidKey.BACK);
						driver.pressKey(k1);
						wait.until(ExpectedConditions.visibilityOf(hs.prodimg));
					}
					
					//Swipe
					TouchAction ta=new TouchAction(driver);
					WaitOptions wo=new WaitOptions();
					wo.withDuration(Duration.ofMillis(5000));
					int w=driver.manage().window().getSize().getWidth();
					int h=driver.manage().window().getSize().getHeight();
					int x1=w/2;
					int y1=(int) (h*0.9);
					int x2=w/2;
					int y2=y1-seh-30;
					ta.press(ElementOption.point(x1,y1)).waitAction(wo).moveTo(ElementOption.point(x2,y2)).release().perform();
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	@When("^close app$")
	public void closeApplication()
	{
		//Close app
		driver.closeApp();
	}
	
	@After
	public void stopAppiumServer() throws Exception
	{
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
