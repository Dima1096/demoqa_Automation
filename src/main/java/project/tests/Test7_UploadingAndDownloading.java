package project.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.config.JsonParser;
import project.myFramework.browserUtill.BrowserUtill;
import project.myFramework.myUtills.Utills;
import project.pages.ElementsPage;
import project.pages.MainPage;
import project.pages.UploadAndDownloadPage;
import java.io.File;


public class Test7_UploadingAndDownloading extends BaseTest {
    final static Logger log = Logger.getLogger(Test7_UploadingAndDownloading.class);

    @Test(groups = {"download"})
    public void testUploadingAndDownloading() {
        log.info("Step 1");
        BrowserUtill.get(JsonParser.parseURL());
        MainPage mainP = new MainPage();
        Assert.assertTrue(mainP.isOpen(), "Main page is not opened");
        log.info("Step 2");
        mainP.clickElementsButton();
        ElementsPage elementsPage = new ElementsPage();
        elementsPage.getNavBar().clickUploadAndDownload();
        UploadAndDownloadPage uplAndDownlPage = new UploadAndDownloadPage();
        Assert.assertTrue(uplAndDownlPage.isOpen(), "Upload And Download Page is not opened");
        log.info("Step 3");

        String filesPath = System.getProperty("user.dir") + File.separator + "files";
        long initialQuantity = Utills.checkFiles(filesPath);
        uplAndDownlPage.clickDownload();
        String ext= Utills.getExt(uplAndDownlPage.getNameOfDownFile());
        log.info(ext);
        Assert.assertTrue(Utills.waitToJpeg(ext,filesPath, initialQuantity).exists(), "file is not downloaded");
        File lastFile = Utills.getLastModifiedFile(filesPath);

        log.info("Step 4");
        uplAndDownlPage.setPath(lastFile.getPath());
        Assert.assertTrue(uplAndDownlPage.getUploadFilePath().endsWith(lastFile.getName()),"File is not uploaded");


    }


}
