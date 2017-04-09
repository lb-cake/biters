package shutterstack.biters;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by will on 4/8/17.
 */
public class DetermineDistance {
    final static Logger logger = LoggerFactory.getLogger(DetermineDistance.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Artist 1: ");
        String artist1 = sc.nextLine();
        System.out.print("Song 1: ");
        String song1 = sc.nextLine();
        System.out.print("Artist 2: ");
        String artist2 = sc.nextLine();
        System.out.print("Song 2: ");
        String song2 = sc.nextLine();

        try {
            System.out.println("PRINTING JaroWinkler COMPARISONS");
            List<String> songList1 = LyricsGatherer.getSongLyrics(artist1, song1);
            List<String> songList2 = LyricsGatherer.getSongLyrics(artist2,song2);
            System.out.println(StringUtils.getJaroWinklerDistance(songList1.toString(), songList2.toString()) * 100 + "% Similar");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Artist/Song may not exist");
        }

    }
}
