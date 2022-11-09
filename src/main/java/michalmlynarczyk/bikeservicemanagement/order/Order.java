package michalmlynarczyk.bikeservicemanagement.order;

import michalmlynarczyk.bikeservicemanagement.bike.Bike;
import michalmlynarczyk.bikeservicemanagement.client.Client;
import michalmlynarczyk.bikeservicemanagement.part.Part;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity(name = "order")
public class Order {
    @OneToMany(mappedBy = "order")
    List<Part> parts;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private Date date;
    @Column(length = 500)
    @NotBlank
    private String description;
    @Column
    @NotNull
    private Double servicePrice;
    @Transient
    private Double totalRepairPrice;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToOne
    @JoinColumn(name = "bike_id")
    private Bike bike;

    public Order() {

    }

    public Order(Date date, String description, Double servicePrice, Client client, Bike bike) {
        this.date = date;
        this.description = description;
        this.servicePrice = servicePrice;
        this.client = client;
        this.bike = bike;
    }

    public Order(String description, Double servicePrice, Client client, Bike bike) {
        this.description = description;
        this.servicePrice = servicePrice;
        this.client = client;
        this.bike = bike;
    }

    public Order(Date date, String description, Double servicePrice, Double totalRepairPrice, Client client, Bike bike) {
        this.date = date;
        this.description = description;
        this.servicePrice = servicePrice;
        this.totalRepairPrice = totalRepairPrice;
        this.client = client;
        this.bike = bike;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Double getTotalRepairPrice() {
        return totalRepairPrice;
    }

    public void setTotalRepairPrice(Double totalRepairPrice) {
        this.totalRepairPrice = totalRepairPrice;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}
