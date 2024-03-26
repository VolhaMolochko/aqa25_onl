package pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TopMenuPage;

public class EditProjectPage extends ProjectBasePage {
    private final static String pagePath = "/index.php?/admin/projects/add/1";

    public EditProjectPage(WebDriver driver) {
        this(driver, false);
    }

    public EditProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);

        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return null;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

}