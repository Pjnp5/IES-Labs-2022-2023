package IES.Lab3_1;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Phone Number is mandatory")
    private String phone;

    @NotBlank(message = "Age is mandatory")
    private String age;

    public User() {}

    public User(String name, String email, String phone, String age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = email;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
    }


    // standard constructors / setters / getters / toString
}