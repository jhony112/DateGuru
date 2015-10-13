package models;

import android.content.Context;
import android.content.res.TypedArray;
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
public class GiftListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final TypedArray img;
    private final int layoutId;
    private final int ArrayLength;

    private final String[] names;


    static class ViewHolder {
        public TextView text;
        public ImageView image;

    }

    public GiftListAdapter(Context context, String[] names, TypedArray images, int layoutId,int ArrayLength) {
        super(context, R.layout.row_misc, names);
        this.context = context;
        this.names = names;
        this.img = images;
        this.ArrayLength = ArrayLength;

        this.layoutId = layoutId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());

            rowView = inflater.inflate(R.layout.row_misc, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.txtMsg);
            viewHolder.image = (ImageView) rowView
                    .findViewById(R.id.ivImg);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        String s = names[position];

        holder.text.setText("\u0009" + s); //tab char

        holder.image.setImageDrawable(img.getDrawable(ArrayLength+position+1));


        return rowView;
    }
}