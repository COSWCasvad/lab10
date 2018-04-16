package co.edu.pdam.eci.persistenceapiintegration.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import co.edu.pdam.eci.persistenceapiintegration.R;

/**
 * Created by carlos.sanchez-v on 4/15/2018.
 */

public class TeamsAdapter extends RecyclerView.Adapter {

    private List teams;

    public TeamsAdapter(List teams){
        this.teams = teams;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ViewHolder{
        String name;
        String shortName;
        String image;

        public ViewHolder() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
