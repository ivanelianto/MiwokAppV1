package com.example.android.miwok;

import android.app.Service;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by if on 22/05/17.
 */

public class MediaPlayerHandler
{
    private Context mContext;

    private int mAudioResourceId;

    private static MediaPlayer mediaPlayer = new MediaPlayer();

    private AudioManager audioManager;
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
        @Override
        public void onAudioFocusChange(int focusChange)
        {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS
                    || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT
                    || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                releaseAudioResource();
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN)
            {
                mediaPlayer.start();
            }
        }
    };

    public MediaPlayerHandler(Context context, int audioResourceId)
    {
        this.mContext = context;
        this.mAudioResourceId = audioResourceId;
        audioManager = (AudioManager) context.getSystemService(Service.AUDIO_SERVICE);
    }

    public void play()
    {
        int audioFocusAccess = audioManager.requestAudioFocus(
                audioFocusChangeListener,
                AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

        if (audioFocusAccess == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
        {
            releaseAudioResource();
            mediaPlayer = MediaPlayer.create(mContext, mAudioResourceId);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
                @Override
                public void onCompletion(MediaPlayer mp)
                {
                    releaseAudioResource();
                }
            });
        }
    }

    public void releaseAudioResource()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.release();
            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }
}
