package com.example.androi3.mvp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.Toast;

import com.example.androi3.R;
import com.example.androi3.base.BaseFragment;
import com.example.androi3.databinding.FragmentCounterBinding;

public class CounterFragment extends BaseFragment<FragmentCounterBinding> implements CounterContracts.CounterView {

    CounterContracts.Presenter presenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = Injector.counterPresenter();
        presenter.attachView(this);
        initListeners();
    }

    private void initListeners() {
        binding.incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.changeColor();
                presenter.congratulation();
                presenter.increaseCounter();
            }
        });

        binding.decrementBtn.setOnClickListener(view -> presenter.decrement());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.detachView();
    }

    @Override
    protected FragmentCounterBinding bind() {
        return FragmentCounterBinding.inflate(getLayoutInflater());
    }

    @Override
    public void updateCounter(int count) {
        binding.counterTv.setText(String.valueOf(count));
    }

    @Override
    public void tenCount() {
        Toast.makeText(requireContext(), "10!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void greenText() {
        binding.counterTv.setTextColor(ContextCompat.getColor(requireContext(),R.color.green));
    }
}