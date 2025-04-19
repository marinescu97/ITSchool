package session_16_Hash.Homework;

import java.util.Objects;

public class Song {
    private String title;
    private String artist;
    private double length;

    public Song(String title, String artist, double length) {
        this.title = title;
        this.artist = artist;
        this.length = length;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;
        return Objects.equals(title, song.title) && Objects.equals(artist, song.artist);
    }

    @Override
    public int hashCode(){
        return Objects.hash(title, artist);
    }
}

class SongTest{
    public static void main(String[] args) {
        Song song1 = new Song("Title1", "Artist1", 2.5);
        Song song2 = new Song("Title1", "Artist2", 2.5);
        Song song3 = new Song("Title1", "Artist1", 2.6);

        System.out.println("song1 equals to song2? " + song1.equals(song2));
        System.out.println("song1 equals to song3? " + song1.equals(song3));

        System.out.println("song1 hashcode: " + song1.hashCode());
        System.out.println("song2 hashcode: " + song2.hashCode());
        System.out.println("song3 hashcode: " + song3.hashCode());
    }
}
