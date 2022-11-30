package List;

public class Pessoa implements Comparable<Pessoa>{
	
	private String nome;
	private int idade;
	
	public Pessoa(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public boolean equals(Pessoa v) {
		if (v == null) return false;
		return ((this.nome.equals(v.nome)
				&& (this.idade == v.idade)));
				//&& (this.fabricante).equals(v.fabricante));
	}

	@Override
	public int compareTo(Pessoa p) {
		
		return this.idade - p.getIdade();
		//return p.getIdade() - this.idade;
		//return p.getNome().compareTo(this.nome);
	}

}
