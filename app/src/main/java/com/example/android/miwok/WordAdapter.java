package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by if on 22/05/17.
 */

public class WordAdapter extends ArrayAdapter<Word>
{
    private int mColorResourceId;

    public WordAdapter(@NonNull Context context, ArrayList<Word> resource, int backgroundColor)
    {
        super(context, 0, resource);
        this.mColorResourceId = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.model, parent, false);
        }

        final Word word = getItem(position);

        TextView miwokTextView = (TextView) convertView.findViewById(R.id.tvMiwok);
        miwokTextView.setText(word.getmMiwokTranslation());

        TextView englishTextView = (TextView) convertView.findViewById(R.id.tvEnglish);
        englishTextView.setText(word.getmDefaultTranslation());

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgModel);
        if (word.getmImageResourceId() == null)
        {
            imageView.setVisibility(View.GONE);
        }
        else
        {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(word.getmImageResourceId());
        }

        View text_container = convertView.findViewById(R.id.text_container);
        text_container.setBackgroundColor(ContextCompat.getColor(getContext(), mColorResourceId));

        return convertView;
    }
}

/*
    TODO (1) Add Images To All Activity, Download The Images First From Udacity
    TODO (2) Download The Audio Files Too
* */