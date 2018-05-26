package findandfix.view.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dp.findandfix.R;
import butterknife.ButterKnife;
import findandfix.utils.FragmentUtils;
import findandfix.view.ui.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FragmentUtils.addFragment(this,new HomeFragment());
    }



}
