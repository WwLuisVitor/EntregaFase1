package com.unifacisa.Aula04;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Extrair {

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.adorocinema.com/filmes/numero-cinemas/").get();
            Elements movieElements = doc.select(".mdl");

            BufferedWriter writer = new BufferedWriter(new FileWriter("filmes_em_cartaz.csv"));
            writer.write("Título,Ano,Classificação 1,Classificação 2, Classificação 3, Classificação 4\n");

            for (Element movieElement : movieElements) {
                String titulo = movieElement.select(".meta-title").text();
                String ano = movieElement.select(".date").text();
                String rating = movieElement.select(".stareval-note").text();

                writer.write(titulo + "," + ano + ","   + rating + "\n");
            }

            writer.close();
            System.out.println("Informacoes dos filmes extraidas e salvas no arquivo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
