package com.vulnerabilidade.classes;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.vulnerabilidade.DTOS.response.FuncionarioResponseDTO;
import com.vulnerabilidade.enumeration.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "funcionario")
@Entity(name = "funcionario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "funcionario_id")

public class Funcionario implements UserDetails{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long funcionario_id;

  @OneToOne
  @MapsId
  private Pessoa funcionario;
  
  private String funcionario_usuario;
  private String funcionario_senha;
  private String funcionario_funcao;
  private String funcionario_departamento;
  private Float funcionario_salario;
  private Role funcionario_role;
  
  public Funcionario(FuncionarioResponseDTO data) {

    funcionario_id            = data.funcionario_id();
    funcionario_usuario       = data.funcionario_usuario();
    funcionario_senha         = data.funcionario_senha();
    funcionario_departamento  = data.funcionario_departamento();
    funcionario_funcao        = data.funcionario_funcao();
    funcionario_salario       = data.funcionario_salario();
    funcionario_role          = data.funcionario_role();

  }

  public Funcionario(String funcionario_usuario, String funcionario_senha, Role funcionario_role){

    this.funcionario_usuario  = funcionario_usuario;
    this.funcionario_senha    = funcionario_senha;
    this.funcionario_role     = funcionario_role;

  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if(this.funcionario_role == Role.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), (new SimpleGrantedAuthority("ROLE_USER")));
    else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public String getPassword() {
    return funcionario_senha;
  }

  @Override
  public String getUsername() {
    return funcionario_usuario;
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
