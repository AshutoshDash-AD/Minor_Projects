import java.util.*;
class Student {
	String name;
	int roll;
	Date issueDate;
	Date returnDate;
	Student(String a,int b){
		name=a;
		roll=b;
	}
	public String getName(){
		return name;
	}
	public int getRoll(){
		return roll;	
	}
	Book issueBook(Book obj[],int n){
		System.out.println("\n The library has following books:");
		Scanner s1=new Scanner(System.in);
		for(int i=0;i<n;i++){
			System.out.println((i+1)+". "+obj[i].toString());
		}
		System.out.println("Enter the sl.no. of the book you want to issue:");
		int x=s1.nextInt();
		if(obj[x-1].getQty()<=0){
			System.out.println("Book Not Available");
			return null;
		}
		obj[x-1].setQty(obj[x-1].getQty()-1);
		System.out.println("Enter date of issue(do not enter the month now!you will asked to enter month in the next step)");
		int dd=s1.nextInt();
		System.out.println("Enter month of issue");
		int mm=s1.nextInt();
		System.out.println("Enter year of issue");
		int yyyy=s1.nextInt();
		issueDate =new Date(dd,mm,yyyy);
		System.out.println("You have to deposit the book today itself");
		return obj[x-1];
	}
	void depositBook(Book temp){
		int fine=0;
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter date of deposit(do not enter the month now!you will asked to enter month in the next step)");
		int dd=s1.nextInt();
		System.out.println("Enter month of deposit");
		int mm=s1.nextInt();
		System.out.println("Enter year of deposit");
		int yyyy=s1.nextInt();
		// Deadline of submitting your book is today itself
		temp.setQty(temp.getQty()+1);
		returnDate=new Date(dd,mm,yyyy);
		if(issueDate.mm==returnDate.mm){
			fine=returnDate.dd-issueDate.dd;
		}
		else{
                        int noOfDays;
                        int counter=0;
                        int counter1=0;
			Date f=null;
                        if(issueDate.dd<returnDate.dd){
                            counter++;
                            f.dd=(30+issueDate.dd)-returnDate.dd;
                        }
                        else
                            f.dd=issueDate.dd-returnDate.dd;
                        if(counter!=0)
                            issueDate.mm-=1;
                        if(issueDate.mm<returnDate.mm){
                            counter1++;
                            f.mm=(12+issueDate.mm)-returnDate.mm;
                        }
                        else{
                            f.mm=issueDate.mm-returnDate.mm;
                        }
                        if(counter1!=0)
                            issueDate.yyyy-=1;
                        f.yyyy=issueDate.yyyy-returnDate.yyyy;
                        noOfDays=f.dd+(f.mm*31);
                        fine=noOfDays*1;
		}
		System.out.println("Fine="+fine);		
	}
	public String toString(Book temp){
		return "Student[name:"+name+",roll:"+roll+","+temp.toString()+"issuedate:"+issueDate.getDD()+"/"+issueDate.getMM()+"/"+issueDate.getYYYY()+",returndate:"+returnDate.getDD()+"/"+returnDate.getMM()+"/"+returnDate.getYYYY()+"]";
	}
    
}
