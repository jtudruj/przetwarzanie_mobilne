package eu.jakubtudruj.secondapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kuba on 30/10/2016.
 */

public class MyAdapter extends BaseAdapter {

    private Context myContext;
    private LayoutInflater myInflater;
    private ArrayList<ListItemEntity> myDataSource;

    public MyAdapter(Context context, ArrayList<ListItemEntity> items) {
        myContext = context;
        myDataSource = items;
        myInflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return myDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = myInflater.inflate(R.layout.list_item, null);
        }
        ListItemEntity entity = myDataSource.get(position);

        ((TextView) convertView.findViewById(R.id.list_header)).setText(entity.getDate());
        ((TextView) convertView.findViewById(R.id.list_text)).setText(entity.getPlace() + ":\t" + entity.getTemperature());

        return convertView;
    }
}
