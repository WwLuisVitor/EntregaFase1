package AulaDia8823;

import java.io.*;
import java.util.Properties;


public class PersistenciaPropriedades {


	public static void main(String[] args) {
		Properties propriedades = new Properties();
		propriedades.setProperty("usuario", "joao");
		propriedades.setProperty("senha", "secreta");
		
		try {
			FileOutputStream arquivo = new FileOutputStream("config.properties");
			propriedades.store(arquivo, "Configurações de usuário");
			
			arquivo.close();
			System.out.println("Propriedades gravadas com sucesso!");
		} catch (IOException e) {
			System.err.println("Erro ao gravar propriedades: " + e.getMessage());
		}


	}


}
