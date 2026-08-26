package com.example.debuggingsum;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.debuggingsum.databinding.ActivityMainBinding;

public final class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private final TextWatcher clearResultWatcher = new TextWatcher() {
        @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
        @Override public void afterTextChanged(Editable s) {
            if (binding != null) {
                binding.resultText.setText("");
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.firstNumber.addTextChangedListener(clearResultWatcher);
        binding.secondNumber.addTextChangedListener(clearResultWatcher);
        binding.sumButton.setOnClickListener(view -> calculate());
    }

    private void calculate() {
        try {
            long result = SumCalculator.add(
                    binding.firstNumber.getText().toString(),
                    binding.secondNumber.getText().toString()
            );
            binding.resultText.setText(String.valueOf(result));
        } catch (NumberFormatException exception) {
            Toast.makeText(this, R.string.invalid_number, Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException exception) {
            Toast.makeText(this, R.string.overflow, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}
