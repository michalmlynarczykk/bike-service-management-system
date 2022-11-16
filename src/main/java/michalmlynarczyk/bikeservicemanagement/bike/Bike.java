package michalmlynarczyk.bikeservicemanagement.bike;

import lombok.*;
import michalmlynarczyk.bikeservicemanagement.client.Client;
import michalmlynarczyk.bikeservicemanagement.order.Order;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "bike")
@Data
@EqualsAndHashCode(exclude = "client")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bike {
    @SequenceGenerator(
            name = "bike_sequence",
            sequenceName = "bike_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bike_sequence")
    private Long id;

    @Column(length = 50)
    @NotBlank
    private String brand;

    @Column(length = 50)
    @NotBlank
    private String model;

    @Column(length = 50)
    @NotBlank
    private String color;

    @ManyToOne(
            optional = false
    )
    @JoinColumn(
            name = "client_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Client client;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "bike",
            orphanRemoval = true)
    private Set<Order> orders;

    public void addOrder(Order order) {
        if (orders == null) {
            orders = new HashSet<>();
        }
        orders.add(order);
        order.setBike(this);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setBike(null);
    }

}
