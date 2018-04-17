package br.com.ideiasaleatorias.eleicaoonline.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Voter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(unique=true)	
	private String number;
	
	@ManyToOne
	@NotNull
	private Ellection ellection;
	
	private LocalDateTime approvedInstant;

	private boolean generatedTicket;
	
	/**
	 * @deprecated
	 */
	public Voter() {

	}

	public Voter(@NotBlank String number,Ellection ellection) {
		super();
		this.number = number;
		this.ellection = ellection;
	}
	
	public void approve(){
		if(approvedInstant != null){
			throw new IllegalStateException("Esse eleitor já foi aprovado para está eleição "+approvedInstant);
		}
		
		this.approvedInstant = LocalDateTime.now();		
	}
	
	public String getNumber() {
		return number;
	}
	
	public boolean isApproved(){
		return this.approvedInstant != null;
	}
	
	public Integer getId() {
		return id;
	}

	public Ellection getEllection() {
		return ellection;
	}

	public VoteTicket generateTicket() {
		if(this.generatedTicket || !this.isApproved()) {
			throw new IllegalStateException("ticket não pode ser gerado");
		}
		this.generatedTicket = true;
		return new VoteTicket(); 
	}
	
	public boolean isGeneratedTicket() {
		return generatedTicket;
	}
	
	
}
