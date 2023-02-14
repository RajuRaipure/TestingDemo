package WebElements;
import org.openqa.selenium.By;

public interface webElements 
{
	By see_nbn_plan=By.xpath("//*[@id=\"content\"]/section[1]/div/div/div[2]/div/div[3]/div/div/a/span[1]");
	By enterAddress=By.id("queryInput");
	By checkAddress=By.xpath("//button/span[contains(text(),'Check address')]");

}
