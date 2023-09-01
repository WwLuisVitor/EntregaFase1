package aula.jdbc;

import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class InserirDados extends JFrame {
    private Connection con;
    private Statement st;

    public InserirDados() throws SQLException {
        String driver = "org.postgresql.Driver";
        String sUsuario = "postgres";
        String sSenha = "131964A@";
        String sFonte = "jdbc:postgresql://localhost:5433/ListaFilmes";
        String arquivoCSV = "C:\\Users\\luans\\eclipse-workspace\\Aula04\\filmes_em_cartaz.csv";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(sFonte, sUsuario, sSenha);
            JOptionPane.showMessageDialog(this, "Banco conectado com sucesso!", "Mensagem", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException eSQL) {
            eSQL.printStackTrace();
            JOptionPane.showMessageDialog(this, "Falha na conexão com o banco!\n" + "Mensagem: " + eSQL.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Falha na conexão com o banco!\n" + "Mensagem: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        try {
            st = con.createStatement();

            BufferedReader br = new BufferedReader(new FileReader(arquivoCSV));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6) {
                    String titulo = data[0].trim();
                    String ano = data[1].trim();
                    String classificacao = data[2].trim();
                    String classificacao2 = data[3].trim();
                    String classificacao3 = data[4].trim();
                    String classificacao4 = data[5].trim();
                    
                    String insertQuery = "INSERT INTO Filmes (Titulo, Ano, Classificacao, Classificacao2, Classificacao3, Classificacao4) " +
                                        "VALUES ('" + titulo + "', '" + ano + "', '" + classificacao + "', '" + classificacao2 + "', '" + classificacao3 + "', '" + classificacao4 + "')";
                    st.executeUpdate(insertQuery);
                } else {
                    System.out.println("Linha do arquivo CSV incompleta: " + line);
                }
            }
            br.close();
        } catch (SQLException eSQL) {
            JOptionPane.showMessageDialog(this, "Erro na expressão do INSERT!\n" + "Mensagem: " + eSQL.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(2);
        }

        try {
            st.close();
            con.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(2);
        }

        Container P = getContentPane();
        P.setLayout(new FlowLayout());
        JLabel mensagem = new JLabel("Você acabou de testar um exemplo usando INSERT!");
        P.add(mensagem);
    }

    public static void main(String args[]) throws SQLException {
        InserirDados ex = new InserirDados();
        ex.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ex.setVisible(true);
        ex.setTitle("USANDO INSERT");
        ex.setSize(400, 200);
    }
}
