package com.powerhouse.pageClass.payment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.powerhouse.commonClass.SelectFunctions;
import com.powerhouse.commonClass.Waiting;
import com.powerhouse.propertyClass.Property;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/* this checkout class will contain
 * all the details of payment option
 * and billing adress
 * */
public class CheckOut {
	int time=0;

	WebDriver driver;
	ExtentTest test;

	@FindBy(id="billing_first_name")
	WebElement firstName;

	@FindBy(id="billing_last_name")
	WebElement lastName;

	@FindBy(id="billing_company")
	WebElement companyName;

	@FindBy(id="billing_country")
	WebElement country;

	@FindBy(id="billing_address_1")
	WebElement streetAdress1;

	@FindBy(id="billing_address_2")
	WebElement streetAdress2;

	@FindBy(id="billing_city")
	WebElement city;

	@FindBy(id="billing_state")
	WebElement state;

	@FindBy(id="billing_postcode")
	WebElement postCode;

	@FindBy(id="billing_phone")
	WebElement phoneNo;

	@FindBy(id="billing_email")
	WebElement emaiId;

	@FindBy(id="payment_method_cod")
	WebElement cashOnDelivery_radioButton;

	@FindBy(id="terms")
	WebElement termsAndCondition;

	@FindBy(id="place_order")
	WebElement submit;
	
	@FindBy(xpath="//h1[text()='Checkout']")
	WebElement chekingoutPage;
	
	@FindBy(xpath="//p[contains(text(),'Your order has been received')]")
	WebElement orderMessage;
	
	@FindBy(xpath="//td[@data-title='Status']")
	WebElement status;

	public CheckOut(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}


	/**
	 * below elements and function
	 * will be for biling details
	 * @throws IOException 
	 * */

	private void fillingUpFirstName() throws IOException{
		firstName.clear();
		String firstname=Property.readPropertyData("billingDetails", "firstName");
		firstName.sendKeys(firstname);
	}

	private void fillingUplastName() throws IOException{
		lastName.clear();
		String lastname=Property.readPropertyData("billingDetails", "lastName");
		lastName.sendKeys(lastname);
	}

	private void enteringComapnyName() throws IOException{
		companyName.clear();
		String company=Property.readPropertyData("billingDetails", "companyName");
		companyName.sendKeys(company);
	}

	private void selectingCountry() throws IOException{
		String countryName=Property.readPropertyData("billingDetails", "country");
		SelectFunctions.selectByText(country, countryName);
	}

	private void addingAdress() throws IOException{
		streetAdress1.clear();
		streetAdress2.clear();
		String adress1=Property.readPropertyData("billingDetails", "streetAdress1");
		String adress2=Property.readPropertyData("billingDetails", "streetAdress2");
		streetAdress1.sendKeys(adress1);
		streetAdress2.sendKeys(adress2);
	}

	private void enteredCityName() throws IOException{
		city.clear();
		String cityName=Property.readPropertyData("billingDetails", "city");
		city.sendKeys(cityName);
	}

	private void selectingState() throws IOException{
		
		String stateName=Property.readPropertyData("billingDetails", "state");
		SelectFunctions.selectByText(state, stateName);
	}

	private void fillingUppostCode() throws IOException{
		postCode.clear();
		String post=Property.readPropertyData("billingDetails", "postCode");
		postCode.sendKeys(post);
	}

	private void fillingUphone() throws IOException{
		phoneNo.clear();
		String phone=Property.readPropertyData("billingDetails", "phoneNo");
		phoneNo.sendKeys(phone);
	}

	private void fillingUpEmail() throws IOException{
		emaiId.clear(); 
		String email=Property.readPropertyData("billingDetails", "emaiId");
		emaiId.sendKeys(email);
	}

	private void selectCountryNewZland() throws IOException{
		String countryName=Property.readPropertyData("billingDetails", "countryNz");
		SelectFunctions.selectByText(country, countryName);
	}
	
