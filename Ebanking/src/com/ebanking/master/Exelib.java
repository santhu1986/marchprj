package com.ebanking.master;

import java.io.IOException;

public class Exelib {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		
		//Instance Class
		
		Library LB = new Library();
		
		String Rval=LB.OpenApp("http://103.211.39.246/ranford2");
		System.out.println(Rval);
		Rval=LB.AdminLgn("Admin","Mindq@Systems");
		System.out.println(Rval);
		Rval=LB.BranchCre();
		System.out.println(Rval);
		LB.Role("Teller","E");
	}

}
