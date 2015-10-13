package fragments;


import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jhony.dateguru.R;

import java.util.ArrayList;
import java.util.List;

import models.GiftListAdapter;
import models.LargeListAdapter;
import models.ListItem;
import models.ListViewAdapter;
import models.pickedValue;

/**
 * A simple {@link Fragment} subclass.
 */
public class GiftFragment extends Fragment {
    TextView txt_xter;
    ListView list;
    TypedArray icons;
    int ArrayLength=0;
    public GiftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_gift, null);
        Resources resources = getResources();

        // txt_xter = (TextView) view.findViewById(R.id.txt_xter);
        list = (ListView) view.findViewById(R.id.list);

        // txt_xter.setText(SetData(pickedValue.getValue()));
        String[] values = Split(SetData(pickedValue.getValue()));


        list.setAdapter(new GiftListAdapter(getContext(), values,icons, R.layout.row_misc,ArrayLength));
        return view;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        list.setDivider(null);
    }

    String[] Split(String msg) {
        String[] separated = msg.split("#");
        return separated;
    }

    String SetData(int index) {
        Resources resources = getResources();
        String[] data_array = null;
        String xter = "";
        if (index == 1 || index == 10 || index == 19 || index == 28) {
            data_array = resources.getStringArray(R.array.sun_array);
           int num = resources.getStringArray(R.array.Sunfactsname).length;
            xter = data_array[3];

            icons = resources.obtainTypedArray(R.array.sunIcons);
            ArrayLength=num;

        } else if (index == 2 || index == 11 || index == 20 || index == 29) {
            data_array = resources.getStringArray(R.array.Neptune_array);
            int num = resources.getStringArray(R.array.moonfactsname).length;
            xter = data_array[3];

            icons = resources.obtainTypedArray(R.array.moonIcons);
            ArrayLength=num;

        } else if (index == 3 || index == 12 || index == 21 || index == 30) {
            data_array = resources.getStringArray(R.array.jupiter_array);
            int num = resources.getStringArray(R.array.jupiterfactsname).length;
            xter = data_array[3];

            icons = resources.obtainTypedArray(R.array.jupiterIcons);
            ArrayLength=num;
        } else if (index == 4 || index == 13 || index == 22 || index == 31) {
            data_array = resources.getStringArray(R.array.Ura_array);
            int num = resources.getStringArray(R.array.Urafactsname).length;
            xter = data_array[3];

            icons = resources.obtainTypedArray(R.array.UraIcons);
            ArrayLength=num;

        } else if (index == 5 || index == 14 || index == 23) {
            data_array = resources.getStringArray(R.array.Mecury_array);
            int num = resources.getStringArray(R.array.Mercuryfactsname).length;
            xter = data_array[3];

            icons = resources.obtainTypedArray(R.array.MercuryIcons);
            ArrayLength=num;

        } else if (index == 6 || index == 15 || index == 24) {
            data_array = resources.getStringArray(R.array.Ven_array);
            int num = resources.getStringArray(R.array.Vensname).length;
            xter = data_array[3];

            icons = resources.obtainTypedArray(R.array.VenIcons);
            ArrayLength=num;

        } else if (index == 7 || index == 16 || index == 25) {
            data_array = resources.getStringArray(R.array.Neptune_array);
            int num = resources.getStringArray(R.array.NeptuneName).length;
            xter = data_array[3];

            icons = resources.obtainTypedArray(R.array.NeptuneIcons);
            ArrayLength=num;

        } else if (index == 8 || index == 17 || index == 26) {
            data_array = resources.getStringArray(R.array.Saturn_array);
            int num = resources.getStringArray(R.array.SaturnName).length;
            xter = data_array[3];

            icons = resources.obtainTypedArray(R.array.SaturnIcons);
            ArrayLength=num;
        } else if (index == 9 || index == 18 || index == 27) {
            data_array = resources.getStringArray(R.array.Mars_array);
            int num = resources.getStringArray(R.array.MarsName).length;
            xter = data_array[3];

            icons = resources.obtainTypedArray(R.array.MarsIcons);
            ArrayLength=num;
        }
        return xter;
    }

}
