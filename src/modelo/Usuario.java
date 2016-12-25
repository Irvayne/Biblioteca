package modelo;

public class Usuario {
	private long id;
	private String nome;
	private String cpf;
	private String endereço;
	private String telefone;
	
	public Usuario(long id, String nome, String cpf, String endereço, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereço = endereço;
		this.telefone = telefone;
	}

	public Usuario(String nome, String cpf, String endereço, String telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereço = endereço;
		this.telefone = telefone;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
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
	
	public String getEndereço() {
		return endereço;
	}
	
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}