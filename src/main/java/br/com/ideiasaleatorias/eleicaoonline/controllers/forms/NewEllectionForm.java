package br.com.ideiasaleatorias.eleicaoonline.controllers.forms;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.ideiasaleatorias.eleicaoonline.models.Ellection;
import br.com.ideiasaleatorias.eleicaoonline.security.SystemUser;

public class NewEllectionForm {

	@NotBlank
	@Length(max=20)
	private String name;
	
	@NotNull
	@Future
	@DateTimeFormat(pattern = "dd/MM/yyyy kk:mm")
	private LocalDateTime endingTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(LocalDateTime endingTime) {
		this.endingTime = endingTime;
	}

	@Override
	public String toString() {
		return "NewEllectionForm [name=" + name + ", endingTime=" + endingTime + "]";
	}

	public Ellection toEllection(SystemUser owner) {
		return new Ellection(name, endingTime, owner);
	}

	
}
