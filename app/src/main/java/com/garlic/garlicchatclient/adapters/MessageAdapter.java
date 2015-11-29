package com.garlic.garlicchatclient.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garlic.garlicchatclient.R;
import com.garlic.garlicchatclient.models.Message;

import java.util.List;

/**
 * Created by Pratik on 11/29/2015
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private List<Message> mMessages;

    public MessageAdapter(List<Message> messages) {
        this.mMessages = messages;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = -1;

        switch (Message.typeFromInt(viewType)) {
            case TYPE_MESSAGE:
                layout = R.layout.item_message;
                break;
            case TYPE_LOG:
                layout = R.layout.item_log;
                break;
            case TYPE_ACTION:
                layout = R.layout.item_action;
                break;
        }

        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message message = mMessages.get(position);
        holder.setMessage(message.getMessage());
        holder.setUsername(message.getUsername());
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mMessages.get(position).getType();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mUsernameView;
        private TextView mMessageView;

        public ViewHolder(View itemView) {
            super(itemView);

            mUsernameView = (TextView) itemView.findViewById(R.id.username);
            mMessageView = (TextView) itemView.findViewById(R.id.message);
        }

        public void setUsername(String username) {
            if(mUsernameView == null) {
                return;
            }
            mUsernameView.setText(username);
        }

        public void setMessage(String message) {
            if(mMessageView == null) {
                return;
            }

            mMessageView.setText(message);
        }

    }
}
