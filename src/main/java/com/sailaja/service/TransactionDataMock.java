package com.sailaja.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sailaja.entity.Transaction;
import com.sailaja.entity.Customer;

@Service
public class TransactionDataMock {
	
	private static List<Transaction> transactions = new ArrayList<Transaction>();
	private static long index;
	static {
		
		transactions.add( new Transaction(index++, new Customer(1, "Matt"), 100.0, "Purchase 1", new Date()) );
		transactions.add( new Transaction(index++, new Customer(2, "Luis"), 55.0, "Purchase 2", new Date()) );
		transactions.add( new Transaction(index++, new Customer(3, "Karla"), 120.0, "Purchase 3", new Date()) );
	
	}
	
	
	public List<Transaction> getAll() {
		return transactions;
	}
	
}


