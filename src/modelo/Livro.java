package modelo;

import java.util.List;

public class Livro {
	private long id;
	private String titulo;
	private String autor;
	private int ano;
	private String codigo;
	private String editora;
	private List<String> assuntos;
	
	public Livro(long id, String titulo, String autor, int ano, String codigo, String editora) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.codigo = codigo;
		this.editora = editora;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public List<String> getAssuntos() {
		return assuntos;
	}
	
	public void setAssuntos(List<String> assuntos) {
		this.assuntos = assuntos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}