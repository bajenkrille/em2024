package se.omyndigheten.em2024.domain;

import jakarta.persistence.*;

import java.util.Set;

/**
 * Created by Krille on 01/05/2024 19:41
 */
@Entity
public class Deltagare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deltagareId;

    private Long matchTipsId;
    private Long poangId;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean hasPaid;
    @OneToMany(mappedBy = "deltagare")
    private Set<MatchTips> matchTipsSet;

    public void setDeltagareId(Long id) {
        this.deltagareId = id;
    }

    public Long getDeltagareId() {
        return deltagareId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

}
