package models;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jhony.dateguru.R;

/**
 * Created by jhony on 9/29/2015.
 */
public class LargeListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final Drawable img;
    private final int layoutId;
    private final Drawable img2;
    private final String[] names;


    static class ViewHolder {
        public TextView text;
        public ImageView image;

    }

    public LargeListAdapter(Context context, String[] names, Drawable image, Drawable image2,int layoutId) {
        super(context, R.layout.row_large, names);
        this.context = context;
        this.names = names;
        this.img = image;
        this.img2 = image2;
        this.layoutId = layoutId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());

            rowView = inflater.inflate(layoutId, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.tvDescription);
            viewHolder.image = (ImageView) rowView
                    .findViewById(R.id.ivIcon);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        String s = names[position];

        holder.text.setText("\u0009" + s);

        holder.image.setImageDrawable(img);


        return rowView;
    }
}