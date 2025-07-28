package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    @DataProvider(name = "invalidUserCredentials(DataDriven)")
    public static Object invalidCredentials(){
        Object[][] data = {
                {"","1234a", " ইউজার নাম প্রয়োজন",""},
                {"yeoti4396@2mail.com","", " The password field is empty.",""},
                {"yeoti4396@2mail.co","1234", "Unknown email address. Check again or try your username.",""},
                {"","", " ইউজার নাম প্রয়োজন",""},
        };
        return data;
    }
}
