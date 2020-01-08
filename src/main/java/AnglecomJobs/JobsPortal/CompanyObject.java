package AnglecomJobs.JobsPortal;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
 
import org.openqa.selenium.support.How;

public class CompanyObject	{
	
	
private String companyName;
private List<Job> jobDetails;

public CompanyObject(String companyName, List<Job> jobDetails)
{
	
	this.companyName = companyName;
	this.jobDetails = jobDetails;
	
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public List<Job> getJobDetails() {
	return jobDetails;
}
public void setJobDetails(List<Job> jobDetails) {
	this.jobDetails = jobDetails;
}

	
	
	

}
