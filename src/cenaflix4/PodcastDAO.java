/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cenaflix4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Rafaella
 */
public class PodcastDAO {
    

    private final String url = "jdbc:mysql://localhost:3306/Cenaflix2"; // Nome correto do BD
    private final String user = "root";
    private final String password = "Bonis@00";

    public List<String> listarPodcasts() throws SQLException {
        String query = "SELECT * FROM podcasts"; // Nome correto da tabela
        List<String> podcasts = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String produtor = rs.getString("produtor");
                String nomeEpisodio = rs.getString("nome_episodio");
                int numeroEpisodio = rs.getInt("numero_episodio");
                Time duracao = rs.getTime("duracao");
                String urlRepositorio = rs.getString("url_repositorio");

                podcasts.add("ID: " + id + ", Produtor: " + produtor + 
                             ", Episódio: " + nomeEpisodio + 
                             " (Nº " + numeroEpisodio + "), Duração: " + duracao +
                             ", URL: " + urlRepositorio);
            }
        }
        return podcasts;
    }
}
