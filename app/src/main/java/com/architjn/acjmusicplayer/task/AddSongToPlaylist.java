package com.architjn.acjmusicplayer.task;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.architjn.acjmusicplayer.service.MusicService;

import java.util.ArrayList;

/**
 * Created by architjn on 09/07/15.
 */
public class AddSongToPlaylist extends AsyncTask<Void, Void, Void> {

    private Context context;
    private ArrayList<String> songName, songArtist, songPath,
            songAlbum, songId, songAlbumId;

    public AddSongToPlaylist(Context context, ArrayList<String> songName, ArrayList<String> songArtist, ArrayList<String> songPath,
                             ArrayList<String> songAlbum, ArrayList<String> songId, ArrayList<String> songAlbumId) {
        this.context = context;
        this.songName = songName;
        this.songAlbum = songAlbum;
        this.songArtist = songArtist;
        this.songPath = songPath;
        this.songId = songId;
        this.songAlbumId = songAlbumId;
    }

    @Override
    protected Void doInBackground(Void... params) {
        Intent musicPlayer = new Intent();
        for (int i = 0; i < songId.size(); i++) {
            musicPlayer.setAction(MusicService.ACTION_ADD_SONG_MULTI);
            musicPlayer.putStringArrayListExtra("songId", songId);
            musicPlayer.putStringArrayListExtra("songName", songName);
            musicPlayer.putStringArrayListExtra("songArtist", songArtist);
            musicPlayer.putStringArrayListExtra("songPath", songPath);
            musicPlayer.putStringArrayListExtra("songAlbum", songAlbum);
            musicPlayer.putStringArrayListExtra("songAlbumId", songAlbumId);
        }
        context.sendBroadcast(musicPlayer);
        return null;
    }
}
