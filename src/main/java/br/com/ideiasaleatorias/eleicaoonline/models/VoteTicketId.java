package br.com.ideiasaleatorias.eleicaoonline.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.util.Assert;

@Entity
public class VoteTicketId {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public String getId(){
		Assert.notNull(id,"Deveria ter id aqui");
		return Integer.toHexString(id * 25437);
	}
	
}
