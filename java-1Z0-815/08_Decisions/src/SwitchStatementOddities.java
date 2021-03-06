/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 4: Using Operators and Decision Constructs
Topic: Switch Statements
Sub-Topic: Out of Ordinary
*/

public class SwitchStatementOddities {
    public static void main(String[] args) {
        byte[] bytes = {100, 103, 104, 107, 126};
        String caseAssignedValue = "";

        start_for:
        for (var i : bytes) {  // Using LVTI here
            switch (i) {  // Use an Expression
                case 100:
                case 103:
                case 104:
                    break;
                case 107:
                    caseAssignedValue = "Less than 1100";
                    break start_for;
                case 126:
                    caseAssignedValue = "Equal to 1260";
                    break;
            }
            System.out.println("Done processing " + i +
                    ", caseAssignedValue = " + caseAssignedValue);
        }


//        int inter;
//
//        switch(inter){
//            case 1:
//                System.out.println("1");
//                break;
//            default:
//                System.out.println("asd");
//                break;
//        }
    }
}