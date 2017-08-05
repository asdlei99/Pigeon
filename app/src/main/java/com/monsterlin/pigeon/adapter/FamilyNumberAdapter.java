package com.monsterlin.pigeon.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.monsterlin.pigeon.R;
import com.monsterlin.pigeon.bean.User;
import com.monsterlin.pigeon.vholder.FamilyNumberVHolder;

import java.util.List;

/**
 * @author : monsterLin
 * @version : 1.0
 * @email : monster941025@gmail.com
 * @github : https://github.com/monsterLin
 * @time : 2017/8/5
 * @desc : 家庭成员适配器
 */
public class FamilyNumberAdapter extends RecyclerView.Adapter<FamilyNumberVHolder> {
    private Context mContext;
    private List<User> numberList;
    private LayoutInflater mInflater;

    public FamilyNumberAdapter(Context mContext, List<User> numberList) {
        this.mContext = mContext;
        this.numberList = numberList;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public FamilyNumberVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_family_number, parent, false);
        FamilyNumberVHolder familyNumberVHolder = new FamilyNumberVHolder(view);
        return familyNumberVHolder;
    }

    @Override
    public void onBindViewHolder(FamilyNumberVHolder holder, int position) {
        holder.mTvNick.setText(numberList.get(position).getNick());
        int type = numberList.get(position).getType();
        if (type == 0) {
            //子女
            holder.mTvType.setText("父母");
        } else if (type == 1) {
            //父母
            holder.mTvType.setText("子女");
        }
    }

    @Override
    public int getItemCount() {
        return numberList.size();
    }
}
