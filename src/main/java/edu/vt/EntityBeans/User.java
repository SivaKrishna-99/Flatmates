/*
 * Created by Dishang, Siva on 2021.04.10
 * Copyright © 2021 Dishang, Siva. All rights reserved.
 */
package edu.vt.EntityBeans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// The @Entity annotation designates this class as a JPA Entity class representing the User table in the FlatmatesDB database.
@Entity

// Name of the database table represented
@Table(name = "User")

@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName")
    , @NamedQuery(name = "User.findByMiddleName", query = "SELECT u FROM User u WHERE u.middleName = :middleName")
    , @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName")
    , @NamedQuery(name = "User.findByAddress1", query = "SELECT u FROM User u WHERE u.address1 = :address1")
    , @NamedQuery(name = "User.findByAddress2", query = "SELECT u FROM User u WHERE u.address2 = :address2")
    , @NamedQuery(name = "User.findByCity", query = "SELECT u FROM User u WHERE u.city = :city")
    , @NamedQuery(name = "User.findByState", query = "SELECT u FROM User u WHERE u.state = :state")
    , @NamedQuery(name = "User.findByZipcode", query = "SELECT u FROM User u WHERE u.zipcode = :zipcode")
    , @NamedQuery(name = "User.findBySecurityQuestionNumber", query = "SELECT u FROM User u WHERE u.securityQuestionNumber = :securityQuestionNumber")
    , @NamedQuery(name = "User.findBySecurityAnswer", query = "SELECT u FROM User u WHERE u.securityAnswer = :securityAnswer")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
})

public class User implements Serializable {

    // User was a reserved keyword in SQL in 1999, but not any more.

    /*
    ========================================================
    Instance variables representing the attributes (columns)
    of the User table in the FlatmatesDB database.
    ========================================================
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "username")
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "password")
    private String password;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 32)
    @Column(name = "middle_name")
    private String middleName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "last_name")
    private String lastName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "address1")
    private String address1;

    @Size(max = 128)
    @Column(name = "address2")
    private String address2;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "city")
    private String city;

    // state was a reserved keyword in SQL in 1999, but not any more.
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "state")
    private String state;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "zipcode")
    private String zipcode;

    @Basic(optional = false)
    @NotNull
    @Column(name = "security_question_number")
    private int securityQuestionNumber;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "security_answer")
    private String securityAnswer;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @NotNull
    @Column(name = "eating_pref_number")
    private int eatingPrefNumber;

    @Basic(optional = false)
    @NotNull
    @Column(name = "smoking_pref_number")
    private int smokingPrefNumber;

    @Basic(optional = false)
    @NotNull
    @Column(name = "alcohol_pref_number")
    private int alcoholPrefNumber;

    @Basic(optional = false)
    @NotNull
    @Column(name = "sleep_pref_number")
    private int sleepPrefNumber;

    @Basic(optional = false)
    @NotNull
    @Column(name = "social_pref_number")
    private int socialPrefNumber;

    @OneToMany(mappedBy = "userId")
    private Collection<UserPhoto> userPhotoCollection;

    /*
    ============================================================
    Class constructors for instantiating a User entity object to
    represent a row in the User table in the FlatmatesDB database.
    ============================================================
     */
    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username, String password, String firstName, String middleName,
                String lastName, String address1, String address2, String city, String state,
                String zipcode, int securityQuestionNumber, String securityAnswer, String email,
                int eatingPrefNumber, int smokingPrefNumber,
                int alcoholPrefNumber, int sleepPrefNumber, int socialPrefNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.securityQuestionNumber = securityQuestionNumber;
        this.securityAnswer = securityAnswer;
        this.email = email;
        this.eatingPrefNumber = eatingPrefNumber;
        this.smokingPrefNumber = smokingPrefNumber;
        this.alcoholPrefNumber = alcoholPrefNumber;
        this.sleepPrefNumber = sleepPrefNumber;
        this.socialPrefNumber = socialPrefNumber;
    }

    /*
    ======================================================
    Getter and Setter methods for the attributes (columns)
    of the User table in the FlatmatesDB database.
    ======================================================
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getSecurityQuestionNumber() {
        return securityQuestionNumber;
    }

    public void setSecurityQuestionNumber(int securityQuestionNumber) {
        this.securityQuestionNumber = securityQuestionNumber;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEatingPrefNumber() {
        return eatingPrefNumber;
    }

    public void setEatingPrefNumber(int eatingPrefNumber) {
        this.eatingPrefNumber = eatingPrefNumber;
    }

    public int getSmokingPrefNumber() {
        return smokingPrefNumber;
    }

    public void setSmokingPrefNumber(int smokingPrefNumber) {
        this.smokingPrefNumber = smokingPrefNumber;
    }

    public int getAlcoholPrefNumber() {
        return alcoholPrefNumber;
    }

    public void setAlcoholPrefNumber(int alcoholPrefNumber) {
        this.alcoholPrefNumber = alcoholPrefNumber;
    }

    public int getSleepPrefNumber() {
        return sleepPrefNumber;
    }

    public void setSleepPrefNumber(int sleepPrefNumber) {
        this.sleepPrefNumber = sleepPrefNumber;
    }

    public int getSocialPrefNumber() {
        return socialPrefNumber;
    }

    public void setSocialPrefNumber(int socialPrefNumber) {
        this.socialPrefNumber = socialPrefNumber;
    }

    // The @XmlTransient annotation is used to resolve potential name collisions
    // between a JavaBean property name and a field name.
    public Collection<UserPhoto> getUserPhotoCollection() {
        return userPhotoCollection;
    }

    public void setUserPhotoCollection(Collection<UserPhoto> userPhotoCollection) {
        this.userPhotoCollection = userPhotoCollection;
    }

//    public Collection<UserQuestionnaire> getUserQuestionnaireCollection() {
//        return userQuestionnaireCollection;
//    }
//
//    public void setUserQuestionnaireCollection(Collection<UserQuestionnaire> userQuestionnaireCollection) {
//        this.userQuestionnaireCollection = userQuestionnaireCollection;
//    }

    /*
    ================
    Instance Methods
    ================
     */
    /**
     * @return Generates and returns a hash code value for the object with id
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Checks if the User object identified by 'object' is the same as the User object identified by 'id'
     *
     * @param object The User object identified by 'object'
     * @return True if the User 'object' and 'id' are the same; otherwise, return False
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        // Convert the User object's database primary key (Integer) to String type and return it.
        return id.toString();
    }

}
