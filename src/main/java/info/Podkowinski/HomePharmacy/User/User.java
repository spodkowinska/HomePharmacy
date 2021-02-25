package info.Podkowinski.HomePharmacy.User;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private String id;

    private String name;

    private String encodedPassword;

    private String email;



    //getters and setters

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


    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
