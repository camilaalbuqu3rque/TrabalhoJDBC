package entities;

import java.sql.Date;
import java.time.LocalDate;

public class Aluno {

	private int id;
	private String nome;
	private String sexo;
	private Date dt_nasc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(Date date) {
		this.dt_nasc = date;
	}
	public void setDt_nasc(LocalDate localDate) {
		// TODO Auto-generated method stub
		
	}
	
	
}