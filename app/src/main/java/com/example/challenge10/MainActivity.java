package com.example.challenge10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private CoverFlow coverFlow;

    private LinearLayout layoutInfo;
    private ImageView imgSelected;
    private TextView txtName;
    private TextView txtPublisher;
    private TextView txtDay;
    private TextView txtWriter;

    private ArrayList<ImageListItem> listData;
    private ImageAdapter imageAdapter;

    private int currentSelectedItem;

    public static int spacing = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coverFlow = (CoverFlow) findViewById(R.id.coverFlow);

        layoutInfo = (LinearLayout) findViewById(R.id.layoutInfo);
        imgSelected = (ImageView) findViewById(R.id.imgSelected);
        txtName = (TextView) findViewById(R.id.txtName);
        txtPublisher = (TextView) findViewById(R.id.txtPublisher);
        txtDay = (TextView) findViewById(R.id.txtDay);
        txtWriter = (TextView) findViewById(R.id.txtWriter);

        Integer[] frontResources = { R.drawable.item_front01, R.drawable.item_front02, R.drawable.item_front03, R.drawable.item_front04, R.drawable.item_front05 };
        Integer[] sideResources = { R.drawable.item_side01, R.drawable.item_side02, R.drawable.item_side03, R.drawable.item_side04, R.drawable.item_side05 };
        ArrayList<String[]> bookData = new ArrayList<>();

        bookData.add(new String[]{"고전문학 특강", "몰라", "모름", "어떤쓰래기"});
        bookData.add(new String[]{"나는 다만 어쩌구 저쩌구", "몰라", "모름", "김세형"});
        bookData.add(new String[]{"베네치아", "몰라", "모름", "item03지은이"});
        bookData.add(new String[]{"비즈니스 어쩌구 저쩌구", "몰라", "모름", "이거 지은놈은 진짜 병신"});
        bookData.add(new String[]{"완득이", "창비", "모름", "김려령"});

        listData = new ArrayList<ImageListItem>();

        ImageListItem imageListItem;
        for(int i = 0; i < 5; i++)
        {
            imageListItem = new ImageListItem();
            imageListItem.setFrontResources( frontResources[i] );
            imageListItem.setSideResources( sideResources[i] );

            String[] data = bookData.get(i);
            imageListItem.setBookData(data[0], data[1], data[2], data[3]);

            listData.add(imageListItem);
        }
        imageListItem = null;

        imageAdapter = new ImageAdapter(this);
        imageAdapter.setListData( listData );

        coverFlow.setAdapter(imageAdapter);

        layoutInfo.setVisibility(View.INVISIBLE);

        coverFlow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                ImageListView selectedView = (ImageListView) view;
                currentSelectedItem = i;
                selectedView.visibleFront();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                if( position == currentSelectedItem )
                {
                    if( layoutInfo.getVisibility() == View.INVISIBLE )
                        layoutInfo.setVisibility(View.VISIBLE);

                    ImageListItem selectedItem = listData.get(position);

                    imgSelected.setImageResource( selectedItem.getFrontResources() );
                    txtName.setText( "이름 : " + selectedItem.getName() );
                    txtPublisher.setText( "출판사 : " + selectedItem.getPublisher() );
                    txtDay.setText( "출판일 : " + selectedItem.getDay() );
                    txtWriter.setText( "저자 : " + selectedItem.getWriter() );
                }
            }
        });

        coverFlow.setSpacing(spacing);
        coverFlow.setSelection(2, true);
        coverFlow.setAnimationDuration(1000);
    }
}
