package com.toanvq.fpoly.game2048;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    private GridView griPlay;
    private ItemAdapter itemAdapter;
    private Item item;
    private View.OnTouchListener listener;
    private float X, Y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        anhXa();
        khoitao();
        setData();

    }

    private void anhXa() {
        griPlay = findViewById(R.id.gdvGamePlay);
    }

    private void khoitao() {
        DataGame.getDataGame().intt(MainActivity.this);
        itemAdapter = new ItemAdapter(MainActivity.this, 0, DataGame.getDataGame().getArrSo());

        listener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        X = event.getX();
                        Y = event.getY();
                        break;

                    case MotionEvent.ACTION_UP:
                        if (Math.abs(event.getX() - X) > Math.abs(event.getY() - Y)) {
                            if (event.getX() < X) {
                                DataGame.getDataGame().vuotTrai();
                                itemAdapter.notifyDataSetChanged();
                            } else {
                                DataGame.getDataGame().vuotPhai();
                                itemAdapter.notifyDataSetChanged();
                            }
                        } else {
                            if (event.getY() < Y) {
//
                                DataGame.getDataGame().vuotLen();
                                itemAdapter.notifyDataSetChanged();
                            } else {
                                DataGame.getDataGame().vuotXuong();
                                itemAdapter.notifyDataSetChanged();
                            }

                        }
                        break;
                }

                return true;
            }
        };
    }


    private void setData() {
        griPlay.setAdapter(itemAdapter);
        griPlay.setOnTouchListener(listener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
