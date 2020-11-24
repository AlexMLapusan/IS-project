package entity;

import javax.persistence.*;

@Entity
@Table(name = "station")
public class Station {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String address;

    public Station() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
