package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaytmPages {
       
WebDriver driver;
	
    @FindBy(id="searchInput")
	WebElement searchtextbox;
	public WebElement getsearchtextbox(){
		return searchtextbox;	
	}
	
   //@FindBy(xpath="//header/div[2]/div[1]/div[2]/form[1]/label[1]/input[1]")	
	//WebElement magnifierbutton;
	//public WebElement getmagnifierbutton(){
			
		//return magnifierbutton;	
		//}
	
	@FindAll(@FindBy(xpath="//div[@class='_2i1r']"))
	List<WebElement> searchboxItem;
	public List<WebElement> getsearchboxItem()
	{
	   return searchboxItem;

	}
   @FindAll(@FindBy(className="price notranslate")) 
   List<WebElement> Prices; 
   public List<WebElement> getPrices(){
   return Prices;
}
   public  PaytmPages(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
}
