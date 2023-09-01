package AulaDia8823;
import java.io.*;
public class Persistenciatexto {
	public static void main(String[] args) {
		String conteudo = "Este é um exemplo de persintencia de arquivo de texto.";
		try {
			FileWriter escritor = new FileWriter("arquivo.txt");
			escritor.write(conteudo);
			escritor.close();
			System.out.println("Dados gravados com sucesso!");
			
		} catch(IOException e) {
			System.err.print("Erro ao escrever no arquivo" + e.getMessage());
		}
	}
}
