
package cucumberJava; 

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When; 

public class cucumberJava { 
	
   WebDriver driver = null; 
   
   @Given("^Que estoy en el menu empleados debo ingresar una(s) palabra(s) en el cuadro de Keywords$") /*Dado que tengo que ingresar una(a) palabras(s) en el campo Keywords */
   public void openPage() { 
	   System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
	   ChromeOptions options = new ChromeOptions();
	   options.addArguments("--no-sandbox"); /*Soluciono error buscando binario*/
       options.addArguments("--disable-dev-shm-usage"); /*Soluciono error buscando binario*/
       driver = new ChromeDriver();
   } 
 
   @When("^necesito mostrar los empleos$")  
   public void goToPagina() { 
	   driver.get("https://www.choucairtesting.com/empleos-testing/");
	   driver.manage().window().maximize();
	   driver.getTitle();
   } 
	
   @Then("^se mostrara una grilla con los resultados de los empleos disponibles$")  
   public void ingresarKeywords() { 
	 //  	 System.out.println("Checking inputFieldSearch step by step");
	     WebElement keywords = driver.findElement(By.name("search_keywords"));
	    keywords.clear();
	    keywords.sendKeys("Analista de Pruebas");
	    keywords.submit();
	    
	    
	    WebElement location = driver.findElement(By.name("search_location"));
		location.clear();
		location.sendKeys("Lima");
		location.submit();
		
	    driver.findElement(By.className("search_submit")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
   } 
   

   
         
   
   @After
   public void tearDown() throws InterruptedException
   {
	 //driver.close(); /*Bingo llegó :D*/
   }
   
   
   
   
   
}

