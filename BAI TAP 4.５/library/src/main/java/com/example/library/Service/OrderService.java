package com.example.library.Service;

import com.example.library.Model.dto.OrderSummary;
import com.example.library.Model.dto.PaginationResponse;
import com.example.library.Model.entity.Order;
import com.example.library.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.data.autoconfigure.web.DataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByStatus(String status){
        return orderRepository.findByStatus(status);
    }

    public List<Order> getOrdersByCustomerName(String name){
        return orderRepository.findByCustomerNameContaining(name);
    }

    public List<Order> getAllOrdersSorted(String field, String direction){
        Sort sort = direction.equalsIgnoreCase("asc")?Sort.by(field).ascending() : Sort.by(field).descending();
        return orderRepository.findAll(sort);
    }

    public Page<Order> getOrdersPaged(int page, int size){
        Pageable pageable = PageRequest.of(page,size,Sort.by("createdAt").descending());
        return orderRepository.findAll(pageable);
    }

    public List<Order> findOrderHighPrice(){
        return orderRepository.findOrderHighPrice();
    }

    public PaginationResponse<OrderSummary> findAllAndPagination(Pageable pageable){
        Page<OrderSummary> orderSummaries = orderRepository.findAllAndPagination(pageable);
        PaginationResponse paginationResponse = new PaginationResponse(orderSummaries);
        return paginationResponse;
    }

    public PaginationResponse filterOrders(String status, BigDecimal minPrice, Pageable pageable){
        Page<OrderSummary> page = orderRepository.filterOrder(status,minPrice,pageable);
        PaginationResponse paginationResponse = new PaginationResponse();
        paginationResponse.setData(page.getContent());
        paginationResponse.setTotalPage(page.getTotalPages());
        paginationResponse.setTotalElement(page.getTotalElements());
        paginationResponse.setCurrentPage(page.getNumber());
        return paginationResponse;
    }
}
