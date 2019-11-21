import Cotroller.login.Login;
import db.DbCall;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        DbCall dbCall = new DbCall();
        ArrayList arrayList = dbCall.dbConnection();
        System.out.println(arrayList);
    }

}
