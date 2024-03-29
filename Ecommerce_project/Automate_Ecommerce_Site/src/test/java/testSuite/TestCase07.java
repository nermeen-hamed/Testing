package testSuite;


import org.openqa.selenium.By;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;





import static org.testng.Assert.assertEquals;

public class TestCase07 {
    String URL="http://live.techpanda.org/";
    @BeforeTest
    public void OpenSite(){
        Utils.setupCredintials(URL);
    }

    @Test

    public void SavePlaceOrderAsPDF() throws InterruptedException {

        Utils.driver.findElement(By.xpath("//*[@class=\"skip-link skip-account\"]")).click();
        Utils.driver.findElement(By.cssSelector("[title=\"My Account\"]")).click();
        //Switch to login page
        for(String window: Utils.driver.getWindowHandles())
            Utils.driver.switchTo().window(window);
        // Enter Login credentials
        Utils.driver.findElement(By.id("email")).sendKeys("m49125366@gmail.com");
        Utils.driver.findElement(By.id("pass")).sendKeys("Test123");
        Utils.driver.findElement(By.id("send2")).click();
        // Switch to home page
        for(String window: Utils.driver.getWindowHandles())
            Utils.driver.switchTo().window(window);


        Utils.driver.findElement(By.linkText("MY ORDERS")).click();
        //Check status of order
        String ActualStatus= Utils.driver.findElement(By.cssSelector("tr.odd:nth-child(1) > td:nth-child(5) > em:nth-child(1)")).getText();
        System.out.println("Actual status "+ActualStatus);
        String ExpectedStatus="Pending";
        try {
                assertEquals(ActualStatus,ExpectedStatus);
                System.out.println("Test case is Passed the status is pending");
            }
        catch (Exception e){
                e.printStackTrace();
        }
        //View Order
        Utils.driver.findElement(By.xpath("//tr[@class=\"first odd\"]/td[6]/span/a")).click();
        String Actualstatus = Utils.driver.findElement(By.xpath("//div[@class=\"page-title title-buttons\"]/h1")).getText();
        String Expectedstatus ="pending";
        if(Actualstatus.toLowerCase().contains(Expectedstatus.toLowerCase())){
            System.out.println(Actualstatus);
            System.out.println("Test case is Passed the status is pending");
        }
        else
            System.out.println("Test case is False ");
        System.out.println(Actualstatus);
        //Print order
        Utils.driver.findElement(By.xpath("//div[@class=\"page-title title-buttons\"]/a[2]")).click();
        for(String window : Utils.driver.getWindowHandles())
            Utils.driver.switchTo().window(window);
        System.out.println(Utils.driver.getTitle());
       //save as pdf
        Thread.sleep(3000);
        /*File scrFile = ((TakesScreenshot) Util.driver).getScreenshotAs(OutputType.FILE);
        String pdf = ("Image\\" + "reset" +".pdf");
        FileUtils.copyFile(scrFile, new File(pdf));*/



        // Step 8. Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.
        // note:  There is no "Change...." link


        // Step 9. Click on 'Save' button and save the file in some location.
        // note: unable to find this Save button

        // Step 10.Verify Order is saved as PDF
        // unable to perform any verification because there is no option to save as PDF

    }

}
