package entity;

public class Song {

    private String albumName;
    private String albumImageLink;
    private String castName;
    private String musicComposer;
    private String songName;
    private String songDownloadLink;

    public Song() {
    }

    public Song(
            String albumName,
            String albumImageLink,
            String castName,
            String musicComposer,
            String songName,
            String songDownloadLink) {

        this.albumName = albumName;
        this.albumImageLink = albumImageLink;
        this.castName = castName;
        this.musicComposer = musicComposer;
        this.songName = songName;
        this.songDownloadLink = songDownloadLink;
    }

    // GETTERS

    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumImageLink() {
        return albumImageLink;
    }

    public String getCastName() {
        return castName;
    }

    public String getMusicComposer() {
        return musicComposer;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongDownloadLink() {
        return songDownloadLink;
    }

    // SETTERS

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setAlbumImageLink(String albumImageLink) {
        this.albumImageLink = albumImageLink;
    }

    public void setCastName(String castName) {
        this.castName = castName;
    }

    public void setMusicComposer(String musicComposer) {
        this.musicComposer = musicComposer;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setSongDownloadLink(String songDownloadLink) {
        this.songDownloadLink = songDownloadLink;
    }
}
