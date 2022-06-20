package com.codegym.repository;

import com.codegym.model.Song;

import java.util.List;


public interface SongRepository {
    List<Song> getAllSong();

    void save(Song song);
}
