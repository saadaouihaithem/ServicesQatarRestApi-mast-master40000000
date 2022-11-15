package com.smartTech.RestApi.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data



@Table(name = "User ", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Long user_id;
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "password is required")
    @JsonIgnore
    private String password ;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;

    @UpdateTimestamp
    @Column(name="created_at")
    private Instant created;
    private boolean enabled;
    private String token;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime tokenCreationDate;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
          /*  inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")*/
    private Set<Role> roles;


}



