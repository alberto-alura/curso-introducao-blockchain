package br.com.ideiasaleatorias.eleicaoonline.controllers.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.ideiasaleatorias.eleicaoonline.daos.EllectionDao;
import br.com.ideiasaleatorias.eleicaoonline.models.Candidate;

public class NewCandidateForm {

	@NotBlank
	private String name;
	@NotNull
	private Integer ellectionId;
	@NotBlank
	private String number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEllectionId() {
		return ellectionId;
	}

	public void setEllectionId(Integer ellectionId) {
		this.ellectionId = ellectionId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Candidate toCandidate(EllectionDao ellectionDao) {
		return new Candidate(name,number,ellectionDao.findById(ellectionId).get());
	}

}
