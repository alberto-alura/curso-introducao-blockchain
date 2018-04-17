package br.com.ideiasaleatorias.eleicaoonline.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.ideiasaleatorias.eleicaoonline.security.SystemUser;

@Entity
public class Ellection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String name;
	@NotNull
	private LocalDateTime endingTime;
	@ManyToOne
	@NotNull
	private SystemUser owner;

	/**
	 * @deprecated
	 */
	public Ellection() {

	}

	public Ellection(String name,LocalDateTime endingTime,SystemUser owner) {
		super();
		this.name = name;
		this.endingTime = endingTime;
		this.owner = owner;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getId() {
		return id;
	}

	public boolean isOwnedByUser(SystemUser possibleOwner) {
		return owner.equals(possibleOwner);
	}

}
