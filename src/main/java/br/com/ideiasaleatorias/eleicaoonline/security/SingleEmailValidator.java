package br.com.ideiasaleatorias.eleicaoonline.security;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SingleEmailValidator implements Validator {

	private SystemUserDao userDao;

	public SingleEmailValidator(SystemUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(!target.getClass().equals(SimpleUserForm.class)){
			return ;
		}
		
		SimpleUserForm form = (SimpleUserForm) target;
		if(userDao.findByEmail(form.getEmail()).isPresent()){
			errors.rejectValue("email","email.ja_existe","Este email já está cadastrado");
		}
		
	}

}
