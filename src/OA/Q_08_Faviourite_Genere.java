package OA;


import java.util.*;

/**
 * Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.
 * Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values.
 * The song can only belong to only one genre.
 * The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s).
 * Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs
 * per each of the genres.
 * --------------------------------
 * Example 1:
 * Input:
 * userSongs = {
 * "David": ["song1", "song2", "song3", "song4", "song8"],
 * "Emma":  ["song5", "song6", "song7"]
 * },
 * songGenres = {
 * "Rock":    ["song1", "song3"],
 * "Dubstep": ["song7"],
 * "Techno":  ["song2", "song4"],
 * "Pop":     ["song5", "song6"],
 * "Jazz":    ["song8", "song9"]
 * }
 * Output: {
 * "David": ["Rock", "Techno"],
 * "Emma":  ["Pop"]
 * }
 * Explanation:
 * David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
 * Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
 */
public class Q_08_Faviourite_Genere {


    public Map<String, List<String>> getFaviouriteGenere(Map<String, List<String>> userSongs,
                                                         Map<String, List<String>> songGenres) {


        Map<String, List<String>> result = new HashMap<>();

        //store song genere in one map
        Map<String, String> songType = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : songGenres.entrySet()) {
            String genre = entry.getKey();
            for (String songName : entry.getValue()) {
                songType.put(songName, genre);
            }
        }


        for (Map.Entry<String, List<String>> userSong : userSongs.entrySet()) {

            final String user = userSong.getKey();
            TreeMap<String, Integer> mySongs = new TreeMap<>();
            for (String song : userSong.getValue()) {
                String currentGenre = songType.get(song);
                mySongs.put(currentGenre, mySongs.getOrDefault(currentGenre, 0) + 1);
            }

            int max = mySongs.lastEntry().getValue();
            List<String> myFavGenre = new ArrayList<>();
            for (Map.Entry<String, Integer> song : mySongs.entrySet()) {
                if (song.getValue() == max) {
                    myFavGenre.add(song.getKey());
                }
            }
            result.put(user, myFavGenre);
        }

        return result;
    }


    public static void main(String[] args) {

    }

}
