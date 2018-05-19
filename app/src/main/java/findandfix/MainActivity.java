package findandfix;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.dp.findandfix.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.lav_animation_holder)
    LottieAnimationView lottieAnimationView;

    @BindView(R.id.tv_offers)
    TextView offersTextView;
    @BindView(R.id.tv_add_urgent_request)
    TextView addUrgentRequestTextView;
    @BindView(R.id.tv_normal_request)
    TextView normalRequestTextView;
    @BindView(R.id.tv_edit_profile)
    TextView editProfileTextView;

    int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        ButterKnife.bind(this);
        setAnimationEvent();
    }


    private void setAnimationEvent() {
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                offersTextView.setVisibility(View.VISIBLE);
                addUrgentRequestTextView.setVisibility(View.VISIBLE);
                normalRequestTextView.setVisibility(View.VISIBLE);
                editProfileTextView.setVisibility(View.VISIBLE);
                setTouchEvent();
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }



    private void getScreenDimentions() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
    }

    private void setTouchEvent() {
        getScreenDimentions();
        lottieAnimationView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    if ((int) event.getX() < ((width - 24) / 2) && (int) event.getY() < ((height - 24) / 4)) {

                        Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();

                    } else if ((int) event.getX() < ((width - 24) / 2) && (int) event.getY() > ((height - 24) / 4)) {

                        Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();

                    } else if ((int) event.getX() > ((width - 24) / 2) && (int) event.getY() < ((height - 24) / 4)) {

                        Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();

                    } else if ((int) event.getX() > ((width - 24) / 2) && (int) event.getY() > ((height - 24) / 4)) {

                        Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });
    }
}
