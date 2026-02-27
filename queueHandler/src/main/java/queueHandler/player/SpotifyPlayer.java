package queueHandler.player;

import umg.edu.gt.data_structure.queue.manual.MyQueue;
import queueHandler.models.Song;

public class SpotifyPlayer {
private MyQueue<Song> vipQueue;
private MyQueue<Song> normalQueue;
private int totalTimePlayed;

public SpotifyPlayer() {
    vipQueue = new MyQueue<Song>();
    normalQueue = new MyQueue<Song>();
    totalTimePlayed = 0;
}

public void addSong(Song song) {
    if (song.getPriority() == 1) {
        vipQueue.enqueue(song);
    } else {
        normalQueue.enqueue(song);
    }
}

public void playAll() {
    System.out.println("[LOG] Starting playlist...");

    while (!vipQueue.isEmpty() || !normalQueue.isEmpty()) {
        Song current;
        
        if (!vipQueue.isEmpty()) {
            current = vipQueue.dequeue();
        } else {
            current = normalQueue.dequeue();
        }

        System.out.println("\n[LOG] Now playing: " + current.getTitle() + " - " + current.getArtist() + " (" + current.getDuration() + "s)");

        for (int i = 1; i <= current.getDuration(); i++) {
            
            int progress = (int) (((double) i / current.getDuration()) * 10);
            StringBuilder bar = new StringBuilder("[");
            for (int j = 0; j < 10; j++) {
                if (j < progress) bar.append("#");
                else bar.append("-");
            }
            bar.append("]");

            System.out.println("[LOG] Playing: " + current.getTitle() + " " + bar.toString() + " " + i + "s / " + current.getDuration() + "s");

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Error en la reproduccion.");
            }
        }
        
        totalTimePlayed += current.getDuration();
        System.out.println("[LOG] Finished: " + current.getTitle());
    }

    System.out.println("\n[LOG] Playlist finished.");
    System.out.println("[LOG] Tiempo total acumulado reproducido: " + totalTimePlayed + " segundos.");
}
}