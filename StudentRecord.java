package com.mydata.Student;

import java.util.Scanner;

public class StudentRecord{
	private int rollno;
    String name;
    static String Class_name;
    String address;
    String course;

    static {

        Class_name = "Edubridge";
    }
    StudentRecord(){}
    StudentRecord save(int sr){
    StudentRecord s=new StudentRecord();
    if (sr > 100) {
        System.out.println("Overflow");
    }
    else
    {
        try
        {
        	System.out.println("***********************************************************\n");
            Scanner sc = new Scanner(System.in);
            System.out.println(" Enter Student Name :\n");
            s.name = sc.next();
            System.out.println(" Enter Student Address :\n");
            s.address = sc.next();
            System.out.println(" Enter Student Course :\n");
            s.course = sc.next();
            System.out.println(" Enter Student Rollno :\n");
            s.rollno = sc.nextInt();

        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
	}
	return s;
	}
    void view(int rollno, int l, StudentRecord stud[]) {
        for (int i = 0; i < l; i++) {
            if (stud[i].rollno == rollno) {
            	stud[i].viewAll(stud[i]);
            }
        }
    }
    boolean delete(int rollno, StudentRecord sd[], int sr) {
        boolean d = false;
        for (int i = 0; i < sr; i++) {
            if (rollno == sd[i].rollno) {
                for (int j = i; j < sr - 1; j++) {
                    sd[j] = sd[j + 1];
                }
               
                d = true;
                return (d);
            }

        }

        return (d);
    }
    boolean update(int rollno, StudentRecord obj[], int sr) {
        boolean u = false;

        for (int i = 0; i < sr; i++) {
            if (rollno == obj[i].rollno) {
                try {System.out.println("*******************************************\n");
                    Scanner sc = new Scanner(System.in);
                    System.out.println(" Enter name :\n");
                    obj[i].name = sc.next();
                    System.out.println(" Enter Address :\n");
                    obj[i].address = sc.next();
                    System.out.println(" Enter Course :\n");
                    obj[i].course = sc.next();

                    u = true;
                    return (u);
                }
                catch (Exception e) 
                {
                    System.out.println(e);
                    e.getMessage();
                }
                }
                }
        return (u);

    }
	private void viewAll(StudentRecord studentRecord) {
		// TODO Auto-generated method stub
		System.out.println("*****************************************************************\n");
        System.out.println(" Student Name :" + studentRecord.name);
        System.out.println(" Student Address :" + studentRecord.address);
        System.out.println(" Student Course :" + studentRecord.course);
        System.out.println(" Student Rollno :" + studentRecord.rollno);
		
	}
	void viewStud(int s,StudentRecord ss[])
	{
		for(int i=0;i<s;i++)
		{
			System.out.println("***********************************************************\n");
			System.out.println("Student Name :"+ss[i].name);
			System.out.println("Student Address :"+ss[i].address);
			System.out.println("Student Course :"+ss[i].course);
			System.out.println("Student Rollno :"+ss[i].rollno);
		}
	}
	public static void main(String args[])
	{
		StudentRecord stud[]=new StudentRecord[100];
		Scanner sc=new Scanner(System.in);
		boolean b=true;
		int r,s=0;
		StudentRecord s1= new StudentRecord();
		
		do
		{
			System.out.println("*****************************************");
			System.out.println("Enter your choice");
			System.out.println("1.Save Student");
			System.out.println("2.Delete Student");
			System.out.println("3.View Student");
			System.out.println("4.Update Student");
			System.out.println("5.ViewAll Student");
			System.out.println("6.Exit \n");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				stud[s]=s1.save(s);
				s++;
				break;
			case 2:
				System.out.println(" Enter rollno.for deletion \n");
				  r = sc.nextInt();
                  boolean b1 = s1.delete(r, stud, s);
                  if (b = true)
                  {
                	  s--;
                      System.out.println("Successfully Deleted");
                  } else {
                      System.out.println(" Rollno is not Found");
                  }
				break;
			case 3:
				System.out.println(" Enter rollno to View student \n");
                r = sc.nextInt();
                s1.view(r, s, stud);
				break;
			case 4:
				System.out.println(" Enter rollno for update \n");
                r = sc.nextInt();
                boolean c = s1.update(r, stud, s);
                if (c = true) {
                    System.out.println("Successfully updated");
                } else {
                    System.out.println(" rollno not found");
                }
				break;
			case 5:
				 s1.viewStud(s,stud);
				 
				 break;  
			case 6:
				System.out.println("Application Exit Success");
				System.exit(0);
				
            default:
               // System.out.println(" Enter right choice ");
			}
			
			 }
			while (b);
	}
}