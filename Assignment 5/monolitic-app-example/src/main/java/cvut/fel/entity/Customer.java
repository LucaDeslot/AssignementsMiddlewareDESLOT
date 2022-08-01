package cvut.fel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "customers")
@NamedQueries({
        @NamedQuery(name = "Customer.findByName", query = "SELECT u FROM Customer u WHERE u.name = :name"),
})
@Getter @Setter
public class Customer extends AbstractEntity{
    private String phone;
    private Account account = null;

    public Customer() {
    }

    public Customer(String name) {
        this();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "phone='" + phone + '\'' +
                ", account=" + account +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
