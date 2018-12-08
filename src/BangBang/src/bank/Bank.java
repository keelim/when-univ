package BangBang.src.bank;

import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public Bank() {}	
	public void addCustomer(String f, String l, String p, String s)
	{ customers.add(new Customer(f, l, p, s)); }
	public int getNumOfCustomers() { return customers.size(); }	
	public Customer getCustomer(int index) { return customers.get(index); }
}
