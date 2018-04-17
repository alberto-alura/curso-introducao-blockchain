package br.com.ideiasaleatorias.eleicaoonline.security;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;

public class SimpleUserForm {

	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Length(min = 6, message = "Sua senha deve ter no mínimo 6 caracteres")
	private String rawPassword;
	private String shareCode;
	
	public String getShareCode() {
		return shareCode;
	}

	public void setShareCode(String shareCode) {
		this.shareCode = shareCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (StringUtils.hasText(email)) {
			this.email = email.toLowerCase();
		} else {
			this.email = email;
		}
	}

	public String getRawPassword() {
		return rawPassword;
	}

	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}

	public SystemUser build(Role... roles) {
		Password password = Password.buildWithRawText(rawPassword);
		return new SystemUser(name, email, password,roles);
	}

	public boolean hasShareCode() {
		return StringUtils.hasText(shareCode);
	}

}
