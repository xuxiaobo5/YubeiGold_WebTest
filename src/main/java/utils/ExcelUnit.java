package utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;


public class ExcelUnit {

    public static int getWorkbook (String filepath) {
        Workbook wb = null;
        try{
            if(filepath.endsWith(".xls")){
                File  file = new File(filepath);
                InputStream is = new FileInputStream(file);
                wb = new HSSFWorkbook(is);
            }else if(filepath.endsWith(".xlsx")){
                //wb = new XSSFWorkbook(is);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return 0;
    }
}
