package com.store.operations;

import com.store.enums.Role;
import com.store.exception.StaffNotAuthorizedException;
import com.store.model.Company;
import com.store.model.Product;
import com.store.model.Staff;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;


public class AdminOperationImpl implements AdminOperation{
    @Override
    public void restock(Staff staff, Company company) throws StaffNotAuthorizedException, IOException {
        if(!staff.getRole().equals(Role.MANAGER)){
            throw new StaffNotAuthorizedException("Operation only limited to only the manager");
        }
        restockProduct(company);
    }
    private void restockProduct(Company company) throws IOException {
        String excelFilePath = "src/main/java/ExcelFiles/ProductFiles.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Product[] product = new Product[sheet.getPhysicalNumberOfRows()-1];


        for(int r = 1; r <= sheet.getLastRowNum(); r++){
            XSSFRow row = sheet.getRow(r);

            product[r-1] = new Product(
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getStringCellValue(),
                    row.getCell(3).getStringCellValue(),
                    (int) row.getCell(4).getNumericCellValue(),
                    row.getCell(5).getNumericCellValue()
            );
        }
        company.setProductList(product);
    }
}
