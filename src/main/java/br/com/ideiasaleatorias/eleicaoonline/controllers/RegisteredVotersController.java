package br.com.ideiasaleatorias.eleicaoonline.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ideiasaleatorias.eleicaoonline.controllers.forms.SearchEllectionForm;
import br.com.ideiasaleatorias.eleicaoonline.daos.EllectionDao;
import br.com.ideiasaleatorias.eleicaoonline.daos.VoterDao;
import br.com.ideiasaleatorias.eleicaoonline.infra.ViewMessages;
import br.com.ideiasaleatorias.eleicaoonline.models.Voter;
import br.com.ideiasaleatorias.eleicaoonline.security.SystemUser;

@Controller
@Transactional
public class RegisteredVotersController {
	
	@Autowired
	private EllectionDao ellectionDao;
	@Autowired
	private VoterDao voterDao;

	@GetMapping("/registered")
	public String form(Model model,SearchEllectionForm form,@AuthenticationPrincipal SystemUser owner) {
		model.addAttribute("ellections", ellectionDao.findByOwnerId(owner.getId()));
		return "/ellection/registered-voters";
	}
	
	@GetMapping("/registered/ellection")
	public String search(Model model, SearchEllectionForm form,BindingResult result,@AuthenticationPrincipal SystemUser owner) {
		model.addAttribute("voters",voterDao.findAllByEllectionId(form.getEllectionId()));
		return form(model, form, owner);
	}
	
	@PostMapping("/registered/{voterId}/approve")
	public String approve(Model model,@PathVariable("voterId") Integer voterId,RedirectAttributes redirectAttributes) {
		
		Voter voter = voterDao.findById(voterId).get();
		voter.approve();
		
		ViewMessages.successFlash("eleitor liberado com sucesso", redirectAttributes);
		return "redirect:/registered/ellection?ellectionId="+voter.getEllection().getId();
	}
}
