package az.ibatech.codechallange.entity.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private Double monthlyPayment;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("customer")
    private Set<CreditHistories> creditHistories;

    public Customer(String name,  Integer age, Double monthlyPayment) {
        this.name = name;
        this.age = age;
        this.monthlyPayment = monthlyPayment;
    }


}
