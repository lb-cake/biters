package shutterstack.biters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@author will
 *<p>This class calculates the word frequency of a given song.</p>
 *
 */
public class WordFrequency {
    final static Logger logger = LoggerFactory.getLogger(WordFrequency.class);

    public ConcurrentHashMap<String, Integer> getSongInHashMap(List<String> song) {
        logger.info("Starting Concurrent Hashing");
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        for (String s: song) {
            map.compute(s, (k, v) -> v == null ? 1 : v + 1);
        }

        return map;
    }


}
