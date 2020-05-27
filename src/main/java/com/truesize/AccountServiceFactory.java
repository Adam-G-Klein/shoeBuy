package com.truesize;

public class AccountServiceFactory{
	private static AccountService ac = new AccountService();

	public static AccountService getInstance(){
		return ac;
	}
}