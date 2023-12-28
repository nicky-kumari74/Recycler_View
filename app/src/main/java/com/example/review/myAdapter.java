package com.example.review;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.viewholder> {
    Context context;
    ClipboardManager cm;
    ArrayList<String> snum,prices,codes;
    public myAdapter(Context context,ClipboardManager cm,ArrayList<String> snum,ArrayList<String> codes,ArrayList<String> prices) {
        this.context=context;
        this.cm=cm;
        this.snum=snum;
        this.prices=prices;
        this.codes=codes;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        viewholder vh=new viewholder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.s.setText(snum.get(position));
        holder.code.setText(codes.get(position));
        holder.price.setText(prices.get(position));
        holder.total.setText(prices.get(position));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotourl("https://youtube.com/shorts/5RxMZen9EDU?si=whEvsWQslruZDrNU");
            }
        });
        holder.cpy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipData clipData=ClipData.newPlainText("copy",holder.code.getText().toString());
                cm.setPrimaryClip(clipData);
                Toast.makeText(context,"Copied",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void gotourl(String s) {
        try{
        Uri uri=Uri.parse(s);
            Intent i=new Intent(Intent.ACTION_VIEW,uri);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);}
        catch (Exception e){
            Toast.makeText(context,"No website",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return prices.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView cpy,code,price,s,total,btn;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            cpy=itemView.findViewById(R.id.copycode);
            code=itemView.findViewById(R.id.code);
            price=itemView.findViewById(R.id.price);
            s=itemView.findViewById(R.id.sno);
            total=itemView.findViewById(R.id.total);
            btn=itemView.findViewById(R.id.btn);

        }
    }
}
