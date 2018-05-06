package com.example.bdero.animationexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AnimatePropertiesActivity extends AppCompatActivity {

    private static final int CLOCKWISE = 1;
    private static final int COUNTER = -1;
    private static final int NO_DIRECTION = 0;

    private TextView mRevolutionToggle;
    private int mRevolution;

    private TextView mRotationToggle;
    private int mRotation;


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.buttonAnimateProperties:
                    break;
                case R.id.tvRevolutionToggle:
                    mRevolution = toggleDirection((TextView) v, mRevolution);
                    break;
                case R.id.tvRotationToggle:
                    mRotation = toggleDirection((TextView) v, mRotation);
                    break;
                default:

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_properties);

        mRevolutionToggle = findViewById(R.id.tvRevolutionToggle);
        mRotationToggle = findViewById(R.id.tvRotationToggle);
        mRevolutionToggle.setOnClickListener(clickListener);
        mRotationToggle.setOnClickListener(clickListener);

        initializeProperties();

    }

    // Clockwise -> Counterclockwise -> None -> Clockwise...
    // Works for both rotation and direction toggles
    private int toggleDirection(TextView toggleView, int direction) {
        int imageResource;
        int newDirection;
        switch (direction) {
            case CLOCKWISE:
                newDirection = COUNTER;
                imageResource = R.drawable.ic_rotate_left_black_24dp;
                break;
            case COUNTER:
                newDirection = NO_DIRECTION;
                imageResource = R.drawable.ic_rotate_none_black_24dp;
                break;
            case NO_DIRECTION:
                newDirection = CLOCKWISE;
                imageResource = R.drawable.ic_rotate_right_black_24dp;
                break;
            default:
                newDirection = NO_DIRECTION;
                imageResource = R.drawable.ic_rotate_none_black_24dp;
        }
        toggleView.setCompoundDrawablesWithIntrinsicBounds(0, 0, imageResource, 0);
        return newDirection;
    }


    private void initializeProperties() {

        mRevolution = NO_DIRECTION;
        mRevolutionToggle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_rotate_none_black_24dp, 0);
        mRotation = CLOCKWISE;
        mRotationToggle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_rotate_right_black_24dp, 0);

    }

}
