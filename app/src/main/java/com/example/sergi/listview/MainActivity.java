package com.example.sergi.listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<String> nombres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.ListView);
        nombres=new ArrayList<String>();
        nombres.add("Sergio");
        nombres.add("Alberto");
        nombres.add("Cortés");
      /*  // forma visual
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,nombres);

        //Enlazamos
        lv.setAdapter(adapter);*/

      // con mi adapter

        MyAdapter myAdapter = new MyAdapter(this,R.layout.list_items,nombres);
        lv.setAdapter(myAdapter);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,nombres.get(i)+"",Toast.LENGTH_LONG).show();
            }
        });
    }


    public class  MyAdapter extends BaseAdapter{
        private Context context;
        private int layout;
        private List<String> nombres;

        public MyAdapter(Context context, int layout, List<String> nombres) {
            this.context = context;
            this.layout = layout;
            this.nombres = nombres;
        }

        @Override
        public int getCount() {
            return nombres.size();
        }

        @Override
        public Object getItem(int i) {
            return nombres.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            View v = view;
            LayoutInflater layoutInflater =LayoutInflater.from(this.context);
            v=layoutInflater.inflate(R.layout.list_items,null);
            String currentName=nombres.get(position);

            TextView tv=v.findViewById(R.id.textView);
            tv.setText(currentName);

            return  v;
        }
    }
}
