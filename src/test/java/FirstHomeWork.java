import org.junit.jupiter.api.Test;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class FirstHomeWork {
    @Test
    public void countCharactersInString() {
        String str = "Learn Java In This Course And Become a Computer Programmer.";
        int length = str.length();
        System.out.println("Number of characters in the string is " + length + ".");
    }

    @Test
    public void creditCalculate() {
        double creditAmount = 50000.00;
        int creditTerm = 12;
        double percentPerYear = 22.00;
        double totalPrincipalPaid;
        double totalPrincipalInterest;
        double percentPerMonth = percentPerYear / 100 / creditTerm;
        double monthlyPayment = creditAmount * (percentPerMonth + (percentPerMonth /
                (pow((1 + percentPerMonth), creditTerm) - 1)));
        totalPrincipalPaid = monthlyPayment * creditTerm;
        totalPrincipalInterest = totalPrincipalPaid - creditAmount;
        //System.out.println("Credit amount - " + creditAmount + ".");
        //System.out.println("Total principal interest - " + totalPrincipalInterest + ".");
        //System.out.println("Total principal paid - " + totalPrincipalPaid + ".");
        System.out.format("Credit Amount - %.2f\n", creditAmount);
        System.out.format("Total Principal Interest - %.2f\n", totalPrincipalInterest);
        System.out.format("Total Principal Paid - %.2f\n", totalPrincipalPaid);
    }

    @Test
    public void distanceBetweenToDots(){
        double x1 = 3;
        double y1 = 2;
        double x2 = 12;
        double y2 = 7;
        double AC = x2 - x1;
        double BC = y2 - y1;
        double AB = sqrt(pow(AC,2) + pow(BC,2));
        System.out.println("Distance between point A and point B is " + AB + ".");
    }
}