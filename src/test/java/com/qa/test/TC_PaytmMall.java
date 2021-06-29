package com.qa.test;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class TC_PaytmMall extends TestBase {
     
	 @Test(dataProvider = "getData")
	    public void SearchItem(String Itemname) throws IOException, InterruptedException {

		   paytm.getsearchtextbox().sendKeys(Itemname);
		   Thread.sleep(3000);
		   paytm.getsearchtextbox().sendKeys(Keys.ENTER);
		   Thread.sleep(3000);
		   paytm.getsearchtextbox().clear();
	  
			 String Title= driver.getTitle();
			 if(Title.contains(Itemname))
			 {
				 Reporter.log("The item is searched",true);
				 Assert.assertTrue(true);

			 }
			 else
			 {
				 captureScreenshot(driver,"SearchItem");
				 Reporter.log("The item is not searched",true);
				 Assert.assertTrue(false);
			 }
			 paytm.getsearchtextbox().clear();

		}
	    
		 @DataProvider
			public String[][] getData() throws IOException
			{
				String xFile = "C:\\Users\\haveeshreddy\\Desktop\\SelJars\\Paytm2\\src\\test\\java\\com\\qa\\testdata\\PayInput.xlsx";
				String xSheet="Sheet1";
				int rowCount=ExcelUtility.getRowCount(xFile, xSheet);
				int cellCount =ExcelUtility.getCellCount(xFile, xSheet, rowCount);
				
				String[][] data=new String[rowCount][cellCount];
				for(int i=1;i<=rowCount;i++)
				{
					for(int j=0;j<cellCount;j++)
					{
						data[i-1][j]=ExcelUtility.getCellData(xFile, xSheet, i, j);
						
					}
					
				}
				
				
				return data;
				
			}
}
