package michalmlynarczyk.bikeservicemanagement.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import michalmlynarczyk.bikeservicemanagement.bike.Bike;
import michalmlynarczyk.bikeservicemanagement.order.Order;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long id;

    @Column(length = 50)
    @NotBlank
    private String firstName;

    @Column(length = 50)
    @NotBlank
    private String lastName;

    @Column(length = 50)
    @NotBlank
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "client",
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Bike> bikes;
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "client",
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Order> orders;

    public void addBike(Bike bike) {
        if (bikes == null) {
            bikes = new HashSet<>();
        }
        bikes.add(bike);
        bike.setClient(this);
    }

    public void removeBike(Bike bike) {
        bikes.remove(bike);
        bike.setClient(null);
    }

    public void addOrder(Order order) {
        if (orders == null) {
            orders = new HashSet<>();
        }
        orders.add(order);
        order.setClient(this);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setClient(null);
    }
}
