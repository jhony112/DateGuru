package models;

import android.graphics.drawable.Drawable;

/**
 * Created by jhony on 9/28/2015.
 */
public class ListItem {

    public final Drawable icon;       // the drawable for the ListView item ImageView
    public final String title;        // the text for the ListView item title
    public final String description;  // the text for the ListView item description

    public ListItem(Drawable icon, String title, String description) {
        this.icon = icon;
        this.title = title;
        this.description = description;
    }
}

