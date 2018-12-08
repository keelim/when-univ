package BangBang.src.bank;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Person, Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private String firstName;
    private String lastName;
    private String phone;
    private String sex;

    public Customer(String f, String l, String p, String s) {
        firstName = f;
        lastName = l;
        phone = p;
        sex = s;
    }

    public void addAccount(Account acct) {
        accounts.add(acct);
    }

    public Account getAccount(int index) {
        return accounts.get(index);
    }

    public int getNumOfAccounts() {
        return accounts.size();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getSex() {
        return sex;
    }

    public boolean verifyAccountNo(String acctNo) {
        for (int i = 0; i < accounts.size(); i++)
            if ((accounts.get(i)).getAcctNum().equals(acctNo)) return true;
        return false;
    }

    public double getNetWorth() {
        double sum = 0;
        for (int i = 0; i < accounts.size(); i++)
            sum += accounts.get(i).getBalance();
        return sum;
    }
}