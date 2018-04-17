package br.com.ideiasaleatorias.eleicaoonline.security;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;


@Repository
public class UserLoginDao implements UserDetailsService{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		String jpql = "select distinct(u) from SystemUser u join fetch u.roles where u.email = :email";
		List<SystemUser> users = manager.createQuery(jpql, SystemUser.class)
				.setParameter("email", email).getResultList();
		if (users.isEmpty()) {
			throw new UsernameNotFoundException("O usuario " + email + " não existe");
		}
		return users.get(0);
	}

}
