package org.stream.tutorial.musicapptest;

import java.util.ArrayList;
import java.util.LinkedList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder>
{
    private ArrayList<Song> songs;
    private LayoutInflater songInf;

    //private final LinkedList<String> musicList;
    //private LayoutInflater mInflater;

    public SongAdapter(Context c, ArrayList<Song> theSongs) {
        songs=theSongs;
        songInf=LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public SongAdapter.SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = songInf.inflate(R.layout.song, parent, false);
        return new SongAdapter.SongViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.SongViewHolder holder, int position) {
        String currentTitle = songs.get(position).getTitle();
        String currentArtist = songs.get(position).getArtist();
        holder.songTitleView.setText(currentTitle);
        holder.songArtistView.setText(currentArtist);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public final TextView songTitleView;
        public final TextView songArtistView;
        final SongAdapter adapter;


        public SongViewHolder(View itemView, SongAdapter adapter) {
            super(itemView);
            songTitleView = itemView.findViewById(R.id.song_title);
            songArtistView = itemView.findViewById(R.id.song_artist);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int position = getLayoutPosition();
            // Use that to access the affected item in musicList.
            String element = songs.get(position).getTitle();

            // Change the word in the musicList.
//            songs.set(position, "Clicked! " + element);
//            // Notify the adapter, that the data has changed so it can
//            // update the RecyclerView to display the data.
//            adapter.notifyDataSetChanged();
        }
    }

//    @Override
//    public int getCount()
//    {
//        return songs.size();
//    }
//
//    @Override
//    public Object getItem(int arg0)
//    {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public long getItemId(int arg0)
//    {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        //map to song layout
//        LinearLayout songLay = (LinearLayout)songInf.inflate
//                (R.layout.song, parent, false);
//        //get title and artist views
//        TextView songView = (TextView)songLay.findViewById(R.id.song_title);
//        TextView artistView = (TextView)songLay.findViewById(R.id.song_artist);
//        //get song using position
//        Song currSong = songs.get(position);
//        //get title and artist strings
//        songView.setText(currSong.getTitle());
//        artistView.setText(currSong.getArtist());
//        //set position as tag
//        songLay.setTag(position);
//        return songLay;
//    }

}