package project.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
import project.myFramework.driver.*;
import project.myFramework.myUtills.*;

import java.io.File;


public class BaseTest {
   protected final static Logger log = Logger.getLogger(BaseTest.class);



    @AfterMethod
    void teardown(){
        Driver.quiteDriver();
        log.info("the end");
    }
    @AfterGroups(groups = {"download"})
    void AfterDownload(){
        Utills.deleteFolder(System.getProperty("user.dir") + File.separator + "files");
       log.info("Folder is deleted");
    }


}