package com.example.inmobiliariabenito.ui.contrato;

import static com.example.inmobiliariabenito.request.ApiClient.BASE_URL;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.inmobiliariabenito.R;
import com.example.inmobiliariabenito.modelo.Contrato;
import com.example.inmobiliariabenito.modelo.Inmueble;

import java.util.List;

public class ContratoAdapter extends RecyclerView.Adapter<ContratoAdapter.ViewHolderContrato> {

    private List<Contrato> listaContratos;
    private Context context;
    private LayoutInflater inflater;

    public ContratoAdapter(List<Contrato> listaContratos, Context context, LayoutInflater inflater) {
        this.listaContratos = listaContratos;
        this.context = context;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolderContrato onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_contrato, parent, false);
        return new ViewHolderContrato(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderContrato holder, int position) {
        Contrato contratoActual = listaContratos.get(position);
        holder.direccion.setText(contratoActual.getInmueble().getDireccion());
        holder.monto.setText("$" + contratoActual.getMontoAlquiler());

        holder.itemView.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            Bundle bundle = new Bundle();
            bundle.putSerializable("contratoBundle", contratoActual);
            navController.navigate(R.id.detalleContratoFragment, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return listaContratos.size();
    }

    public static class ViewHolderContrato extends RecyclerView.ViewHolder {
        private TextView direccion, monto;

        public ViewHolderContrato(@NonNull View itemView) {
            super(itemView);
            direccion = itemView.findViewById(R.id.tvDireccion);
            monto = itemView.findViewById(R.id.tvMonto);
        }
    }
}