package promiennam.co.simplegetdatafromurl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import promiennam.co.simplegetdatafromurl.R;
import promiennam.co.simplegetdatafromurl.helpers.RetrofitHelper;
import promiennam.co.simplegetdatafromurl.interfaces.ICallback;
import promiennam.co.simplegetdatafromurl.models.MovieList;

public class HomeActivity extends AppCompatActivity implements ICallback {

    private TextView txtTitle;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtTitle = (TextView) findViewById(R.id.txt_title);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        // get data
        RetrofitHelper.getData(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onComplete(MovieList movieList) {
        // just show the first film title
        txtTitle.setText(movieList.getMovieList().get(0).getTitle());
        progressBar.setVisibility(View.GONE);
    }
}
