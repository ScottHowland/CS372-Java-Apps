package com.example.scott.pr4_2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Button;
import java.util.Random;

/**
 * The app's one activity, which displays a button allowing the user to simulate a coin flip, then
 * changing the image displayed to either a heads or tails-side-up coin to indicate the result
 */
public class CoinFlip extends ActionBarActivity {

    private Random rand;
    private ImageView coinView;
    private Button coinButton;

    /**
     * Initialize the <code>ImageView</code> and <code>Button</code> used by the app to the
     * components established in the layout, then declare an <code>OnClickListener</code> for the
     * button to detect user input
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_flip);

        rand = new Random();
        this.coinView = (ImageView)findViewById(R.id.coinView);
        this.coinButton = (Button)findViewById(R.id.coinButton);
        coinButton.setOnClickListener(coinFlipChangeListener);
    }

    /**
     * On user touch, run the <code>flipCoin</code> method
     */
    View.OnClickListener coinFlipChangeListener = new OnClickListener() {
        public void onClick(View v) {
            flipCoin(v);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coin_flip, menu);
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

    /**
     * Return a random number 0 or 1, then update the displayed coin image based on the result
     * @param view
     */
    public void flipCoin (View view) {
        int flipResult = rand.nextInt(2);

        if (flipResult == 0)
            coinView.setImageResource(R.drawable.coinheads);
        else
            coinView.setImageResource(R.drawable.cointails);

    }
}
