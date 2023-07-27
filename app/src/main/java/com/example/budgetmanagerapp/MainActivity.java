package com.example.budgetmanagerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public class MainActivity extends AppCompatActivity {

        private EditText incomeEditText;
        private EditText expensesEditText;
        private EditText savingsGoalEditText;
        private TextView currentBalanceTextView;
        private TextView savingsProgressTextView;
        private Button saveButton;

        private double income = 0;
        private double expenses = 0;
        private double savingsGoal = 0;
        private double currentBalance = 0;
        private int savingsProgress = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            incomeEditText = findViewById(R.id.incomeEditText);
            expensesEditText = findViewById(R.id.expensesEditText);
            savingsGoalEditText = findViewById(R.id.savingsGoalEditText);
            currentBalanceTextView = findViewById(R.id.currentBalanceTextView);
            savingsProgressTextView = findViewById(R.id.savingsProgressTextView);
            saveButton = findViewById(R.id.saveButton);

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Get user input
                    String incomeString = incomeEditText.getText().toString();
                    String expensesString = expensesEditText.getText().toString();
                    String savingsGoalString = savingsGoalEditText.getText().toString();

                    // Convert user input to double
                    if (!TextUtils.isEmpty(incomeString)) {
                        income = Double.parseDouble(incomeString);
                    }
                    if (!TextUtils.isEmpty(expensesString)) {
                        expenses = Double.parseDouble(expensesString);
                    }
                    if (!TextUtils.isEmpty(savingsGoalString)) {
                        savingsGoal = Double.parseDouble(savingsGoalString);
                    }

                    // Calculate current balance and savings progress
                    currentBalance = income - expenses;
                    if (savingsGoal > 0) {
                        savingsProgress = (int) (currentBalance / savingsGoal * 100);
                    }

                    // Update UI
                    currentBalanceTextView.setText(String.format("%.2f", currentBalance));
                    savingsProgressTextView.setText(savingsProgress + "%");
                }
            });
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}