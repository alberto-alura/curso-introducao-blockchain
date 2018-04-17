package br.com.ideiasaleatorias.eleicaoonline.controllers.forms;

import javax.validation.constraints.NotNull;

public class ChooseElectionForm {

	@NotNull
	private Integer ellectionId;
	
	public Integer getEllectionId() {
		return ellectionId;
	}
	
	public void setEllectionId(Integer ellectionId) {
		this.ellectionId = ellectionId;
	}
}
