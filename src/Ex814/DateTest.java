/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex814;

/**
 * Ch 8 Ex814
 * Feng Zhang
 * 7/10/2016
 */
import java.util.Calendar;
import java.util.Scanner;

public class DateTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year;
        int month;
        int day;
        String mm;
        int ddd;

        while (true) {
            System.out.print("Enter 1 for format: MM/DD/YYYY" + "\nEnter 2 for format: Month DD, YYYY"
			+ "\nEnter 3 for format: DDD YYYY" + "\nEnter 4 to exit" + "\nChoice: ");
    	int choice = input.nextInt();
            if (choice == 1) {
                System.out.print("Enter Month (1-12): ");
                month = input.nextInt();
                System.out.print("Enter Day of Month: ");
                day = input.nextInt();
                System.out.print("Enter Year: ");
                year = input.nextInt();
                mm = toMonthString(month);
                ddd = toDayOfYear(day, month, year);				
                System.out.println("");
                Date date1 = new Date(month, day, year);
                System.out.println("MM/DD/YYYY: "+date1.toString());
                Date date2 = new Date(mm, day, year);
                System.out.println("Month DD, YYYY: "+date2.toStringFullMonth());
                Date date3 = new Date(ddd, year);
                System.out.println("DDD  YYYY: "+date3.toStringDayOfYear());
            }
            if (choice == 2) {
                System.out.print("Enter Month Name: ");
                mm = input.next();
                System.out.print("Enter Day of Month: ");
                day = input.nextInt();
                System.out.print("Enter Year: ");
                year = input.nextInt();
                month = toMonthInt(mm);
                ddd = toDayOfYear(day, month, year);
                System.out.println("");
                Date date1 = new Date(month, day, year);
                System.out.println("MM/DD/YYYY: "+date1.toString());
                Date date2 = new Date(mm, day, year);
                System.out.println("Month DD, YYYY: "+date2.toStringFullMonth());
                Date date3 = new Date(ddd, year);
                System.out.println("DDD  YYYY: "+date3.toStringDayOfYear());
            }
            if (choice == 3) {
                System.out.print("Enter Day of Year: ");
                ddd = input.nextInt();
                System.out.print("Enter Year: ");
                year = input.nextInt();
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.DAY_OF_YEAR, ddd);
                month = cal.get(Calendar.MONTH)+1;
                day = cal.get(Calendar.DAY_OF_MONTH);	
                mm = toMonthString(month);
                System.out.println("");
                Date date1 = new Date(month, day, year);
                System.out.println("MM/DD/YYYY: "+date1.toString());
                Date date2 = new Date(mm, day, year);
                System.out.println("Month DD, YYYY: "+date2.toStringFullMonth());
                Date date3 = new Date(ddd, year);
                System.out.println("DDD  YYYY: "+date3.toStringDayOfYear());
            }
            if (choice == 4) {
                break;
            }
        }
    }

    private static int toMonthInt(String mm) {
        String[] Month = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
        for (int i = 0; i <= Month.length; i++) {
            if (Month[i].equals(mm))
                return i+1;
        }
                return 0;
    }

    private static int toDayOfYear(int day, int month, int year) {
        int sum = 0;
        int leap;
        switch (month){
            case 1:
		sum = 0;
		break;
            case 2:
                sum = 31;
		break;
            case 3:
                sum = 59;
		break;
            case 4:
		sum = 90;
		break;
            case 5:
		sum = 120;
		break;
            case 6:
		sum = 151;
		break;
            case 7:
		sum = 181;
		break;
            case 8:
		sum = 212;
		break;
            case 9:
		sum = 243;
		break;
            case 10:
		sum = 273;
		break;
            case 11:
		sum = 304;
		break;
            case 12:
		sum = 334;
		break;
            default:
		System.out.println("data error");
		break;
	}
	sum = sum + day; 
	if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
		leap = 1;
        }else{
		leap = 0;
        }
        if (leap == 1 && month > 2)
		sum++;
                return sum;
    }

    private static String toMonthString(int month) {
        String[] Month = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
            return Month[month-1];
	}
}
