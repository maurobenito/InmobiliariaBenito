package com.example.inmobiliariabenito.ui.contrato;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.inmobiliariabenito.databinding.FragmentDetalleContratoBinding;
import com.example.inmobiliariabenito.modelo.Contrato;
import com.example.inmobiliariabenito.modelo.Inmueble;

public class DetalleContratoFragment extends Fragment {

    private DetalleContratoViewModel vm;
    private FragmentDetalleContratoBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetalleContratoBinding.inflate(inflater, container, false);
        vm = new ViewModelProvider(this).get(DetalleContratoViewModel.class);

        vm.getContrato().observe(getViewLifecycleOwner(), contrato -> {


            binding.tvFechaInicio.setText(contrato.getFechaInicio());
            binding.tvFechaFin.setText(contrato.getFechaFinalizacion());
            binding.tvMonto.setText(String.valueOf(contrato.getMontoAlquiler()));
            binding.tvInquilino.setText(contrato.getInquilino().getNombre());


            // Deshabilitar todos los campos
          
        });

        vm.recuperarContrato(getArguments());

        return binding.getRoot();
    }
}
