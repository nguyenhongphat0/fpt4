
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Manager {
    Vector<Ticket> ticketsList;
    String path = "tickets.txt";

    public Manager() {
        this.ticketsList = new Vector<>();
    }

    public Vector<Ticket> getTicketsList() {
        return ticketsList;
    }

    public void setTicketsList(Vector<Ticket> ticketsList) {
        this.ticketsList = ticketsList;
    }
    
    public void addTicket(Ticket x) {
        ticketsList.add(x);
    }
    
    public void sortTicket() {
        ticketsList.sort(new Comparator<Ticket>() {
            public int compare(Ticket t, Ticket t1) {
                return t.id - t1.id;
            }
        });
    }
    
    public void writeFile() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(path);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
        for (Ticket ticket : ticketsList) {
            pw.println(ticket.toString());
        }
    }
}
