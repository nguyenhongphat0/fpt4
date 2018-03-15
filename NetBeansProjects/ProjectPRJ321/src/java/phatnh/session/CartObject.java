/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import phatnh.book.BookDTO;
import phatnh.customer.CustomerDTO;
import phatnh.order.OrderDTO;
import phatnh.orderdetail.OrderDetailDTO;

/**
 *
 * @author nguyenhongphat0
 */
public class CartObject implements Serializable {
    private OrderDTO order;
    private List<OrderDetailDTO> detailList;
    private CustomerDTO customer;

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public List<OrderDetailDTO> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<OrderDetailDTO> detailList) {
        this.detailList = detailList;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public CartObject(CustomerDTO customer) {
        order = new OrderDTO();
        detailList = new ArrayList<>();
        this.customer = customer;
        order.setCustID(customer.getCustID());
        order.setIsDeliver(false);
    }
    
    public OrderDetailDTO getCartItem(BookDTO book) {
        for (OrderDetailDTO orderDetailDTO : detailList) {
            if (orderDetailDTO.getProductID().equals(book.getBookID())) {
                return orderDetailDTO;
            }
        }
        return null;
    }
    
    public boolean removeFromCart(String bookID) {
        for (OrderDetailDTO orderDetailDTO : detailList) {
            if (orderDetailDTO.getProductID().equals(bookID)) {
                detailList.remove(orderDetailDTO);
                return true;
            }
        }
        return false;
    }
    
    public void addToCart(BookDTO book) {
        OrderDetailDTO orderDetailDTO = getCartItem(book);
        if (orderDetailDTO == null) {
            orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setProductID(book.getBookID());
            orderDetailDTO.setQuantity(0);
            orderDetailDTO.setUnitPrice(book.getPrice());
            orderDetailDTO.setTotal(0);
            detailList.add(orderDetailDTO);
        }
        int quantity = orderDetailDTO.getQuantity();
        float price = orderDetailDTO.getUnitPrice();
        float total = orderDetailDTO.getTotal();
        quantity++;
        total += price;
        orderDetailDTO.setQuantity(quantity);
        orderDetailDTO.setTotal(total);
        total = order.getTotal();
        total += price;
        order.setTotal(total);
    }
}
