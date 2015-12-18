package com.diez.andres.youtubevideo;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by HectorAndres on 12/16/2015.
 */
public class VideoFragment extends Fragment {


    VideoView videoview;
    public VideoFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.videofragment, container, false);

        videoview= (VideoView) view.findViewById(R.id.videoView);
        videoview.setVideoPath("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        if (savedInstanceState != null) {
            videoview.seekTo(savedInstanceState.getInt("vi"));

        }

        MediaController mediaController = new MediaController(this.getActivity());
        mediaController.setAnchorView(videoview);
        videoview.setMediaController(mediaController);
        videoview.start();


        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int orientation=this.getResources().getConfiguration().orientation;
        if(orientation== Configuration.ORIENTATION_LANDSCAPE){
            getView().getLayoutParams().height= ViewGroup.LayoutParams.MATCH_PARENT;
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt("vi", videoview.getCurrentPosition());

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }



}
