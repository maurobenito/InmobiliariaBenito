package com.example.inmobiliariabenito.ui.contrato;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliariabenito.modelo.Contrato;

public class DetalleContratoViewModel extends AndroidViewModel {

    private MutableLiveData<Contrato> contrato;

    public DetalleContratoViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Contrato> getContrato() {
        if (contrato == null) {
            contrato = new MutableLiveData<>();
        }
        return contrato;
    }

    public void recuperarContrato(Bundle bundle) {
        Contrato c = (Contrato) bundle.getSerializable("contratoBundle");
        if (c != null) {
            contrato.setValue(c);
        }
    }
}