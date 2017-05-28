package com.example.android.miwok;

import android.support.annotation.Nullable;

/**
 * Created by if on 22/05/17.
 */

public class Word
{
    private String mDefaultTranslation, mMiwokTranslation;

    private Integer mImageResourceId;

    private Integer mAudioResourceId;

    public Word(String mDefaultTranslation, String mMiwokTranslation, @Nullable Integer imageResourceId, @Nullable Integer audioResourceId)
    {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = imageResourceId;
        this.mAudioResourceId = audioResourceId;
    }

    public String getmMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public String getmDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public Integer getmImageResourceId()
    {
        return mImageResourceId;
    }

    public Integer getmAudioResourceId()
    {
        return mAudioResourceId;
    }
}
