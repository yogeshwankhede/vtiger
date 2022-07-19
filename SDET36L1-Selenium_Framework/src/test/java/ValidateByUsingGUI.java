import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateByUsingGUI {
	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
		Statement statement = connection.createStatement();
		int randomNumber = new Random().nextInt(100);
		String expectedProjectName   = "Sdet36"+randomNumber;

		statement.executeUpdate("insert into project values('Ty_Project"+randomNumber+"','mohan','23/06/2022','"+expectedProjectName+"','not_completed',7)");


		WebDriverManager.chromedriver().setup();
		WebDriver driver1 = new ChromeDriver();
		driver1.get("http://localhost:8084/");
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver1.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra");
		driver1.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver1.findElement(By.xpath("//button[.='Sign in']")).click();
		driver1.findElement(By.xpath("//a[.='Projects']")).click();

		List<WebElement> list = driver1.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[2]"));

		for(WebElement glist:list) {
			String actualProjectName=glist.getText();
			if(actualProjectName.equals(expectedProjectName))
			{
				System.out.println("Project created ");
			System.out.println("GIT PULL TRY2 ");
		}
		System.out.println("executed");
		System.out.println("GIT PR Request");
		driver1.quit();
		}	}
}
