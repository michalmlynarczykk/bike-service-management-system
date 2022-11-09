package michalmlynarczyk.bikeservicemanagement.part;


import michalmlynarczyk.bikeservicemanagement.order.Order;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100)
    @NotBlank
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Part() {

    }

    public Part(String name, Double price, int quantity, Order order) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.order = order;
    }
}
