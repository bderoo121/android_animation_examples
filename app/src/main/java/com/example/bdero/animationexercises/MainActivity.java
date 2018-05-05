package com.example.bdero.animationexercises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mAnimatePropertiesButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String ideas =
                "Ideas for animation pages:\n" +
                "   View that follows your finger\n"+
                "   Cup and ball game\n"+
                "\n"+
                "\n"+
                "\n"+
                "\n"+
                "   Collection of animated bitmaps(play->pause)\n"+
                "   Transition examples";

        ((TextView) findViewById(R.id.ideasTextView)).setText(ideas);

        mAnimatePropertiesButton = (TextView) findViewById(R.id.tv_animate_properties_button);
        mAnimatePropertiesButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.tv_animate_properties_button:
                startActivity(new Intent(this, AnimatePropertiesActivity.class));
                break;
            default:
        }
    }
}
