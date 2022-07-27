package cvut.fel.entity;

import cvut.fel.service.CustomerServiceImp;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "accounts")
@NamedQueries({
        @NamedQuery(name = "Account.findByName", query = "SELECT u FROM Account u WHERE u.name = :name"),
})
@Getter @Setter
public class Account extends AbstractEntity{
    private double amount;
    private Date lastOperationDate;
    private Customer customer;

    public Account(double amount, Customer customer) {
        this.amount = amount;
        this.lastOperationDate = new Date();
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "";
    }
}
