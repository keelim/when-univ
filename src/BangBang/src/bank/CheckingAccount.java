package BangBang.src.bank;

public class CheckingAccount extends Account
{	
	private static final long serialVersionUID = 1L;

	public CheckingAccount(String acctNo, double balance) { super(acctNo, balance); }	
	public CheckingAccount(String acctNo, double balance, SavingsAccount account)
	{	
		super(acctNo, balance);
		s_acct = account;		
	}	

	/*
	public boolean withdraw(double amt)
	{
		if( getBalance() < amt )
		{
			if(s_acct != null)
			{
				s_acct.balance = s_acct.balance - (amt - balance);
				balance = 0;
				return true;
			}			
			else return false;
		}
		
		else balance -= amt;		
		return true;
	}
	*/	

	public String getAcctType() { return "Checkings"; }	
		
	@SuppressWarnings("unused")
	private SavingsAccount s_acct;
}
