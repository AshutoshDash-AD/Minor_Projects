import java.util.*;
public class Tester {
	public static void main(String...args){
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter number of books");
		int n=s1.nextInt();
		Author[] o1=new Author[n];
		Book[] o2=new Book[n];
		String aname,email,bname;
		char gender;
		double price;
		int qty;
		System.out.println("	:Create Library:	");
		for(int i=0;i<n;i++){
			System.out.println("Enter name of author,email,gender");
			aname=s1.next();
			email=s1.next();
			gender=s1.next().charAt(0);
			System.out.println("Enter name of book, price and quantity");
			bname=s1.next();
			price=s1.nextDouble();
			qty=s1.nextInt();
			o1[i]=new Author(aname,email,gender);
			o2[i]=new Book(bname,o1[i],price,qty);
		}
		/** Author o1=new Author("Dan Brown","spd@gmail.com",'M');
		    Book o2=new Book("Origin ",o1,12.9); */
		System.out.println("Enter number of students=");
		int N=s1.nextInt();
		Student st[]=new Student[N];
		for(int k=0;k<N;k++){						
			System.out.println("	:Enter Student Details to use Library:		");
			System.out.println("Enter name and roll no.:");
			String sname=s1.next();
			int  sroll=s1.nextInt();
			st[k]=new Student(sname,sroll);
			Book temp=null;
			int count=0;
		while(count<=5){
			int count1=0;
			int count2=0;
			System.out.println("Do you want to IssueBook?(y/n)");
			char z=s1.next().charAt(0);
			if(z=='y'){
				count++;
				count1++;
				temp=st[k].issueBook(o2,n);
			}
			System.out.println("\n Do you want to deposit book?(y/n:)");
			char z1=s1.next().charAt(0);
			if(z1=='y' & count1!=0){
				count2++;
				st[k].depositBook(temp);
				System.out.println("  	\n Now the Library becomes: ");
			}		
			if(count2!=0){	
				System.out.println("Details of your operations after depositing");
				System.out.println( st[k].toString(temp) );
			}
			System.out.println("Do you want to continue operatons?(y/n)");
			char z2=s1.next().charAt(0);
			if(z2=='n'){
				System.out.println("Thank you for visiting library!!");
				break;
			}
		}
		}
		System.out.println("LIBRARY AFTER ALL CHANGES:");
		for(int i=0;i<n;i++){
			System.out.println((i+1)+". "+o2[i].toString());
		}
	}
    
}
