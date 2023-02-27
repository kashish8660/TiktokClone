package com.example.mytiktok;


import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mytiktok.databinding.ActivityScrollUpBinding;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private ArrayList<Model> localDataSet= new ArrayList<>();
    Context context;
    boolean isPlaying=true;

    public CustomAdapter(ArrayList<Model> localDataSet, Context context) {
        this.localDataSet = localDataSet;
        this.context = context;
    }


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
//        private final TextView textView;
        ActivityScrollUpBinding binding;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            binding=ActivityScrollUpBinding.bind(view); //bind() takes a reference to the root view of the layout and returns an instance of the binding class, which contains references to all the views defined in that layout
//            textView = (TextView) view.findViewById(R.id.textView);
        }


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_scroll_up, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        viewHolder.getTextView().setText(localDataSet.get(position));
        viewHolder.binding.videoView.setVideoPath(localDataSet.get(position).getVideoUrl()); //needed 'viewHolder' to call 'binding' (as we defined binding under 'ViewHolder' class) and 'binding' called id of VideoView. Currently we using 'setVideoPath()' cuz we using video from drawable, if getting video from some server then use 'setVideoURI()'
        viewHolder.binding.textView.setText(localDataSet.get(position).getName());
        viewHolder.binding.profileImage.setImageResource(localDataSet.get(position).getProfile());
        viewHolder.binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                isPlaying=true;
            }
        });
        viewHolder.binding.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
                isPlaying=true;
            }
        });
        viewHolder.binding.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying){
                    viewHolder.binding.videoView.pause();
                    isPlaying=false;
                }
                else {
                    viewHolder.binding.videoView.resume();
                    isPlaying=true;
                }
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
