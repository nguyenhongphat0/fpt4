/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Ticket {
    protected int id;
    protected int price;
    protected Movie formovie;
    protected String consumer_name;
    private static int count = 0;
    
    public Ticket(int price, Movie formovie, String consumer_name) {
        this.id = count++;
        this.price = price;
        this.formovie = formovie;
        this.consumer_name = consumer_name;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Movie getFormovie() {
        return formovie;
    }

    public void setFormovie(Movie formovie) {
        this.formovie = formovie;
    }

    public String getConsumer_name() {
        return consumer_name;
    }

    public void setConsumer_name(String consumer_name) {
        this.consumer_name = consumer_name;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", price=" + price + ", formovie=" + formovie + ", consumer_name=" + consumer_name + '}';
    }
    
    
}
