package android.example.aboutwinequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void QuizButton(View view) {

        CheckBox checkBoxOne = findViewById(R.id.chardonnay);
        boolean isChardonnay = checkBoxOne.isChecked();

        CheckBox checkBoxTwo = findViewById(R.id.pinot_noir);
        boolean isPinotNoir = checkBoxTwo.isChecked();

        CheckBox checkBoxThree = findViewById(R.id.syrah);
        boolean isSyrah = checkBoxThree.isChecked();

        RadioButton redButton = findViewById(R.id.red_wine);
        boolean redWineButton = redButton.isChecked();

        RadioButton whiteButton = findViewById(R.id.white_wine);
        boolean whiteWineButton = whiteButton.isChecked();

        RadioButton yesButton = findViewById(R.id.yes_radio_button);
        boolean checkYesButton = yesButton.isChecked();

        RadioButton noButton = findViewById(R.id.no_radio_button);
        boolean checkNoButton = noButton.isChecked();

        EditText nameFiled = findViewById(R.id.red_or_white);
        String name = nameFiled.getText().toString();

        int resultQuiz = checkpointSummary(isChardonnay, isPinotNoir, isSyrah, redWineButton, whiteWineButton, checkYesButton, checkNoButton, name);
        if (resultQuiz == 5){
            Toast.makeText(this, "Total: " + resultQuiz + " You are a wine expert!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Total: " + resultQuiz + " You should learn more about wines!", Toast.LENGTH_SHORT).show();
        }

    }
    /**
     * Calculates the points of the correct answer.
     */
    private int checkpointSummary(boolean isChardonnay,
                                  boolean isPinotNoir,
                                  boolean isSyrah,
                                  boolean redWineButton,
                                  boolean whiteWineButton,
                                  boolean checkYesButton,
                                  boolean checkNoButton,
                                  String name) {

        int checkpoint = 0;
        // Check the first question - wrong answer
        if (isChardonnay) {
            checkpoint = checkpoint - 1;
        }
        // Check the first question - correct answer
        if (isPinotNoir) {
            checkpoint = checkpoint + 1;
        }
        // Check the first question - correct answer
        if (isSyrah) {
            checkpoint = checkpoint + 1;
        }
        // Check the second question - wrong answer
        if (redWineButton) {
            checkpoint = checkpoint - 1;
        }
        // Check the second question - correct answer
        if (whiteWineButton){
            checkpoint = checkpoint + 1;
        }
        // Check the third question - wrong answer
        if (name.matches("Red wine")) {
            checkpoint = checkpoint - 1;
        }
        // Check the third question - correct answer
        if (name.matches("White wine")) {
            checkpoint = checkpoint + 1;
        }
        // Check the forth question - correct answer
        if (checkYesButton){
            checkpoint = checkpoint + 1;
        }
        // Check the forth question - wrong answer
        if (checkNoButton){
            checkpoint = checkpoint - 1;
        }
        return checkpoint;
    }

}