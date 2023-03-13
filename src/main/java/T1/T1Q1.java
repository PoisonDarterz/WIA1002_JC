package T1;

import java.util.Scanner;
class Telephone {
    private String areaCode;
    private String number;
    static int numberOfTelephoneObject = 0;

    public Telephone(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
        numberOfTelephoneObject++;
    }

    public String getAreaCode() {
        return areaCode;
    }
    
    public String getNumber() {
        return number;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String toString() {
        String toRet = String.format("%s-%s", areaCode, number);
        return toRet;
    }
}

class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Telephone arr[] = new Telephone[5];
        for (int i = 0; Telephone.numberOfTelephoneObject < 5; i++){
            System.out.print("Enter area code: ");
            String areaCode = sc.nextLine();
            System.out.print("Enter number: ");
            String number = sc.nextLine();
            arr[i] = new Telephone(areaCode, number);
        }
        for (Telephone i : arr) {
            System.out.println();
            System.out.println(i.toString());
        }
    }
}
