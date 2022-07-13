package project.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import project.myFramework.elements.Button;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class UploadAndDownloadPage extends BasePage {
    public UploadAndDownloadPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Upload and Download')]"), "Upload and Download page"));
    }
    final static Logger log = Logger.getLogger(UploadAndDownloadPage.class);
    private By downloadLoc = By.id("downloadButton");
    private By selectFileLoc = By.id("uploadFile");
    private By uploadFilePathLoc = By.id("uploadedFilePath");

    private Button download = new Button(downloadLoc, "download button");
    private Button selectFile = new Button(selectFileLoc, "Select File button");
    private Label uploadFilePath = new Label(uploadFilePathLoc, "upload File Path");

    public void clickDownload(){
        download.click();
    }
    public void setPath(String path){
        selectFile.findeElement().sendKeys(path);
    }
    public String getDownloadLink(){
        return download.findeElement().getAttribute("href");

    }

    public String getUploadFilePath() {
        return uploadFilePath.getText();
    }
    public String getNameOfDownFile(){

       return download.findeElement().getAttribute("download");
    }
}
