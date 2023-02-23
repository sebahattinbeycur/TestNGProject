package com.exelenter.class04;

/*
  Task: Add Employees using Data Provider Annotation
         1. Open the Chrome browser
         2. Go to https://exelentersdet.com
         3. Login into the application
         4. Navigate to Add Employee Page
         5. Add a new employee by providing
             - First Name
             - Last Name
         6. Click Save Button to save employee
         7. Close the browser
 */

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;

public class _05_AddEmployee extends BaseClass {

    @Test(dataProvider = "testOne")
    public void addEmployeeTest(String firstName, String lastName) {
        loginPage.loginToWebsite("username", "password");
        wait(1);
        pimPage.navigateToAddEmployee();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.lastName, lastName);
        String expectedEmployeeId = addEmployeePage.employeeId.getAttribute("value");
        click(addEmployeePage.saveButton);

        // Validation
        waitForVisibility(personalDetailsPage.personalDetailsHeader);
        String actualEmployeeId = personalDetailsPage.employeeId.getAttribute("value");
        Assert.assertEquals(actualEmployeeId, expectedEmployeeId,"Employee Id doesn't match");
    }

    @DataProvider(name = "testOne")
    public Object[][] addEmployees (){
        Object[][] employee = {
                {"John", "Doe"},
                {"Jack", "Sparrow"}
        };
        return employee;
    }
}
