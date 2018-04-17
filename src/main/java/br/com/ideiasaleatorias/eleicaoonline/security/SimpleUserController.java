package br.com.ideiasaleatorias.eleicaoonline.security;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ideiasaleatorias.eleicaoonline.infra.ViewMessages;

@Controller
@RequestMapping("/users")
@Transactional
public class SimpleUserController {
	
	@Autowired
	private SystemUserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	@InitBinder
	public void init(WebDataBinder binder){
		binder.addValidators(new SingleEmailValidator(userDao));
	}

	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(SimpleUserForm form){
		return "users/form";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(Model model, @Valid SimpleUserForm form, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return form(form);
		}
		
		SystemUser newUser = form.build(roleDao.findByName(Role.ELLECTION_OWNER.getName()));
		userDao.save(newUser);
		
		ViewMessages.successFlash("Usuário criado com sucesso. Agora faça o login!", redirectAttributes);
		return "redirect:/";
	}
}