	private void selectRegion() throws IOException{
		String stateName=Property.readPropertyData("billingDetails", "region");
		SelectFunctions.selectByText(state, stateName);
	}
	
	/**
	 * this the billing details function
	 * @throws IOException 
	 * */
	public void yourBillingDetails() throws IOException{
		fillingUpFirstName();
		test.log(LogStatus.INFO, "filled up the first name");
		fillingUplastName();
		test.log(LogStatus.INFO, "filled up the last name");
		enteringComapnyName();
		test.log(LogStatus.INFO, "entered the company name");
		selectingCountry();
		test.log(LogStatus.INFO, "selected the country");
		addingAdress();
		test.log(LogStatus.INFO, "entered the adress");
		enteredCityName();
		test.log(LogStatus.INFO, "entered the city name");
		selectingState();
		test.log(LogStatus.INFO, "selecting the state");
		fillingUppostCode();
		test.log(LogStatus.INFO, "fillingup thepost code");
		fillingUphone();
		test.log(LogStatus.INFO, "entered the phone no");
		fillingUpEmail();
		test.log(LogStatus.INFO, "feeling up the email");
	}
	
	public void billingDeatilsForNewZland() throws IOException{
		fillingUpFirstName();
		test.log(LogStatus.INFO, "filled up the first name");
		fillingUplastName();
		test.log(LogStatus.INFO, "filled up the last name");
		enteringComapnyName();
		test.log(LogStatus.INFO, "entered the company name");
		selectCountryNewZland();
		test.log(LogStatus.INFO, "selected the country");
		addingAdress();
		test.log(LogStatus.INFO, "entered the adress");
		enteredCityName();
		test.log(LogStatus.INFO, "entered the city name");
		selectRegion();
		test.log(LogStatus.INFO, "selecting the state");
		fillingUppostCode();
		test.log(LogStatus.INFO, "fillingup thepost code");
		fillingUphone();
		test.log(LogStatus.INFO, "entered the phone no");
		fillingUpEmail();
		test.log(LogStatus.INFO, "feeling up the email");
	}
	
	
/**
 * this function will choose the cod option
 * */
	public void selectingPaymentOption_cod(){
		while(true){
			try{
				boolean result=cashOnDelivery_radioButton.isSelected();
				if(result==true){
					termsAndCondition.click();
					test.log(LogStatus.INFO, "clicked on terms and condtion");

					break;
				}else{
					cashOnDelivery_radioButton.click();
					test.log(LogStatus.INFO, "clicked on cashOnDelivery_radioButton");
					termsAndCondition.click();
					test.log(LogStatus.INFO, "clicked on terms and condtion");
					break;
				}
			}catch(Throwable t){
				Waiting.waitForTheVisibilty(driver, cashOnDelivery_radioButton, 5);
			}
		}
	}
	
/**
 * this function will check the order status
 * @throws InterruptedException 
 * */
	
	private void orderStatus() throws InterruptedException{
		while(time<=10){
			try{
				Waiting.waitForTheVisibilty(driver, chekingoutPage, 10);
				if(chekingoutPage.isDisplayed()){
					String message=orderMessage.getText();
					System.out.println("the message of the order is "+message);
					test.log(LogStatus.INFO, "the message of the order is "+message);
					String orderStatus=status.getText();
					test.log(LogStatus.INFO, "order status is "+orderStatus);
					break;
				}
			}catch(Throwable t){
				System.out.println("waiting for the order status page");
				Thread.sleep(3000);
				time++;
			}
			finally{
				System.out.println("its taking too much time to load the page");
			}
			
		}
	}
	
	
	public void checkingOutProduct() throws IOException, InterruptedException{
		yourBillingDetails();
		selectingPaymentOption_cod();
		submit.click();
		test.log(LogStatus.INFO, "clicked on submit button");
		orderStatus();
	}
	public void checkingOutProductNewZland() throws IOException, InterruptedException{
		billingDeatilsForNewZland();
		selectingPaymentOption_cod();
		submit.click();
		test.log(LogStatus.INFO, "clicked on submit button");
		orderStatus();
	}
}
