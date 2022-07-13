package project.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import project.myFramework.browserUtill.BrowserUtill;
import project.myFramework.myUtills.Utills;
import project.testData.User;
import project.config.JsonParser;
import project.myFramework.driver.Driver;
import project.pages.ElementsPage;
import project.pages.MainPage;
import project.pages.WebTablesPage;

public class Test3_Tables extends BaseTest {
    final static Logger log = Logger.getLogger(Test3_Tables.class);

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return Utills.arrHelper(JsonParser.userData());
    }

    @Test(dataProvider = "data-provider")
    public void testTables(User user) {
        log.info("Step 1");
        BrowserUtill.get(JsonParser.parseURL());
        MainPage mainP = new MainPage();
        Assert.assertTrue(mainP.isOpen(), "Main page is not opened");
        log.info("Step 2");
        mainP.clickElementsButton();
        ElementsPage elementspage = new ElementsPage();
        elementspage.getNavBar().clickWebTables();
        WebTablesPage webTablesPage = new WebTablesPage();
        Assert.assertTrue(webTablesPage.isOpen(), "Web tables page is not opened");
        int numberOfRows = webTablesPage.getNumberOfRows();
        log.info("Step 3");
        webTablesPage.clickAddButton();
        Assert.assertTrue(webTablesPage.formIsOpen(), "User form is not opened");
        webTablesPage.setDataIntoForm(user);
        Assert.assertTrue(webTablesPage.isOpen(), "Web tables page is not opened");
        webTablesPage.clickSubmit();
        log.info("Step 4");
        Assert.assertTrue(numberOfRows + 1 == webTablesPage.getNumberOfRows(), "row is not added");
        User addedUser= webTablesPage.getUserData(user.getEmail());
        Assert.assertTrue(user.equals(addedUser), "Data in tab is incorrect");
        log.info("Step 5");
        webTablesPage.deleteRow(user.getEmail());
        Assert.assertTrue(numberOfRows == webTablesPage.getNumberOfRows(), "row is not deleted");
        Assert.assertTrue(!webTablesPage.checkUser(user), "User is still in table");


    }
}
