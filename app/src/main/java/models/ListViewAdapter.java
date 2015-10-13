package models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jhony.dateguru.R;

import java.util.List;

/**
 * Created by jhony on 9/28/2015.
 */
public class ListViewAdapter extends ArrayAdapter<ListItem> {

    public ListViewAdapter(Context context, List<ListItem> items) {
        super(context, R.layout.row, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());

//            if(position==0){
//                // inflate the Home item layout
//                convertView = inflater.inflate(R.layout.row_large, parent, false);
//
//                // initialize the view holder
//                viewHolder = new ViewHolder();
//                viewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
//                viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
//                viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
//                convertView.setTag(viewHolder);
//            }

                // inflate the GridView item layout
                convertView = inflater.inflate(R.layout.row, parent, false);

                // initialize the view holder
                viewHolder = new ViewHolder();
                viewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
                viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
                viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
                convertView.setTag(viewHolder);



        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // update the item view
        ListItem item = getItem(position);
        if(item!=null){
            viewHolder.ivIcon.setImageDrawable(item.icon);
            viewHolder.tvTitle.setText(item.title);
            viewHolder.tvDescription.setText(item.description);
        }


        return convertView;
    }

    /**
     * The view holder design pattern prevents using findViewById()
     * repeatedly in the getView() method of the adapter.
     *
     * @see http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder
     */
    private static class ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvDescription;
    }
}