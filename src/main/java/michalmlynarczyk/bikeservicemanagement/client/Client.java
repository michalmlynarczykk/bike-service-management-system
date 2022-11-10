package michalmlynarczyk.bikeservicemanagement.client;

import michalmlynarczyk.bikeservicemanagement.order.Order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long clientId;

    @Column(length = 50)
    @NotBlank
    private String firstName;

    @Column(length = 50)
    @NotBlank
    private String lastName;

    @Column(length = 50)
    @NotBlank
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<Order> repairOrder;

    public Client() {

    }

    public Client(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Client(String firstName, String lastName, String phoneNumber, List<Order> repairOrder) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.repairOrder = repairOrder;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getRepairOrder() {
        return repairOrder;
    }

    public void setRepairOrder(List<Order> repairOrder) {
        this.repairOrder = repairOrder;
    }
}
