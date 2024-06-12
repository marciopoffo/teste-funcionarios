package br.com.teste.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }



    public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public LocalDate getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	@Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Nome: " + nome + " - Data de Nascimento: " + dataNascimento.format(formatter);
    }
}
