package com.letcode.SecureBankSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_settings")
public class UserSettingEnitity {
    //Create entity:
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean receiveNewLetter;
    private String prefferedLanguage;


    //Setter-Getter:
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isReceiveNewLetter() {
        return receiveNewLetter;
    }

    public void setReceiveNewLetter(boolean receiveNewLetter) {
        this.receiveNewLetter = receiveNewLetter;
    }

    public String getPrefferedLanguage() {
        return prefferedLanguage;
    }

    public void setPrefferedLanguage(String prefferedLanguage) {
        this.prefferedLanguage = prefferedLanguage;
    }

    //new annotation:OnetoOne(Link not injection)
    @OneToOne
    @JoinColumn(name = "user_id")//"user_id"forign key that combine them
    private UserEntity user;


}

