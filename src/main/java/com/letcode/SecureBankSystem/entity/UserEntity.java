package com.letcode.SecureBankSystem.entity;

import com.letcode.SecureBankSystem.util.enums.Status;

import javax.persistence.*;

@Table(name = "bank_users")
@Entity
public class UserEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "phone", nullable = false)
    private Long phone;
    @Column(name = "email", nullable = false)
    private String email;
    //Enum class : take the string and convert it to a string & saved
    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private Status status;

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public Long getPhone() {
        return phone;
    }
    public void setPhone(Long phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}


//the best identity so no one will come and
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// talk its more powerful that the database is the boss!