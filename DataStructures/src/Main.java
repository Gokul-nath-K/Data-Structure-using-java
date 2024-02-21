import datastructure.linkedlist.SingleLinkedList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean isContinue = true;


        while(isContinue) {

            System.out.println("Select Data Structure:");
            System.out.println("[1] Singly Linked List");
            System.out.println("[0] Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    SingleLinkedList sl = new SingleLinkedList();
                    sl.singleLinkedList();
                    break;

                case 0:
                    System.out.println("END");
                    return;
            }

            System.out.println("Do you want to continue?");
            System.out.println("[Y] [N]");

            String con;
            try {
                sc.nextLine();
                con = sc.nextLine();
            }
            catch (Exception e) {
                System.out.println("Invalid Input");
                continue;
            }

            if(!con.equalsIgnoreCase("y")) {

                isContinue = false;
            }
        }
    }
}
