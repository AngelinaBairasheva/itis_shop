package org.itis.hib.domain;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

/**
 * Created by SDS on 15.04.2016.
 */
@Entity
@Table(name = "users", catalog = "itis_shop_db")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID")
    private Integer id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "AGE")
    private Integer age;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "user")
    @Cascade(CascadeType.REFRESH)
    private List<Order> orderses;

    public List<Order> getOrderses() {
        return orderses;
    }

    public void setOrderses(List<Order> orderses) {
        this.orderses = orderses;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", orderses=" + orderses +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public User() {
    }
}
