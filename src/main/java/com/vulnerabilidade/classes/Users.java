package com.vulnerabilidade.classes;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vulnerabilidade.DTOS.response.UsersResponseDTO;
import com.vulnerabilidade.enumeration.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Users implements UserDetails{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)    
  private Long id;

  private String login;
  private String senha;

  @Enumerated(EnumType.STRING)
  private Role role;


  public Users(UsersResponseDTO data){

    login = data.login();
    senha = data.senha();
    role = data.role();

  }

  public Users(String login, String senha, Role Role){

    this.login = login;
    this.senha = senha;
    this.role  = Role;

  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if(this.role == Role.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), (new SimpleGrantedAuthority("ROLE_USER")));
    else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
  }
  @Override
  public String getPassword() {
    return senha;
  }
  @Override
  public String getUsername() {
    return login;
  }
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  @Override
  public boolean isEnabled() {
    return true;
  }
  
}
