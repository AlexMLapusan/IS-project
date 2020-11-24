package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    private String id;

    @Column
    private String idUser;

    @Column
    private boolean valid;

    @Column
    private String validityDuration;

    @Column
    private boolean activity;

    @Column
    private Date activationTime;
}
