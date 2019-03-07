package grp1.autom1.libreplan.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import grp1.autom1.libreplan.pageobject.calendarListPage;
import grp1.autom1.libreplan.pageobject.homePage;
import grp1.autom1.libreplan.pageobject.loginPage;

public class createCalendar {
	
	private WebDriver driver;

	private String BROWSER=System.getProperty("browser");
	
	@Before
	public void init() {

		if (BROWSER.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://localhost:8180/libreplan");
		}
		else if (BROWSER.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://localhost:8180/libreplan");
		}
		else if (BROWSER.equals("internet_explorer")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get("http://localhost:8180/libreplan");
		}
	}
	@Ignore
	@After
public void closeBrowser() {
	
	driver.quit();
	
	}

	@Test
	public void Navigation() throws InterruptedException {
	
		loginPage l = PageFactory.initElements(driver, loginPage.class);
		homePage h = l.connexion("admin", "admin");
	
		calendarListPage c = h.accesAlaPageCalendrier();
		c.creerUnCalendrier();

		
		assertTrue("la colonne Date n'est pas visible", c.colonneDate.isDisplayed());
		
	}

}
