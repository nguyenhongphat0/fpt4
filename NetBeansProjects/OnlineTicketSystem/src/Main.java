
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String choice;
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        do {
            System.out.println("1. Add ticket");
            System.out.println("2. Sort ticket by id");
            System.out.print("Your choice: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    try {
                        System.out.print("Price: ");
                        int price = Integer.parseInt(sc.nextLine());
                        System.out.print("Consumer name: ");
                        String consumerName = sc.nextLine();
                        System.out.print("Movie id: ");
                        int movieId = Integer.parseInt(sc.nextLine());
                        System.out.print("Movie title: ");
                        String movieTitle = sc.nextLine();
                        Ticket t = new Ticket(price, new Movie(movieId, movieTitle), consumerName);
                        manager.addTicket(t);
                    } catch (Exception e) {
                        System.out.println("Invalid number!");
                    }
                    break;
                    
                case "2":
                    manager.sortTicket();
                    System.out.println("Done!");
                    for (Ticket ticket : manager.ticketsList) {
                        System.out.println(ticket);
                    }
                    System.out.println();
                    break;
            }
        } while (choice.equals("1") || choice.equals("2"));
    }
    
}
