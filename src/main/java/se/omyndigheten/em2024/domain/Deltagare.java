package se.omyndigheten.em2024.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/**
 * Created by Krille on 01/05/2024 19:41
 */
@Entity
public class Deltagare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean hasPaid;
    @OneToMany(mappedBy = "deltagare")
    private Set<MatchTips> matchTipsSet;
    @OneToMany(mappedBy = "deltagare")
    private Set<Points> pointsSet;
    @ManyToOne
    private Liga liga;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public Set<MatchTips> getMatchTipsSet() {
        return matchTipsSet;
    }

    public void setMatchTipsSet(Set<MatchTips> matchTipsSet) {
        this.matchTipsSet = matchTipsSet;
    }

    public Set<Points> getPointsSet() {
        return pointsSet;
    }

    public void setPointsSet(Set<Points> pointsSet) {
        this.pointsSet = pointsSet;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deltagare deltagare = (Deltagare) o;

        if (hasPaid != deltagare.hasPaid) return false;
        if (!Objects.equals(id, deltagare.id)) return false;
        if (!Objects.equals(firstName, deltagare.firstName)) return false;
        if (!Objects.equals(lastName, deltagare.lastName)) return false;
        if (!Objects.equals(nickName, deltagare.nickName)) return false;
        if (!Objects.equals(email, deltagare.email)) return false;
        if (!Objects.equals(password, deltagare.password)) return false;
        if (!Objects.equals(phoneNumber, deltagare.phoneNumber))
            return false;
        if (!Objects.equals(matchTipsSet, deltagare.matchTipsSet))
            return false;
        if (!Objects.equals(pointsSet, deltagare.pointsSet)) return false;
        return Objects.equals(liga, deltagare.liga);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (hasPaid ? 1 : 0);
        result = 31 * result + (matchTipsSet != null ? matchTipsSet.hashCode() : 0);
        result = 31 * result + (pointsSet != null ? pointsSet.hashCode() : 0);
        result = 31 * result + (liga != null ? liga.hashCode() : 0);
        return result;
    }
}
