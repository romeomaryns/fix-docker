package eu.maryns.fix.source.orders.repository;

import eu.maryns.fix.source.orders.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
}
