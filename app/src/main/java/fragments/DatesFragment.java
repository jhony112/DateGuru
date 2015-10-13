package fragments;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.jhony.dateguru.R;

import models.LargeListAdapter;
import models.pickedValue;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatesFragment extends Fragment {
    TextView txt_xter;
    ListView list;

    public DatesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_dates, null);


        // txt_xter = (TextView) view.findViewById(R.id.txt_xter);
        list = (ListView) view.findViewById(R.id.list);

        // txt_xter.setText(SetData(pickedValue.getValue()));
        String[] values = Split(SetData(pickedValue.getValue()));
        Resources resources = getResources();
        list.setAdapter(new LargeListAdapter(getContext(), values,resources.getDrawable(R.drawable.pin),resources.getDrawable(R.drawable.know),R.layout.row_large));
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
            xter = data_array[2];

        } else if (index == 2 || index == 11 || index == 20 || index == 29) {
            data_array = resources.getStringArray(R.array.Neptune_array);
            xter = data_array[2];

        } else if (index == 3 || index == 12 || index == 21 || index == 30) {
            data_array = resources.getStringArray(R.array.jupiter_array);
            xter = data_array[2];
        } else if (index == 4 || index == 13 || index == 22 || index == 31) {
            data_array = resources.getStringArray(R.array.Ura_array);
            xter = data_array[2];
        } else if (index == 5 || index == 14 || index == 23) {
            data_array = resources.getStringArray(R.array.Mecury_array);
            xter = data_array[2];
        } else if (index == 6 || index == 15 || index == 24) {
            data_array = resources.getStringArray(R.array.Ven_array);
            xter = data_array[2];
        } else if (index == 7 || index == 16 || index == 25) {
            data_array = resources.getStringArray(R.array.Neptune_array);
            xter = data_array[2];
        } else if (index == 8 || index == 17 || index == 26) {
            data_array = resources.getStringArray(R.array.Saturn_array);
            xter = data_array[2];
        } else if (index == 9 || index == 18 || index == 27) {
            data_array = resources.getStringArray(R.array.Mecury_array);
            xter = data_array[2];
        }
        return xter;
    }

}
