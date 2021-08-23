package com.gautamjain.techobyte.Adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gautamjain.techobyte.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter {

    public class ViewHolder extends RecyclerView.ViewHolder{

        public CircleImageView imageProfile;
        public TextView username, fullname;
        public Button btnfollow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageProfile = itemView.findViewById(R.id.profile_image);
            username = itemView.findViewById(R.id.username);
            fullname = itemView.findViewById(R.id.Fullname);
            btnfollow = itemView.findViewById(R.id.follow_btn);

        }

    };

}
