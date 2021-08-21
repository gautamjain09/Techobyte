package com.gautamjain.techobyte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hasankucuk.socialtextview.SocialTextView;

public class PostActivity extends AppCompatActivity {

    private ImageView close, image_added;
    private TextView post;
    SocialTextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        close = findViewById(R.id.close_Post_Activity);
        image_added = findViewById(R.id.image_add_Post_Activity);
        post = findViewById(R.id.post_Post_Activity);
        description = findViewById(R.id.description_Post_Activity);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PostActivity.this, MainActivity.class));
                finish();
            }
        });



    }
}