package AulaDia8823;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
public class PersistenciaCsv {

    public static void main(String[] args) {
        Properties propriedades = new Properties();
        propriedades.setProperty("usuario", "joao");
        propriedades.setProperty("senha", "secreta");

        try {
            FileWriter arquivo = new FileWriter("config.csv");
            
            for (String chave : propriedades.stringPropertyNames()) {
                String linha = chave + "," + propriedades.getProperty(chave) + "\n";
                arquivo.write(linha);
            }

            arquivo.close();
            System.out.println("Propriedades gravadas como CSV com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao gravar propriedades como CSV: " + e.getMessage());
        }
    }
}
