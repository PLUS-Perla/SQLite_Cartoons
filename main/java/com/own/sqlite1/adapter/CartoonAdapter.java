package com.own.sqlite1.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.own.sqlite1.R;
import com.own.sqlite1.model.Cartoon;
import com.own.sqlite1.model.Product;

import java.util.List;


/**
 * Created by Elena Alvarado on 08/04/2018.
 */

public class CartoonAdapter extends RecyclerView.Adapter <CartoonAdapter.CartoonViewHolder>
        implements View.OnClickListener {


    List<Cartoon> cartoons;
    View.OnClickListener listener;
    //Constructor
    public CartoonAdapter(List<Cartoon> cartoons){
        this.cartoons =cartoons;
    }
    //getter and setter de listener
    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public CartoonAdapter.CartoonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //se inflael cardview al reciclerview
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cartoon_cell_layout,parent,false);
        CartoonAdapter.CartoonViewHolder holder=new CartoonAdapter.CartoonViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(CartoonAdapter.CartoonViewHolder holder, int position) {
        System.out.println(cartoons.get(position));
        holder.txvName.setText(cartoons.get(position).getName());
        holder.txvType.setText(String.valueOf(cartoons.get(position).getType()));
        holder.txvLanguage.setText(String.valueOf(cartoons.get(position).getLanguage()));
        holder.txvAuthor.setText(String.valueOf(cartoons.get(position).getAuthor()));
        holder.txvCapitulos.setText(String.valueOf(cartoons.get(position).getCapitulos()));
        holder.txvYear.setText(String.valueOf(cartoons.get(position).getYear()));
        holder.setListener(this);

    }

    @Override
    public int getItemCount() {
        return cartoons.size();
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }

    }

    public static class CartoonViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cvCartoon;
        TextView txvName ;
        TextView txvType;
        TextView txvLanguage;
        TextView txvAuthor;
        TextView txvCapitulos;
        TextView txvYear;
        ImageButton btEditCartoon;
        ImageButton btDeleteCartoon;
        View.OnClickListener listener;




        public CartoonViewHolder(View itemView) {
            super(itemView);
            cvCartoon=(CardView) itemView.findViewById(R.id.crv_cartoon);
            txvName=(TextView) itemView.findViewById(R.id.txv_name);
            txvType=(TextView) itemView.findViewById(R.id.txv_type);
            txvLanguage=(TextView)itemView.findViewById(R.id.txv_language);
            txvAuthor=(TextView)itemView.findViewById(R.id.txv_author);
            txvCapitulos=(TextView)itemView.findViewById(R.id.txv_capitulos);
            txvYear=(TextView)itemView.findViewById(R.id.txv_year);
            btEditCartoon=(ImageButton) itemView.findViewById(R.id.btn_edit);
            btDeleteCartoon=(ImageButton) itemView.findViewById(R.id.btn_delete);
            btEditCartoon.setOnClickListener(this);
            btDeleteCartoon.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            if (listener!=null){
                listener.onClick(v);
            }
        }

        public void setListener(View.OnClickListener listener){
            this.listener=listener;

        }
    }
}
