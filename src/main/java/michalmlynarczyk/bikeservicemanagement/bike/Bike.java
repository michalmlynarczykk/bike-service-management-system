package michalmlynarczyk.bikeservicemanagement.bike;

import michalmlynarczyk.bikeservicemanagement.client.Client;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "bike")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

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

    public Bike() {
    }

    public Bike(Client client, String brand, String model, String color) {
        this.client = client;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
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
}
