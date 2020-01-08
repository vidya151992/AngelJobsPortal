package AnglecomJobs.JobsPortal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyImplementor {
	/*@FindBy(how = How.XPATH , using = "//div[@class='jobList_9cc29']/div/div/a/div[1]/h6")
	public  List<WebElement> jobType;
	
	@FindBy(how = How.TAG_NAME , using = "h4")
	public  List<WebElement> jobTitle;
	
	@FindBy(how = How.XPATH , using = "//div[@class='jobList_9cc29']/div/div/div[1]/div/div/span")
	public  List<WebElement> jobLocation;*/
	
	private  String xpathOfCompanyNames = "//a[contains(text(),'companyName')]";
	private  List<Job> jobList = new ArrayList<Job>();
	
	
	
	public  CompanyObject searchForCompanyNameandClick(WebDriver driver , String company) throws InterruptedException
	
	{ 
		//PageFactory.initElements(driver, CompanyImplementor.class);
		WebDriverWait wait = new WebDriverWait(driver,10);
		String xpathAddingCompany = xpathOfCompanyNames.replaceAll("companyName", company);
		Thread.sleep(10000);
		String mainwindow = driver.getWindowHandle();
		//Set<String> tabs = driver.getWindowHandles();
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpathAddingCompany))));
		driver.findElement(By.xpath(xpathAddingCompany)).click();
		System.out.println("Company name is clicked" + company);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ArrayList<String> availableWindows = new 
				ArrayList<String>(driver.getWindowHandles()); 
		if (!availableWindows.isEmpty()) { 
			driver.switchTo().window(availableWindows.get(availableWindows.size()-1)); 
			}
		
		//driver.switchTo().window()
		List<WebElement> jobType = driver.findElements(By.xpath("//div[@class='jobList_9cc29']/div/div/a/div[1]/h6"));
		List<WebElement> jobTitle = driver.findElements(By.tagName("h4"));
		List<WebElement> jobLocation = driver.findElements(By.xpath("//div[@class='jobList_9cc29']/div/div/div[1]/div/div/span"));
		for(int i = 0 ; i<jobType.size(); i++)
		{
			String jType = jobType.get(i).getText();
			String jTitle = jobTitle.get(i).getText();
			String jLocation = jobLocation.get(i).getText();
			System.out.println("Job type = " +jType + "Job title = " + jTitle + "Job location = " +jLocation);
			Job job = new Job(jType,jTitle,jLocation);
			jobList.add(job);
			
		
		}
		driver.switchTo().window(mainwindow);
		CompanyObject companyObject = new CompanyObject(company, jobList);
		return companyObject;
		
	}
	
	/*public   void jobDetails()
	{
		for(int i = 0 ; i<jobType.size(); i++)
		{
			String jType = jobType.get(i).getText();
			String jTitle = jobTitle.get(i).getText();
			String jLocation = jobLocation.get(i).getText();
			Job job = new Job(jType,jTitle,jLocation);
			jobList.add(job);
			
		
		}
		
		
	}*/

}
