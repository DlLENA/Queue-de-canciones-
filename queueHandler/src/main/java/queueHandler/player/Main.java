package queueHandler.player;

import queueHandler.models.Song;

public class Main {
public static void main(String[] args) {
SpotifyPlayer player = new SpotifyPlayer();

    player.addSong(new Song("Normal 1", "Artista A", 6, 2));
    player.addSong(new Song("Normal 2", "Artista B", 5, 2));
    
    player.addSong(new Song("VIP 1", "Laufey", 7, 1));
    player.addSong(new Song("VIP 2", "The marias", 5, 1));
    
    player.addSong(new Song("VIP 3", "Suicide", 4, 1));
    player.addSong(new Song("VIP 4", "Lana Del Rey", 3, 1));
    
    player.playAll();
 }
}