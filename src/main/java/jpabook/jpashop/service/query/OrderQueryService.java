package jpabook.jpashop.service.query;

import jpabook.jpashop.api.OrderApiController;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;


/**
 * @author jySim
 * @since 2025. 5. 14.
 */
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class OrderQueryService {

    private final OrderRepository orderRepository;

    public List<OrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithItem();

        List<OrderDto> result = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(toList());

        return result;
    }

}
