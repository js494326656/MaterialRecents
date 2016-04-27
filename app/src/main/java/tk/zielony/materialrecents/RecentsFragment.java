package tk.zielony.materialrecents;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jsware.recentlist.RecentsAdapter;
import com.jsware.recentlist.RecentsList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Marcin on 2015-07-08.
 */
public class RecentsFragment extends Fragment {

    static RecentsFragment newInstance() {
        RecentsFragment f = new RecentsFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.materialrecents_activity_recents, container, false);

        List<ImageHolder> data = new ArrayList<>();
        for (int i=0;i<5;i++) {
            ImageHolder holder = new ImageHolder();
            holder.name = "Item" + i;
            holder.resId = R.drawable.mazda;
            data.add(holder);
        }


        RecentsList recents = (RecentsList) v.findViewById(R.id.recents);
        recents.setAdapter(new RecentsAdapter<ImageHolder>(data) {

            @Override
            public View bindHolder(int position, ImageHolder item) {
                View container = LayoutInflater.from(getActivity()).inflate(R.layout.item_recent, null);
                ImageView icon = (ImageView) container.findViewById(R.id.materialrecents_recentIcon);
                icon.setImageResource(R.mipmap.ic_launcher);
                TextView title = (TextView) container.findViewById(R.id.materialrecents_recentTitle);
                title.setText(item.name);
                View imageBg = container.findViewById(R.id.image_body);
                imageBg.setBackgroundResource(item.resId);
                return container;
            }
        });

        recents.setOnItemClickListener(new RecentsList.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Toast.makeText(view.getContext(), "Card " + i + " clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    public class ImageHolder{
        public String name;
        public int resId;
    }

}

