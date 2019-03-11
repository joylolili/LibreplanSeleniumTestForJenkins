package grp1.autom1.libreplan.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListeProjetsPage {

	@FindBy(xpath="//td[contains(text(), 'Liste des projets')]")
	public WebElement menuVerticalDetailProjetAffiche;
	
	@FindBy(xpath="//span[contains(text(), 'PROJET_TEST')]")
	public WebElement projetTestCree;
	
	
	

	protected final WebDriver driver;

	public ListeProjetsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
}
