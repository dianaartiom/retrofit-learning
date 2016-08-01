package com.example.diana.retrofit_learning.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diana.retrofit_learning.R;
import com.example.diana.retrofit_learning.controllers.RequestController;
import com.example.diana.retrofit_learning.model.Post;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class MainActivity extends AppCompatActivity {

    private TextView t;
    private RequestController requestController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestController = new RequestController();
        EventBus.getDefault().register(this);
        requestController.getProduct();

        t = (TextView) findViewById(R.id.tv);
    }

    @Subscribe
    public void onGetProductsEvent(List<Post> event) {
        Toast.makeText(MainActivity.this, event.get(0).getTitle(), Toast.LENGTH_SHORT).show();
        t.setText(event.get(0).getTitle());
    }
}
