package sur.cas.edu.programmingforkids;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    //global variable for result to be used inside many functions
    //In Java, when initializing a global variable of type int, by default, its value is 0.
    int result;
    String status = "none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    /**
     * This method is called when the submit answers button is clicked.
     */
    public void submitAnswers(View view) {
        //display results is a toast
        //editText the name of the student
        EditText nameEditText = findViewById(R.id.name);
        final String name = nameEditText.getText().toString();

        //editText for question 1
        EditText answer1EditText = findViewById(R.id.answer1);
        final String answer1 = answer1EditText.getText().toString();

        //checkBox answers for question 2
        CheckBox checkBox1 = findViewById(R.id.checkboxAnswer1);
        boolean checkBox1Answer = checkBox1.isChecked();
        CheckBox checkBox2 = findViewById(R.id.checkboxAnswer2);
        boolean checkBox2Answer = checkBox2.isChecked();
        CheckBox checkBox3 = findViewById(R.id.checkboxAnswer3);
        boolean checkBox3Answer = checkBox3.isChecked();
        CheckBox checkBox4 = findViewById(R.id.checkboxAnswer4);
        boolean checkBox4Answer = checkBox4.isChecked();

        //answer for question 4 editText
        EditText editTextanswer4 = findViewById(R.id.answer4EditText);
        final String answer4 = editTextanswer4.getText().toString();

        //show status of each question whether right or wrong
        String answerStatus =
                showAnswerStatus(answer1, checkBox1Answer, checkBox2Answer, checkBox3Answer,
                        checkBox4Answer, answer4);

        int totalResults =
                calculateResultQuestion2(answer1, checkBox1Answer, checkBox2Answer, checkBox3Answer,
                        checkBox4Answer, answer4);
        String toastMessage = getString(R.string.greetings) + name + getString(R.string.resultMessage) + totalResults;
        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();

        //display answers in a textView
        displayMessage(showAnswers(name, answer1, checkBox1Answer, checkBox2Answer, checkBox3Answer,
                checkBox4Answer, totalResults, answer4, answerStatus));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView answeSummaryTextView = (TextView) findViewById(R.id.answer_summary_text_view);
        answeSummaryTextView.setText(message);
    }

    /**
     * This method shows answers on the screen.
     */
    private String showAnswers(String name, String answer1,
                               boolean checkBox1, boolean checkBox2, boolean checkBox3,
                               boolean checkBox4, int totalResults, String answer4, String status) {
        return getString(R.string.name) + name + getString(R.string.totalResult) + totalResults + "\n" +
                getString(R.string.answer1) + answer1 + " " + status + "\n" +
                getString(R.string.answer2a) + checkBox1 + " " + status + "\n" +
                getString(R.string.answer2b) + checkBox2 + " " + status + "\n" +
                getString(R.string.answer2c) + checkBox3 + " " + status + "\n" +
                getString(R.string.answer2d) + checkBox4 + " " + status + "\n" +
                getString(R.string.answer) + answer4 + " " + status + "\n"
                ;
    }

    /**
     * This method calculates Result From question 1 edit Text if answer matches 8
     * This method calculates Result From CheckBox from Question 2
     */
    private int calculateResultQuestion2(String answer1, boolean checkBox1, boolean checkBox2,
                                         boolean checkBox3, boolean checkBox4, String answer4) {
        if (checkBox1) {
            result = result + 10;
        }
        if (checkBox2) {
            result = result + 10;
        }
        if (checkBox3) {
            result = result + 10;
        }
        if (checkBox4) {
            result = result + 10;
        }
        String answer1EditText = "8";
        if (answer1.equals(answer1EditText)) {
            result = result + 10;
        }
        String answer4EditText = "2";
        if (answer4.equals(answer4EditText)) {
            result = result + 10;
        }
        return result;
    }

    /**
     * This method checks the status of the question if correctly or wrongly
     * answered on the screen.
     */
    private String showAnswerStatus(String answer1, boolean checkBox1, boolean checkBox2,
                                    boolean checkBox3, boolean checkBox4, String answer4) {
        String answer4EditText = "2";
        String answer1EditText = "8";
        if (answer1.equals(answer1EditText) && checkBox1 && checkBox2 && checkBox3 && checkBox4 &&
                answer4.equals(answer4EditText)) {
            status = getString(R.string.correctMessage);
        } else {
            status = getString(R.string.wrongAnswered);
        }
        return status;
    }

    /**
     * This method checks handles the radiobutton selected
     */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    // Pirates are the best
                    result = result + 10;
                status = getString(R.string.correctMessage);
                break;
            case R.id.radioButton2:
            case R.id.radioButton3:
            case R.id.radioButton4:
                if (checked)
                    // Ninjas rule
                    status = getString(R.string.wrongAnswered);
                break;
        }

    }
}