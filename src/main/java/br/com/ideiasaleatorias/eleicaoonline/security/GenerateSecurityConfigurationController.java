package br.com.ideiasaleatorias.eleicaoonline.security;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Transactional
public class GenerateSecurityConfigurationController {

	@PersistenceContext
	private EntityManager entityManager;

	@RequestMapping("/magic/generate/roles")
	@ResponseBody
	public String generateRoles() {
		entityManager.persist(Role.ELLECTION_OWNER);
		return "Roles geradas. Por favor, não execute essa url novamente.";
	}

	@RequestMapping("/magic/generate/owner/")
	@ResponseBody
	public String generateOwner() {
		SystemUser user = new SystemUser("teste", "teste@gmail.com",
				Password.buildWithRawText("123456"), Role.ELLECTION_OWNER);
		entityManager.persist(user);
		return "Usuario para realização de testes gerados. Por favor, não execute essa url novamente.";
	}
}
