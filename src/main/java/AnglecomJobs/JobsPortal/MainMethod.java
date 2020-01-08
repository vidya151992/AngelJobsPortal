package AnglecomJobs.JobsPortal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class MainMethod {
	private static WebDriver driver;

	 public static void main(String args[]) throws IOException, InterruptedException
	 {
		 
		CompanyImplementor companyImplementor = new CompanyImplementor(); 
		List<CompanyObject> companyList = new ArrayList<CompanyObject>();
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://angel.co/jobs");
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//List<String> companyname = ExcelUtils.getData(System.getProperty("user.dir")+"\\src\\CompanyNames.xlsx", "company");
	List<WebElement> companyNameElement = driver.findElements(By.xpath("//div[@class='startups']/div/div/div[2]/strong/a"));
	List<String> companyname = new ArrayList<String>();
	for(int i = 0; i<companyNameElement.size(); i++)
	{
		companyname.add(companyNameElement.get(i).getText());
	}
	for(String company : companyname)
	{
		System.out.println("company name = " +company);
		CompanyObject companyWithJobDetails = companyImplementor.searchForCompanyNameandClick(driver , company);
		
		companyList.add(companyWithJobDetails);
		//System.out.println("company job details = " +companyWithJobDetails);
		
		
	}
	ExcelUtils.writeResultHeader(System.getProperty("user.dir")+"\\Companyjobresults.xlsx");
	
	for(CompanyObject company : companyList)
	{
		String companyName = company.getCompanyName();
		
		List<Job> jobdetailsList = company.getJobDetails();
		for(Job jobdetails : jobdetailsList)
		{
			String jobType = jobdetails.getJobType();
			String jobTitle = jobdetails.getJobTitle();
			String jobLocation = jobdetails.getJobLocation();
			System.out.println(companyName + jobType + jobTitle + jobLocation);
			ExcelUtils.writeTestResult(System.getProperty("user.dir")+"\\src\\Companyjobresults.xlsx", 
					companyName, jobType, jobTitle, jobLocation);
		}
		
		
	}
	driver.quit();

}
}