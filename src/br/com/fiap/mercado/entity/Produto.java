package br.com.fiap.mercado.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.text.SimpleAttributeSet;

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private float valor;
	private Calendar dataValidade;
	
	public Produto (int codigo, String nome, float valor, Calendar dataValidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.dataValidade = dataValidade;
	}

	
	public Produto (){}


	public int getCodigo() {
		return codigo;
	}


	public String getNome() {
		return nome;
	}


	public float getValor() {
		return valor;
	}


	public Calendar getDataValidade() {
		return dataValidade;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}


	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	};
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Produto [codigo="+codigo+", nome="+nome+", valor="+valor+", dataValidade="+sdf.format(dataValidade.getTime())+"]";
	}
	
}
