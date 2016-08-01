package com.example.diana.retrofit_learning.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diana.retrofit_learning.R;
import com.example.diana.retrofit_learning.controllers.CommentsController;
import com.example.diana.retrofit_learning.controllers.RequestController;
import com.example.diana.retrofit_learning.model.Comment;
import com.example.diana.retrofit_learning.model.Post;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class MainActivity extends AppCompatActivity {

    private TextView t;
    private TextView t2;
    private RequestController requestController;
    private CommentsController commentsController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView) findViewById(R.id.tv);
        t2 = (TextView) findViewById(R.id.xv);
        requestController = new RequestController();
        commentsController = new CommentsController();
        EventBus.getDefault().register(this);
        requestController.getProduct();
        commentsController.getComments();
    }

    @Subscribe
    public void onGetProductsEvent(List<Post> event) {
        Toast.makeText(MainActivity.this, event.get(0).getTitle(), Toast.LENGTH_SHORT).show();
        t.setText(event.get(0).getTitle());
    }

    @Subscribe
    public void onGetCommetsEvent(List<Comment> event) {
        t2.setText(event.get(0).getBody());
    }
}
