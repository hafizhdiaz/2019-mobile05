package polinema.ac.id.starterchapter05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import polinema.ac.id.starterchapter05.fragment.dips;
import polinema.ac.id.starterchapter05.fragment.handstand;
import polinema.ac.id.starterchapter05.fragment.pushup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handstand();
    }

    public void btn_pushup(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_placeholder);

        if (fragment == null || fragment instanceof handstand || fragment instanceof dips){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_from_left,R.anim.enter_from_left,R.anim.exit_from_right);
            fragmentTransaction.replace(R.id.fragment_placeholder,new pushup());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    public void btn_dips(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_placeholder);

        if (fragment == null || fragment instanceof handstand || fragment instanceof pushup){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_from_left,R.anim.enter_from_left,R.anim.exit_from_right);
            fragmentTransaction.replace(R.id.fragment_placeholder,new dips());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    public void btn_handstand(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_placeholder);

        if (fragment == null || fragment instanceof pushup || fragment instanceof dips){
            Handstand();
        }
    }

    public void Handstand(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_from_left,R.anim.enter_from_left,R.anim.exit_from_right);
        fragmentTransaction.replace(R.id.fragment_placeholder,new handstand());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
