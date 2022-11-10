package project.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.testData.User;
import project.config.JsonParser;
import project.myFramework.driver.Driver;
import project.myFramework.elements.*;
import project.myFramework.pages.BasePage;

import java.time.Duration;
import java.util.List;

public class WebTablesPage extends BasePage {
    public WebTablesPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Web Tables')]"), "Label of Web Tables page"));
    }

    final static Logger log = Logger.getLogger(WebTablesPage.class);

    private By addLoc = By.id("addNewRecordButton");
    private By firstNameLoc = By.id("firstName");
    private By lastNameLoc = By.id("lastName");
    private By emailLoc = By.id("userEmail");
    private By ageLoc = By.id("age");
    private By salaryLoc = By.id("salary");
    private By departmentLoc = By.id("department");
    private By submitButtonLoc = By.id("submit");
    private String delletbuttinloc = "/following-sibling::div//span[contains(@id,'delete-record')]";
    private By regFormLoc = By.id("registration-form-modal");
    private String rowLocatorEmail = "//div[@role='row']//div[text()='%s']";
    private String firstNameCell = "/preceding-sibling::div[3]";
    private String lastNameCell = "/preceding-sibling::div[2]";
    private String ageCell = "/preceding-sibling::div[1]";                        //использовал индксы, потому что не смог приявзяться к клеткам по другому
    private String salaryCell = "/following-sibling::div[1]";
    private String departmentCell = "/following-sibling::div[2]";
    private String rowLocator = "//div[@class='rt-tbody']/div";


    private Button add = new Button(addLoc, "Add button");
    private Input firstName = new Input(firstNameLoc, "First name input");
    private Input lastName = new Input(lastNameLoc, "Last name input");
    private Input email = new Input(emailLoc, "Email input");
    private Input age = new Input(ageLoc, "Age input");
    private Input salary = new Input(salaryLoc, "Salary input");
    private Input department = new Input(departmentLoc, "Department input");
    private Button submit = new Button(submitButtonLoc, "Submit button");
    private Label regForm = new Label(regFormLoc, "Registration form");


    public void setDataIntoForm(User user) {
        firstName.sendKeys(user.getFirstName());
        lastName.sendKeys(user.getLastName());
        age.sendKeys(user.getAge());
        email.sendKeys(user.getEmail());
        salary.sendKeys(user.getSalary());
        department.sendKeys(user.getDepartment());
    }

    public int getNumberOfRows() {
        int res = 0;
        List<WebElement> list = Driver.initi().findElements(By.xpath(rowLocator));
        for (int x = 0; x < list.size(); x++) {
            if (!list.get(x).getText().trim().isEmpty()) {
                res++;
            }
        }
        return res;
    }

    public boolean formIsOpen() {
        boolean res = false;
        try {
            new WebDriverWait(Driver.initi(), Duration.ofMillis(JsonParser.parstimeOut())).until(ExpectedConditions.presenceOfElementLocated(regFormLoc));
            res = true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return res;
    }

    public void clickAddButton() {
        add.click();
    }

    public boolean clickSubmit() {
        submit.click();
        boolean res = true;

        try {
            new WebDriverWait(Driver.initi(), Duration.ofMillis(JsonParser.parstimeOut())).until(ExpectedConditions.invisibilityOfElementLocated(submitButtonLoc));
        } catch (Exception e) {
            log.error("form has not been submitted");
            res = false;
        }
        return res;
    }

    public void deleteRow(String email) {

        Button delete = new Button(By.xpath(String.format(rowLocatorEmail, email) + delletbuttinloc), "Delete button");
        delete.clickJS();
        log.info("Row for " + email + " has been deleted");
    }

    public boolean checkUser(User user) {
        boolean res = false;
        try {
            Cell email = new Cell(By.xpath(String.format(rowLocatorEmail, user.getEmail())), "email");
            email.isDisplayed();
            res = true;
        } catch (Exception e) {
        }
        return res;
    }

    public User getUserData(String email) {

        Cell emailCell = new Cell(By.xpath(String.format(rowLocatorEmail, email)), "email");
        Cell firstName = new Cell(By.xpath(String.format(rowLocatorEmail, email) + firstNameCell), "First Name");
        Cell lastName = new Cell(By.xpath(String.format(rowLocatorEmail, email) + lastNameCell), "Last Name");
        Cell age = new Cell(By.xpath(String.format(rowLocatorEmail, email) + ageCell), "Age");
        Cell salary = new Cell(By.xpath(String.format(rowLocatorEmail, email) + salaryCell), "Salary");
        Cell department = new Cell(By.xpath(String.format(rowLocatorEmail, email) + departmentCell), "Department");
        User AddedUser = new User(firstName.getText(),lastName.getText(),emailCell.getText(),age.getText(),salary.getText(),department.getText());

        return AddedUser;
    }

}
