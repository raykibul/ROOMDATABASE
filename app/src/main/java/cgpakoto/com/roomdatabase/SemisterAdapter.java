package cgpakoto.com.roomdatabase;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SemisterAdapter extends RecyclerView.Adapter<SemisterAdapter.viewHolder> {
 List<Semister> mylist;
 OnRecyclerItemClickInterface itemClickInterface;


    public SemisterAdapter(List<Semister> mylist,OnRecyclerItemClickInterface intface) {
        this.itemClickInterface=intface;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.semisteritemview,viewGroup,false);

       return  new viewHolder(view,itemClickInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        Semister tempsemister=mylist.get(i);
        viewHolder.semistername.setText(tempsemister.getSemister_name());
        viewHolder.semistergpa.setText(tempsemister.getSemister_gpa()+"");
        viewHolder.semistercredit.setText(tempsemister.getSemister_credit()+"");
    }

    @Override
    public int getItemCount() {
        if (!mylist.isEmpty()){
            return mylist.size();
        }
        else {
            return 0;
        }

    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView semistername,semistergpa,semistercredit;
        OnRecyclerItemClickInterface onRecyclerItemClickInterface;


        public viewHolder(@NonNull View itemView,OnRecyclerItemClickInterface interFace) {
            super(itemView);
            semistercredit=itemView.findViewById(R.id.semistercredittv);
            semistergpa=itemView.findViewById(R.id.semistergpatv);
            semistername=itemView.findViewById(R.id.semisterNametv);
            itemView.setOnClickListener(this);
            this.onRecyclerItemClickInterface=interFace;

        }

        @Override
        public void onClick(View view) {
            onRecyclerItemClickInterface.OnItemClick(getAdapterPosition());
        }
    }

    public interface  OnRecyclerItemClickInterface{
        void OnItemClick(int position);
    }
}
