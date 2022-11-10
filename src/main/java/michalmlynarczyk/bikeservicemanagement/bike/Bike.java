package michalmlynarczyk.bikeservicemanagement.bike;

import michalmlynarczyk.bikeservicemanagement.client.Client;
import michalmlynarczyk.bikeservicemanagement.order.Order;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "bike")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bikeId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(length = 50)
    @NotBlank
    private String brand;

    @Column(length = 50)
    @NotBlank
    private String model;

    @Column(length = 50)
    @NotBlank
    private String color;

    @OneToMany(mappedBy = "bike")
    private List<Order> repairOrder;

    public Bike() {
    }

    public Bike(Client client, String brand, String model, String color) {
        this.client = client;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public Bike(Client client, String brand, String model, String color, List<Order> repairOrder) {
        this.client = client;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.repairOrder = repairOrder;
    }

    public Long getBikeId() {
        return bikeId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Order> getRepairOrder() {
        return repairOrder;
    }

    public void setRepairOrder(List<Order> repairOrder) {
        this.repairOrder = repairOrder;
    }
}
