package thesoulforged.net.multidice;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;


public class DiceActivity extends ActionBarActivity {

    ImageButton d4Button;
    ImageButton d6Button;
    ImageButton d8Button;
    ImageButton d10Button;
    ImageButton d12Button;
    ImageButton d20Button;
    ImageButton dNACButton;
    TextView diceResult;
    NumberPicker diceAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        d4Button = (ImageButton) findViewById(R.id.d4Button);
        d6Button = (ImageButton) findViewById(R.id.d6Button);
        d8Button = (ImageButton) findViewById(R.id.d8Button);
        d10Button = (ImageButton) findViewById(R.id.d10Button);
        d12Button = (ImageButton) findViewById(R.id.d12Button);
        d20Button = (ImageButton) findViewById(R.id.d20Button);
        dNACButton = (ImageButton) findViewById(R.id.dNACButton);
        diceResult = (TextView) findViewById(R.id.resultTextView);
        diceAmount = (NumberPicker) findViewById(R.id.diceAmount);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dice, menu);
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
}
