package database;

import entity.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SongDAO {

    public static void insertSong(Song song) {

        try {

            //Connection conn = DatabaseUtil.getConnection();
            Connection conn =
                    DatabaseUtil
                            .getDataseBaseConnectionPool()
                            .getConnection();

            String query =
                    "INSERT INTO songs " +
                            "(album_name, album_image_link, cast_name, music_composer, song_name, song_download_link) " +
                            "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, song.getAlbumName());
            ps.setString(2, song.getAlbumImageLink());
            ps.setString(3, song.getCastName());
            ps.setString(4, song.getMusicComposer());
            ps.setString(5, song.getSongName());
            ps.setString(6, song.getSongDownloadLink());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
