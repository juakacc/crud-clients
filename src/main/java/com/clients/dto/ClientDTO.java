package com.clients.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClientDTO {

	private Long id;
	private String nome;
	private String cpf;
	private Date dataNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(dataNascimento);
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		Calendar bor = Calendar.getInstance();
		bor.setTime(dataNascimento);
		Calendar today = Calendar.getInstance();
		
		int age = today.get(Calendar.YEAR) - bor.get(Calendar.YEAR);
		
		if (today.get(Calendar.DAY_OF_YEAR) < bor.get(Calendar.DAY_OF_YEAR)) age--;
		return age;
	}
}
