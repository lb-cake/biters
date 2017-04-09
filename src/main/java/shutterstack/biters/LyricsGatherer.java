package shutterstack.biters;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by will on 4/8/17.
 */
public class LyricsGatherer {

    private final static String songLyricsURL = "http://www.songlyrics.com";

    public static List<String> getSongLyrics(String artist, String songTitle) throws IOException {
        List<String> lyrics = new ArrayList<String>();

        Document document = Jsoup.connect(songLyricsURL + "/" + artist.replace(" ", "-").toLowerCase()
                + "/" + songTitle.replace(" ", "-").toLowerCase() + "-lyrics/").get();

        String title = document.title();
        System.out.println(title);
        Element p = document.select("p.songLyricsV14").get(0);

        for (Node e: p.childNodes()) {
            if (e instanceof TextNode) {
                lyrics.add(((TextNode) e).getWholeText());
            }
        }
        return lyrics;
    }

}
