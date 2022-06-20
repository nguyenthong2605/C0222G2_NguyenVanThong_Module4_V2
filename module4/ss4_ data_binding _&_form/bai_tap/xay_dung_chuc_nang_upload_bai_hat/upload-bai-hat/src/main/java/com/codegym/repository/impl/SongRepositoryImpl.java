package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.SongRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SongRepositoryImpl implements SongRepository {
    private static List<Song> songList = new ArrayList<>();

    static {
        songList.add(new Song("thong", "thong", "pop", "https://james.codegym.vn/mod/assign/view.php?id=12657"));
        songList.add(new Song("tam", "khang", "rock", "https://james.codegym.vn/mod/assign/view.php?id=12657"));
    }

    @Override
    public List<Song> getAllSong() {
        List<Song> songs = songList;
        return songs;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }
}
