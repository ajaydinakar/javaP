package com.aj_vendingmachine.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.aj_vendingmachine.dat.GetCurrent;
import com.aj_vendingmachine.dbutility.ConnectionManager;
import com.aj_vendingmachine.payment.Validity;

public class Test {
	public static void main(String[] args) {
		System.out.println(Validity.creditCard("1111111111"
				+ ""));

}}
