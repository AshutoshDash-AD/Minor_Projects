import java.util.Scanner;

public class Polynomial_LL {
	Node head;
	
	static class Node {
		 int coeff,exp;
		 Node next;
		
		 Node(int c,int e)
		{
			coeff=c;
			exp=e;
			next=null;
		}
	}
	
	public void Insert(int nc, int ne)
	{
		Node newNode= new Node(nc,ne);
		newNode.next=head;
		head=newNode;
	}
	
	public void InsertAfter(Node prev, int nc,int ne)
	{
		if(prev==null)
			System.out.println("Invalid");
		
		Node newNode=new Node(nc,ne);
		newNode.next=prev.next;
		prev.next=newNode;
	}
	
	public void add(Polynomial_LL p1,Polynomial_LL p2,Polynomial_LL r)
	{
		int a,b;
		Node current1=p1.head;
		Node current2=p2.head;
		while(current1!=null || current2!=null)
		{
			if(current1.exp > current2.exp)
			{
				a=current1.coeff;
				b=current1.exp;
				current1=current1.next;
			}
			else if(current1.exp == current2.exp)
			{
				a=current1.coeff+current2.coeff;
				b=current1.exp;
				current1=current1.next;
				current2=current2.next;
			}
			else
			{
				a=current2.coeff;
				b=current2.exp;
				current2=current2.next;
			}
			r.Insert(a,b);
		}	
	}	
		
	public void display()
	{
		if(head==null)
				System.out.println("The list is empty");
		
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.coeff+"x^"+temp.exp+"  ");
			temp=temp.next;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Polynomial_LL p1=new Polynomial_LL();
		System.out.println("Given 1st polynomial:");
		p1.Insert(3,2);
		p1.InsertAfter(p1.head,-4,1);
		p1.InsertAfter(p1.head.next,7,0);
		p1.display();
		System.out.println();
		
		Polynomial_LL p2=new Polynomial_LL();
		System.out.println("Given 2nd polynomial:");
		p2.Insert(9,1);
		p2.InsertAfter(p2.head,2,0);
		p2.display();
		System.out.println();
		
		System.out.println("Resultant polynomial:");
		Polynomial_LL r=new Polynomial_LL();
		r.add(p1,p2,r);
		r.display();
	}

}


