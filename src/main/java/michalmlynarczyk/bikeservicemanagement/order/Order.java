package michalmlynarczyk.bikeservicemanagement.order;

import michalmlynarczyk.bikeservicemanagement.bike.Bike;
import michalmlynarczyk.bikeservicemanagement.client.Client;
import michalmlynarczyk.bikeservicemanagement.part.Part;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity(name = "repair_order")
public class Order {
    @OneToMany(mappedBy = "repairOrder")
    List<Part> parts;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;

    private Date orderDate;

    @Column(length = 500)
    @NotBlank
    private String description;

    @NotNull
    private Double servicePrice;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private OrderStatus status;

    @Transient
    private Double totalRepairPrice;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bike_id")
    private Bike bike;

    public Order() {

    }

    public Order(Date orderDate,
                 String description,
                 Double servicePrice,
                 OrderStatus status,
                 Client client,
                 Bike bike) {
        this.orderDate = orderDate;
        this.description = description;
        this.servicePrice = servicePrice;
        this.status = status;
        this.client = client;
        this.bike = bike;
    }

    public Order(List<Part> parts,
                 Date orderDate,
                 String description,
                 Double servicePrice,
                 OrderStatus status,
                 Double totalRepairPrice,
                 Client client,
                 Bike bike) {
        this.parts = parts;
        this.orderDate = orderDate;
        this.description = description;
        this.servicePrice = servicePrice;
        this.status = status;
        this.totalRepairPrice = totalRepairPrice;
        this.client = client;
        this.bike = bike;
    }

    public Long getOrderId() {
        return orderId;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Double getTotalRepairPrice() {
        return totalRepairPrice;
    }

    public void setTotalRepairPrice(Double totalRepairPrice) {
        this.totalRepairPrice = totalRepairPrice;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
