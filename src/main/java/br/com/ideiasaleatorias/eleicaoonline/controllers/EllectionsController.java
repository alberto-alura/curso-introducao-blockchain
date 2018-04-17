package br.com.ideiasaleatorias.eleicaoonline.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ideiasaleatorias.eleicaoonline.controllers.forms.NewEllectionForm;
import br.com.ideiasaleatorias.eleicaoonline.daos.EllectionDao;
import br.com.ideiasaleatorias.eleicaoonline.infra.ViewMessages;
import br.com.ideiasaleatorias.eleicaoonline.security.SystemUser;

@Controller
@Transactional
public class EllectionsController {
	
	@Autowired
	private EllectionDao ellectionDao;

	@GetMapping("/ellections/form")
	public String form(Model model, NewEllectionForm form) {
		return "/ellection/form";
	}
	
	@PostMapping("/ellections")
	public String save(Model model, @Valid NewEllectionForm form, BindingResult bindingResult,
			RedirectAttributes redirectAttributes,@AuthenticationPrincipal SystemUser owner) {
		if (bindingResult.hasErrors()) {
			return form(model, form);
		}
		
		
		ellectionDao.save(form.toEllection(owner));

		ViewMessages.successFlash("eleição cadastrada com sucesso", redirectAttributes);
		return "redirect:/ellections/form";
	}
}
