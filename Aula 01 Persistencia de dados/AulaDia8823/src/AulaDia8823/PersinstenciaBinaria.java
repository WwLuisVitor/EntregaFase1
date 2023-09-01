package AulaDia8823;

import java.io.*;
public class PersinstenciaBinaria {
	public static void main(String[] args) {
	Pessoa pessoa = new Pessoa("João",30);
	
	try {
		FileOutputStream arquivo = new FileOutputStream("dados.bin");
		ObjectOutputStream escritor = new ObjectOutputStream(arquivo);
		
		escritor.writeObject(pessoa);
		
		escritor.close();
		arquivo.close();
		System.out.println("Objeto gravado com sucesso!");
		
	}	catch (IOException e) {
		System.err.println("Erro ao gravar objeto: " + e.getMessage());
	}
	}
}
class Pessoa implements Serializable{
	String nome;
	int idade;
	
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade=idade;
	}
}