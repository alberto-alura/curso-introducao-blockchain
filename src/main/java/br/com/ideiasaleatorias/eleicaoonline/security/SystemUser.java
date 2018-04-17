package br.com.ideiasaleatorias.eleicaoonline.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class SystemUser implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 810037423582645220L;

	@Override
	public String toString() {
		return "User [id=" + id + ", roles=" + roles + ", email=" + email
				+ ", password=" + password + ", name=" + name + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToMany
	private Set<Role> roles = new HashSet<Role>();

	@NotBlank
	@Column(unique=true)
	private String email;

	@NotBlank
	private String password;
	
	private String name;

	/**
	 * @deprecated
	 */
	public SystemUser() {

	}

	public SystemUser(String name,String email, Password password, Role... roles) {
		this.name = name;
		this.email = email;
		this.password = password.getEncoded();
		this.roles.addAll(Arrays.asList(roles));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
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
	
	public String getEmail() {
		return email;
	}

	public String getName() {
		return this.name;
	}

	public void changePassword(String encodedPassword) {
		this.password = encodedPassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemUser other = (SystemUser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	
}
