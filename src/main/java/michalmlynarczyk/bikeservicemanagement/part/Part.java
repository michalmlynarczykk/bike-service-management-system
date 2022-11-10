package michalmlynarczyk.bikeservicemanagement.part;

import michalmlynarczyk.bikeservicemanagement.order.Order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long partId;

    @Column(length = 100)
    @NotBlank
    private String partName;

    @NotNull
    private Double price;

    @NotNull
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order repairOrder;

    public Part() {

    }

    public Part(String partName, Double price, int quantity, Order repairOrder) {
        this.partName = partName;
        this.price = price;
        this.quantity = quantity;
        this.repairOrder = repairOrder;
    }

    public Long getPartId() {
        return partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getRepairOrder() {
        return repairOrder;
    }

    public void setRepairOrder(Order repairOrder) {
        this.repairOrder = repairOrder;
    }
}
