package BangBang.src.bank;

public class SavingsAccount extends Account {
    @SuppressWarnings("unused")
    private double interestedRate;

    public SavingsAccount(String acctNo, double balance, double i_rate) {
        super(acctNo, balance);
        interestedRate = i_rate;
    }

    public String getAcctType() {
        return "Savings";
    }
}
