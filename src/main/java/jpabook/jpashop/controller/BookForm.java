package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jySim
 * @since 2025. 4. 18.
 */
@Getter @Setter
public class BookForm {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;

}
