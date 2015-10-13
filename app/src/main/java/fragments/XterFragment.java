package fragments;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jhony.dateguru.R;

import models.pickedValue;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link XterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link XterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class XterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView txt_xter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public XterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_xter, null);
        txt_xter = (TextView) view.findViewById(R.id.txt_xter);

        txt_xter.setText(SetData(pickedValue.getValue()));

        // Inflate the layout for this fragment
        return view;
    }


    String SetData(int index) {
        Resources resources = getResources();
        String[] data_array = null;
        String xter = "";
        if (index == 1 || index == 10 || index == 19 || index == 28) {
            data_array = resources.getStringArray(R.array.sun_array);
            xter = data_array[1];

        } else if (index == 2 || index == 11 || index == 20 || index == 29) {
            data_array = resources.getStringArray(R.array.Neptune_array);
            xter = data_array[1];

        } else if (index == 3 || index == 12 || index == 21 || index == 30) {
            data_array = resources.getStringArray(R.array.jupiter_array);
            xter = data_array[1];
        } else if (index == 4 || index == 13 || index == 22 || index == 31) {
            data_array = resources.getStringArray(R.array.Ura_array);
            xter = data_array[1];
        } else if (index == 5 || index == 14 || index == 23) {
            data_array = resources.getStringArray(R.array.Mecury_array);
            xter = data_array[1];
        } else if (index == 6 || index == 15 || index == 24) {
            data_array = resources.getStringArray(R.array.Ven_array);
            xter = data_array[1];
        } else if (index == 7 || index == 16 || index == 25) {
            data_array = resources.getStringArray(R.array.Neptune_array);
            xter = data_array[1];
        } else if (index == 8 || index == 17 || index == 26) {
            data_array = resources.getStringArray(R.array.Saturn_array);
            xter = data_array[1];
        } else if (index == 9 || index == 18 || index == 27) {
            data_array = resources.getStringArray(R.array.Mars_array);
            xter = data_array[1];
        }
        return xter;
    }
}
