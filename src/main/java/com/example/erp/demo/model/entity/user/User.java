//package com.example.erp.demo.model.entity.user;
//
//import com.example.erp.demo.model.entity.BaseEntity;
//import com.example.erp.demo.model.enumeration.Role;
//import jakarta.persistence.*;
//import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//@Entity
//@Table(name = "user")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@EqualsAndHashCode(callSuper = false)
//public class User extends BaseEntity implements UserDetails {
//
//    @Column(name = "firstName", nullable = false)
//    private String firstName;
//
//    @Column(name = "lastName", nullable = false)
//    private String lastName;
//
//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "password")
//    private String password;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "role", nullable = false)
//    private Role role;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority(role.name()));
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
