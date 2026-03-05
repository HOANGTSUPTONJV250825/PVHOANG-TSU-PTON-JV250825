package com.example.library.Repository;

import com.example.library.Model.dto.OrderSummary;
import com.example.library.Model.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("SELECT o FROM Order o WHERE o.status = :status")
    List<Order> findByStatus(String status);

    @Query("SELECT o FROM Order o WHERE o.customerName LIKE CONCAT('%',:name,'%')")
    List<Order> findByCustomerNameContaining(String name);

    @Query("SELECT o FROM Order o WHERE o.totalPrice > (SELECT AVG(o2.totalPrice) FROM Order o2 WHERE month(o2.createdAt)=month(now()))")
    List<Order> findOrderHighPrice();

    @Query("select new com.example.library.Model.dto.OrderSummary(o.orderCode, o.customerName, o.totalPrice) from Order o")
    Page<OrderSummary> findAllAndPagination(Pageable pageable);

    @Query("SELECT new com.example.library.Model.dto.OrderSummary(o.orderCode, o.customerName, o.totalPrice) "+
            "FROM Order o "+
            "WHERE (:status IS NULL OR o.status = :status) "+
            "AND (:minPrice IS NULL OR o.totalPrice >= :minPrice)")
    Page<OrderSummary> filterOrder(@Param("status") String status, @Param("minPrice") BigDecimal minPrice, Pageable pageable);
}
