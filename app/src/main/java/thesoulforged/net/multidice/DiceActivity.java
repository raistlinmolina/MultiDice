package thesoulforged.net.multidice;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;


public class DiceActivity extends Activity implements View.OnClickListener {

    ImageButton d4Button;
    ImageButton d6Button;
    ImageButton d8Button;
    ImageButton d10Button;
    ImageButton d12Button;



    ImageButton d20Button;
    ImageButton dNACButton;
    TextView diceResult;
    NumberPicker diceAmount;

    ImageButton buttons[];
    int diceTypes [];


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
        diceAmount.setMaxValue(10);
        diceAmount.setMinValue(1);
        diceAmount.setValue(1);

        buttons = new ImageButton[]{d4Button,d6Button,d8Button,d10Button,d12Button,d20Button,dNACButton};
        diceTypes = new int[] {DiceUtil.d4Type, DiceUtil.d6Type, DiceUtil.d8Type, DiceUtil.d10Type, DiceUtil.d12Type, DiceUtil.d20Type, DiceUtil.dNACType};
        for (int i = 0; i< buttons.length; i++) {
            buttons[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i< buttons.length; i++) {
            if (view == buttons[i]) {
                int[] diceThrow = DiceUtil.throwDice(diceTypes[i], diceAmount.getValue());
                String result = "";
                int iter = 0;
                for (int aDiceThrow : diceThrow) {
                    if (iter > 0) result = result.concat(", ");
                    result = result.concat(Integer.toString(aDiceThrow));
                    iter++;
                }
                diceResult.setText(result);

            }
        }
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
