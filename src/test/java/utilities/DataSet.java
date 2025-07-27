package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    @DataProvider(name = "invalidUserCredentials")
    public static Object invalidCredentials(){
        Object[][] data = {
                {"","1234a", " ইউজার নাম প্রয়োজন",""},
                {"yeoti4396@2mail.com","", " The password field is empty.",""},
                {"yeoti4396@2mail.co","1234", "Unknown email address. Check again or try your username.",""},
                {"","", " ইউজার নাম প্রয়োজন",""},
//                {"yepoti4396@2mik.com","","","Please fill out this field."}
        };
        return data;
    }
}
