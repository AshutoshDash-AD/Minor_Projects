/*
Name: ASHUTOSH DASH
Regd. no: 1941012274
Section: Q
Branch: CSE 
 */

import java.util.Scanner;
public class EncryptByPin {

	public static void main(String[] args) {
		String m="";
		String pin="";
		Scanner sc=new Scanner(System.in);
		
		//taking required inputs
		System.out.println("Enter the no. of digits you want the pin should have: ");
		int n=sc.nextInt();
		System.out.println("Enter four "+n+"-digit numbers:");
		String num1=sc.next();
		String num2=sc.next();
		String num3=sc.next();
		String num4=sc.next();
		
		//pin generation
		for(int i=0;i<n;i++)
		{
			int x=Math.min((int)num1.charAt(i),Math.min((int)num2.charAt(i),Math.min((int)num3.charAt(i),(int)num4.charAt(i))));
			char y=(char)x;
			pin=pin+y;
		}
		System.out.println("Generated pin is: "+pin);
		
		//encryption part
		sc.nextLine();
		System.out.println("Enter any message:");
		String msg=sc.nextLine();
		msg=msg.replaceAll(" ","");
		msg=msg.toLowerCase();
		for(int i=0;i<msg.length();)
		{
			for(int j=0;j<pin.length();j++)
			{
				int a=(int)msg.charAt(i)+Character.getNumericValue(pin.charAt(j));
				if(a>122)
					a=(a-122)+97-1;
				m=m+(char)(a);
				i++;
				if(i>=msg.length())
					break;
			}
		}
		msg=m.toUpperCase();
		System.out.println("Encrypted message is:");
		System.out.println(msg);
	}
	
}

//end of program