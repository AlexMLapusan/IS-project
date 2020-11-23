package entity;

import javax.persistence.*;

@Entity
@Table(name = "_transaction")
public class Transaction {
    //TODO: Add all the necessary class variables, getters and setters
    @Id
    private String id;
}
