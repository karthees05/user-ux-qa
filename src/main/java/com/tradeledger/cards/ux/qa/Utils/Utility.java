package com.tradeledger.cards.ux.qa.Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public static void takeScreenSnapShot(final WebDriver driver) throws IOException {
        String fileName = "";
        DateFormat dateFormat = new SimpleDateFormat("-dd-MM-yy-hhmmss");
        Date date = new Date();
        fileName += dateFormat.format(date);
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("target/snapshots/" + fileName + ".jpg"));
        } catch (Exception e) {
            System.out.println("Unable to access folder for Snapshots");
        }
    }

}
