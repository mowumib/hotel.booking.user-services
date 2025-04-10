package com.hotel.booking.user_services.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id", updatable = false, unique = true)
    private String id;

    @Column(name = "user_code", unique = true, nullable = false)
    private String userCode;
    
    @Column(name = "name")
    private String name;

    @Column(name= "email", nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(name= "password", nullable = false)
    private String password;

    /* @Column(name= "role", nullable = false)
    private String role; // ADMIN or USER */

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinTable(name = "user_role_assignments", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles = new HashSet<>();

    /* Use @PrePersist to set the id before saving the entity could not use @GeneratedValue(generator = "UUID")*/
    @PrePersist
    public void generateId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

}
