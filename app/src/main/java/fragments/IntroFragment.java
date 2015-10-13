package fragments;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jhony.dateguru.R;

import java.util.ArrayList;
import java.util.List;

import models.ListItem;
import models.ListViewAdapter;
import models.pickedValue;

/**

 */
public class IntroFragment extends ListFragment {
    private List<ListItem> mItems;        // ListView items list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize the items list
        mItems = new ArrayList<ListItem>();
        populate(pickedValue.getValue(), mItems);
        // initialize and set the list adapter
        setListAdapter(new ListViewAdapter(getActivity(), mItems));
    }

  public  void populate(int index, List<ListItem> item) {
        if (index == 1 || index == 10 || index == 19 || index == 28) {

            Resources resources = getResources();
            String[] factfiles = resources.getStringArray(R.array.SunFacts);
            String[] factnames = resources.getStringArray(R.array.Sunfactsname);
            int lngth = factfiles.length - 1;
            TypedArray icons = resources.obtainTypedArray(R.array.sunIcons);
            Drawable drawable = icons.getDrawable(factnames.length + 1);
            for (int i = 0; i <= lngth; i++) {
                if (i == 0) {
                    item.add(new ListItem(icons.getDrawable(i), "", ""));
                } else {
                    item.add(new ListItem(icons.getDrawable(i), factnames[i], factfiles[i]));
                }

            }

        }
        else if(index ==2 || index == 11 || index == 20 || index == 29){
            Resources resources = getResources();
            String[] factfiles = resources.getStringArray(R.array.mooonFacts);
            String[] factnames = resources.getStringArray(R.array.moonfactsname);
            int lngth = factfiles.length - 1;
            TypedArray icons = resources.obtainTypedArray(R.array.moonIcons);
            Drawable drawable = icons.getDrawable(factnames.length + 1);
            for (int i = 0; i <= lngth; i++) {
                if (i == 0) {
                    item.add(new ListItem(icons.getDrawable(i), "", ""));
                } else {
                    item.add(new ListItem(icons.getDrawable(i), factnames[i], factfiles[i]));
                }

            }

        }
        else if(index ==3 || index == 12 || index == 21 || index == 30){
            Resources resources = getResources();
            String[] factfiles = resources.getStringArray(R.array.jupiterFacts);
            String[] factnames = resources.getStringArray(R.array.jupiterfactsname);
            int lngth = factfiles.length - 1;
            TypedArray icons = resources.obtainTypedArray(R.array.jupiterIcons);
            Drawable drawable = icons.getDrawable(factnames.length + 1);
            for (int i = 0; i <= lngth; i++) {
                if (i == 0) {
                    item.add(new ListItem(icons.getDrawable(i), "", ""));
                } else {
                    item.add(new ListItem(icons.getDrawable(i), factnames[i], factfiles[i]));
                }

            }

        }
        else if(index ==4 || index == 13 || index == 22 || index == 31){
            Resources resources = getResources();
            String[] factfiles = resources.getStringArray(R.array.UraFacts);
            String[] factnames = resources.getStringArray(R.array.Urafactsname);
            int lngth = factfiles.length - 1;
            TypedArray icons = resources.obtainTypedArray(R.array.UraIcons);
            Drawable drawable = icons.getDrawable(factnames.length + 1);
            for (int i = 0; i <= lngth; i++) {
                if (i == 0) {
                    item.add(new ListItem(icons.getDrawable(i), "", ""));
                } else {
                    item.add(new ListItem(icons.getDrawable(i), factnames[i], factfiles[i]));
                }

            }
        }
        else if(index ==5 || index == 14 || index == 23 ){
            Resources resources = getResources();
            String[] factfiles = resources.getStringArray(R.array.MercuryFacts);
            String[] factnames = resources.getStringArray(R.array.Mercuryfactsname);
            int lngth = factfiles.length - 1;
            TypedArray icons = resources.obtainTypedArray(R.array.MercuryIcons);
            Drawable drawable = icons.getDrawable(factnames.length + 1);
            for (int i = 0; i <= lngth; i++) {
                if (i == 0) {
                    item.add(new ListItem(icons.getDrawable(i), "", ""));
                } else {
                    item.add(new ListItem(icons.getDrawable(i), factnames[i], factfiles[i]));
                }

            }
        }
        else if(index ==6|| index == 15 || index == 24 ){
            Resources resources = getResources();
            String[] factfiles = resources.getStringArray(R.array.VenFacts);
            String[] factnames = resources.getStringArray(R.array.Vensname);
            int lngth = factfiles.length - 1;
            TypedArray icons = resources.obtainTypedArray(R.array.VenIcons);
            Drawable drawable = icons.getDrawable(factnames.length + 1);
            for (int i = 0; i <= lngth; i++) {
                if (i == 0) {
                    item.add(new ListItem(icons.getDrawable(i), "", ""));
                } else {
                    item.add(new ListItem(icons.getDrawable(i), factnames[i], factfiles[i]));
                }

            }
        }
        else if(index ==7 || index == 16 || index == 25 ){
            Resources resources = getResources();
            String[] factfiles = resources.getStringArray(R.array.Neptunefacts);
            String[] factnames = resources.getStringArray(R.array.NeptuneName);
            int lngth = factfiles.length - 1;
            TypedArray icons = resources.obtainTypedArray(R.array.NeptuneIcons);
            Drawable drawable = icons.getDrawable(factnames.length + 1);
            for (int i = 0; i <= lngth; i++) {
                if (i == 0) {
                    item.add(new ListItem(icons.getDrawable(i), "", ""));
                } else {
                    item.add(new ListItem(icons.getDrawable(i), factnames[i], factfiles[i]));
                }

            }
        }
        else if(index ==8 || index == 17 || index == 26 ){
            Resources resources = getResources();
            String[] factfiles = resources.getStringArray(R.array.Saturnfacts);
            String[] factnames = resources.getStringArray(R.array.SaturnName);
            int lngth = factfiles.length - 1;
            TypedArray icons = resources.obtainTypedArray(R.array.SaturnIcons);
            Drawable drawable = icons.getDrawable(factnames.length + 1);
            for (int i = 0; i <= lngth; i++) {
                if (i == 0) {
                    item.add(new ListItem(icons.getDrawable(i), "", ""));
                } else {
                    item.add(new ListItem(icons.getDrawable(i), factnames[i], factfiles[i]));
                }

            }
        }
        else if(index ==9 || index == 18 || index == 27 ){
            Resources resources = getResources();
            String[] factfiles = resources.getStringArray(R.array.Marsfacts);
            String[] factnames = resources.getStringArray(R.array.MarsName);
            int lngth = factfiles.length - 1;
            TypedArray icons = resources.obtainTypedArray(R.array.MarsIcons);
            Drawable drawable = icons.getDrawable(factnames.length + 1);
            for (int i = 0; i <= lngth; i++) {
                if (i == 0) {
                    item.add(new ListItem(icons.getDrawable(i), "", ""));
                } else {
                    item.add(new ListItem(icons.getDrawable(i), factnames[i], factfiles[i]));
                }

            }
        }

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item
        ListItem item = mItems.get(position);

        // do something
       // Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
    }

}