package com.gidzero.coders;

import static android.content.Context.CLIPBOARD_SERVICE;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CodeAdapter extends RecyclerView.Adapter<CodeAdapter.ViewHolder> {
  List <CodersModel> codersModel;
    Context context;
    private AlertDialog alertDialog;

    public CodeAdapter(List<CodersModel> codersModel, Context context) {
        this.codersModel = codersModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.coder_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.guns.setImageResource(codersModel.get(position).getImg());
        holder.hex.setText(codersModel.get(position).getHex());
        holder.dec.setText(codersModel.get(position).getDec());

        holder.hex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                Toast.makeText(context.getApplicationContext(), "Hex code copied", Toast.LENGTH_SHORT).show();
                clipboard.setText(codersModel.get(position).getHex());
            }
        });

        holder.dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                Toast.makeText(context.getApplicationContext(), "Dex code copied", Toast.LENGTH_SHORT).show();
                clipboard.setText(codersModel.get(position).getDec());

            }
        });


    }

    @Override
    public int getItemCount() {
        return codersModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView guns ;
        TextView hex,dec;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            guns =itemView.findViewById(R.id.guns);
            hex =itemView.findViewById(R.id.codeEh);
            dec =itemView.findViewById(R.id.codeDex);
            if (alertDialog==null){
                AlertDialog.Builder builder =new AlertDialog.Builder(context);
                View view =LayoutInflater.from(context).inflate(R.layout.,(ViewGroup)  findViewById(R.id.layoutDeleteNote_Container));
                builder.setView(view);
                alertDialog =builder.create();

                if (alertDialog.getWindow()!=null){
                    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                }



        }
    }
}
