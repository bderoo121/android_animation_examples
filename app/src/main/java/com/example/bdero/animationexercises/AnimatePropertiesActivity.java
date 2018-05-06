package com.example.bdero.animationexercises;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class AnimatePropertiesActivity extends AppCompatActivity {

    private static final int CLOCKWISE = 1;
    private static final int COUNTER = -1;
    private static final int NO_DIRECTION = 0;

    boolean isRunning;
    private Button mAnimateButton;
    private View mAnimatedShape;
    private ObjectAnimator mAnimation;
    private TextView mRevolutionToggle;
    private int mRevolutionDir;
    private TextView mRotationToggle;
    private int mRotationDir;
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.btnAnimate:
                    if (isRunning) {
                        mAnimation.cancel();
                        mAnimateButton.setText(R.string.start);
                    } else {
                        mAnimation = prepareAnimation();
                        mAnimation.start();
                        mAnimateButton.setText(R.string.stop);
                    }
                    isRunning = !isRunning;
                    break;
                case R.id.tvRevolutionToggle:
                    mRevolutionDir = toggleDirection((TextView) v, mRevolutionDir);
                    break;
                case R.id.tvRotationToggle:
                    mRotationDir = toggleDirection((TextView) v, mRotationDir);
                    break;
                default:

            }
        }
    };

    private ObjectAnimator prepareAnimation() {
        float startRot = mAnimatedShape.getRotation();
        float endRot = startRot + (mRotationDir * 360.0f);

        ObjectAnimator animation = ObjectAnimator.ofFloat(mAnimatedShape, "rotation", startRot, endRot);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(ValueAnimator.INFINITE);
        animation.setDuration(4000);
        return animation;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_properties);

        mAnimatedShape = findViewById(R.id.animatedShape);
        mAnimateButton = findViewById(R.id.btnAnimate);
        mRevolutionToggle = findViewById(R.id.tvRevolutionToggle);
        mRotationToggle = findViewById(R.id.tvRotationToggle);

        mAnimateButton.setOnClickListener(clickListener);
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

        mAnimateButton.setText(R.string.start);
        mRevolutionDir = NO_DIRECTION;
        mRevolutionToggle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_rotate_none_black_24dp, 0);
        mRotationDir = CLOCKWISE;
        mRotationToggle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_rotate_right_black_24dp, 0);

        isRunning = false;
    }

}
