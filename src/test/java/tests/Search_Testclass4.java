package tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.keyword;

public class Search_Testclass4 extends BaseTest{



	
	keyword kw;

	@BeforeClass
	public void beforeClass() {
		kw = new keyword(driver);
	}

//	1. Use navigation, to search for mobile such as mi mobile
	@Test
	public void a_search_mimobile()
	{
		kw.Amazon_searchbox();
		
	}

//	2. Validate the results, for instance, 1-16 of 264 results for mi mobile
	@Test(dependsOnMethods={"a_search_mimobile"})
	public void b_search_results()
	{
		kw.search_result();
	}
	
//3. Select Avg. Customer Review as 4 stars & up
	@Test(dependsOnMethods={"b_search_results"})
	public void c_customer_review()
	{
		kw.Average4starrating();
	}
	
//Select the first mobile, and in this case, Redmi Note 8 (Moonlight White, 6GB RAM, 128GB Storage)	
	@Test(dependsOnMethods={"c_customer_review"})
	public void d_first_Mobile()
	{
		kw.selectmobile();

		
	}
//Validate the change in the title, whether it is relevant to the selected mobile
	@Test(dependsOnMethods = {"d_first_Mobile"})
	public void e_validate_Mobile()
	{
		try {
			kw.SwitchTabs();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("switched to different iframe to validate the mobile title");
		String actual = kw.getCurrentPageTitle();
		Reporter.log("current page title is "+actual);
		 
	}
//Get the mobile price and validate it
	@Test(dependsOnMethods = {"e_validate_Mobile"})
	public void f_validate_Mobile_Price()
	{
		kw.mobilePrice();
	}
	@Test(dependsOnMethods = {"f_validate_Mobile_Price"})
	public void g_validate_Delivery_Location()
	{
		kw.DeliveryLocation();
		Reporter.log("Delivery location selected successfully");
		//popup enter text("//*[@id='GLUXZipUpdateInput']")
	}
	
}
