package com.amazon;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataFetcher {

    @DataProvider(name = "Credentials")
    public Iterator<Object[]> userCredentialList() throws IOException {
        List<Object[]> objectList = new ArrayList<>();
        File file = new File("/Users/krupaljoshi/Desktop/Krupal Selenium/login.xls");
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook CredentialFile = new HSSFWorkbook(fileInputStream);
        Sheet sheet = CredentialFile.getSheet("Details");
        Row row;
        String userName;
        String password;
        Map<String,String> credentialMap = new HashMap<>();

        for(int i = 1;i<=sheet.getLastRowNum();i++){
            row = sheet.getRow(i);
            objectList.add(new Object[]{row.getCell(0).getStringCellValue().trim(),row.getCell(1).getStringCellValue().trim()});
            userName = row.getCell(0).getStringCellValue().trim();
            password = row.getCell(1).getStringCellValue().trim();
            credentialMap.put(userName,password);
        }
        //objectList.add(new Object[]{});
        return objectList.iterator();
    }
}
