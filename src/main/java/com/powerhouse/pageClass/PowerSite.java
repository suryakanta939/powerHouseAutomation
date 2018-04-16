package com.powerhouse.pageClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.powerhouse.commonClass.SelectFunctions;
import com.powerhouse.commonClass.Waiting;
import com.powerhouse.propertyClass.Property;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PowerSite {
	WebElement element;
	static ExtentTest test;
	static WebDriver driver; 
	boolean flag;
	boolean siteCreated;
	String xpath1="//h3[text()='";
	String xpath2="']";
	String siteNamexpath1="//td[p[text()='";
	String siteNamexpath2="']]//a[text()='Delete']";
	Admin_MySites adminmysite;
	@FindBy(xpath="//a[@id='user-powersites']")
	WebElement powersite;

	@FindBy(xpath="//p[contains(text(),' 0 PowerSites subscription')]")
	WebElement powersiteMessage;

	@FindBy(xpath="//span[text()='Create PowerSite']")
	WebElement createPowerSiteButton;

	@FindBy(xpath="//div[contains(text(),'currently have an available PowerSites Subscription')]")
	WebElement createPowerSiteMessage;

	@FindBy(xpath="//a[text()='click here']")
	WebElement clickHereLink;

	@FindBy(xpath="//h1[text()='Create Site']")
	public WebElement createSitePage;

	@FindBy(xpath="//input[@value='domain']")
	public static WebElement siteTypeDomain;

	@FindBy(id="domain")
	WebElement selectDomain;

	@FindBy(xpath="//input[@value='subdomain']")
	WebElement siteTypeSubDomain;

	@FindBy(id="site_name")
	WebElement siteNameEditBox;

	@FindBy(id="blog_template")
	WebElement selectTemplate;

	@FindBy(id="add_network")
	WebElement createSiteButon;


	@FindBy(id="site-address")
	WebElement subDomainEditBox;


	@FindBy(xpath="//p[contains(text(),'manage your site')]")
	WebElement createSiteSucessFullMessage;

	@FindBy(xpath="//a[text()='CLICK HERE']")
	WebElement clickHereLinkToSeeSite;


	@FindBy(xpath="//a[text()='Delete']")
	WebElement delete;

	@FindBy(id="delete_network")
	WebElement deleteNetWork;


	public WebElement siteNameForDomain() throws IOException{
		String domainSiteName=Property.readPropertyData("powersite", "siteNameForDomain");
		element=driver.findElement(By.xpath(xpath1+domainSiteName+xpath2));
		return element;
	}

	public WebElement siteNameForSubDomain() throws IOException{
		String subdomainSiteName=Property.readPropertyData("powersite", "siteNameForSubdomain");
		element=driver.findElement(By.xpath(xpath1+subdomainSiteName+xpath2));
		return element;
	}

	public WebElement siteToBeDeleted() throws IOException{
		String powerSiteName=Property.readPropertyData("powersite", "powersiteNameToBeDeleted");
		element=driver.findElement(By.xpath(siteNamexpath1+powerSiteName+siteNamexpath2));
		return element;
	}
	//	@FindBy(xpath="//a[text()='Add To Cart' and @data-product_id='143']")
	//	WebElement bronzeAddToCart;
	//
	//	@FindBy(xpath="//a[text()='Add To Cart' and @data-product_id='145']")
	//	WebElement silverAddToCart;
	//
	//	@FindBy(xpath="//a[text()='Add To Cart' and @data-product_id='146']")
	//	WebElement goldAddToCart;
	//
	//	@FindBy(xpath="//a[text()='Add To Cart' and @data-product_id='147']")
	//	WebElement platinumAddToCart;


	public PowerSite(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		adminmysite=new Admin_MySites(driver, test);
		PageFactory.initElements(driver, this);
	}

	public void clickOnPowerSite(){

		powersite.sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "clicked on the powersite");
	}

	public boolean readingThe0NoPowerSiteCreationMessage(){
		String message=powersiteMessage.getText();
		if(message.equals("You have 0 PowerSites subscription(s) ready to be created.")){
			System.out.println("The message is equals to the expected message");
			flag=true;
		}else{
			System.out.println("the different message is "+message);
			flag=false;
		}

		test.log(LogStatus.INFO, "read the message");
		return flag;

	}

	public void clickOnTheCreatePowerSite(){
		createPowerSiteButton.click();
		test.log(LogStatus.INFO, "clicked on the powersite button");
	}


	public void readCreatePowerSiteMessage(){
		if(readingThe0NoPowerSiteCreationMessage()==true){
			String message=createPowerSiteMessage.getText();
			System.out.println(message);
			test.log(LogStatus.INFO, "reading the create powersite message");
			clickHereLink.click();
			test.log(LogStatus.INFO, "cliked on the click here link");
		}else{
			System.out.println("there is no such message is displaying");
		}
	}

	/**
	 * This function is all about the powersite creation
	 * from the initial 
	 * @param:-New user, No powersite subscription
	 * 
	 * */

	public void powerSitefunctionInitial(){
		clickOnPowerSite();
		readingThe0NoPowerSiteCreationMessage();
		clickOnTheCreatePowerSite();
		readCreatePowerSiteMessage();
	}
	/**
	 * bellow are the elements to create the powersite
	 * 
	 * */

	public void clickOnDomain(){
		siteTypeDomain.click();
		test.log(LogStatus.INFO, "clciked on the domain ");
	}
	public void selectOneDomain(String domain){
		SelectFunctions.selectByText(selectDomain,domain);
		test.log(LogStatus.INFO, "sected one domain");
	}

	public void enterTheSiteName(String yourSiteName){
		siteNameEditBox.sendKeys(yourSiteName);
		test.log(LogStatus.INFO, "typed the site name");
	}

	public void clickOntheCreateSite(){
		createSiteButon.click();
		test.log(LogStatus.INFO, "clicked on the create site button");
	}
	/**
	 * This function is to create power site by domain
	 * @param:-multiple site creation message
	 * @throws IOException 
	 * @throws InterruptedException 
	 * */	

	public void createPowerSiteByDomain() throws IOException, InterruptedException{
		clickOnDomain();
		String domain=Property.readPropertyData("powersite", "domain");
		try{
			selectOneDomain(domain);
			String sitename=Property.readPropertyData("powersite", "siteNameForDomain");
			enterTheSiteName(sitename);
			clickOntheCreateSite();
		}
		catch(Throwable t){
			System.out.println("Delete the site created by the domain powersites.social");
			adminmysite.deleteSite();
			driver.navigate().refresh();
			clickOnDomain();
			String domain1=Property.readPropertyData("powersite", "domain");
			selectOneDomain(domain1);
			String sitename=Property.readPropertyData("powersite", "siteNameForDomain");
			enterTheSiteName(sitename);
			clickOntheCreateSite();
		}

	}
	/**
	 * bellow are the elements for the sub domain
	 * 
	 * */  
	public void clickOnSubDmoain(){
		siteTypeSubDomain.click();
		test.log(LogStatus.INFO, "clicked on the subdomain");
	}

	public void eneterTheSubDomainName(String yourSubDomain){
		subDomainEditBox.sendKeys(yourSubDomain);
		test.log(LogStatus.INFO, "Entered the sub domain name");
	}
	/**
	 * This function is to crate site by sub domain
	 * @throws IOException 
	 * 
	 * */  
	public void createPowerSiteBySubDomain() throws IOException{
		clickOnSubDmoain();
		String Subdomain=Property.readPropertyData("powersite", "subDomainName");
		eneterTheSubDomainName(Subdomain);
		String sitename=Property.readPropertyData("powersite", "siteNameForSubdomain");
		enterTheSiteName(sitename);
		clickOntheCreateSite();
	}

	/**
	 * this function is to check the site is created or not
	 * 
	 * */  

	public boolean isSiteCreatedByDomain(){
		while(true){
			try{

				Waiting.waitForTheVisibilty(driver, createSiteSucessFullMessage, 10);
				clickHereLinkToSeeSite.click();
				Waiting.waitForTheVisibilty(driver, siteNameForDomain(), 10);
				String name=siteNameForDomain().getText();
				String domainSiteName=Property.readPropertyData("powersite", "siteNameForDomain");
				if(name.equals(domainSiteName)){
					System.out.println(name+" is created sucessfully");
					siteCreated=true;
				}else{
					siteCreated=false;
				}
				break;

			}catch(Throwable t){
				t.getMessage();
			}
		}

		return siteCreated;

	}

	/**
	 * The below element and function is for site deletion
	 * @throws IOException 
	 * @throws InterruptedException 
	 * 
	 * */ 

	public void deleteSite() throws IOException, InterruptedException{
		Waiting.waitForTheVisibilty(driver, siteNameForDomain(), 10);
		siteToBeDeleted().click();
		test.log(LogStatus.INFO, "clicked on the desired site to be deleted");
		deleteNetWork.click();
		test.log(LogStatus.INFO, "clicked on the delete network");
		Thread.sleep(3000);
	}
}
