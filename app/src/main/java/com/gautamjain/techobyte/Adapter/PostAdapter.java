package com.gautamjain.techobyte.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gautamjain.techobyte.Modal.Post;
import com.gautamjain.techobyte.Modal.User;
import com.gautamjain.techobyte.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hendraanggrian.appcompat.widget.SocialTextView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.Viewholder>{

    private Context mContext;
    private List<Post> mPost;
    private FirebaseUser firebaseUser;

    public PostAdapter(Context mContext, List<Post> mPost) {
        this.mContext = mContext;
        this.mPost = mPost;
    }

    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.post_item, parent, false);
        return new PostAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.Viewholder holder, int position) {

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        Post post = mPost.get(position);
        Picasso.get().load(post.getImageurl()).into(holder.imagePost);
        holder.description.setText(post.getDescription());

        FirebaseDatabase.getInstance().getReference().child("Users").child(post.getPublisher()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);

                Picasso.get().load(user.getImageUrl()).into(holder.profileImage);
                holder.username.setText(user.getUsername());
                holder.author.setText(user.getName());

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });



    }

    @Override
    public int getItemCount() {
        return mPost.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        public ImageView profileImage;
        public ImageView imagePost;
        public ImageView like;
        public ImageView comment;
        public ImageView save;
        public ImageView more;

        public TextView username;
        public TextView no_of_likes;
        public TextView author;
        public TextView no_of_comments;
        public SocialTextView description;

        public Viewholder(View itemView) {
            super(itemView);

            profileImage = itemView.findViewById(R.id.profile_image);
            imagePost = itemView.findViewById(R.id.id_Image_post);
            like = itemView.findViewById(R.id.id_like);
            save = itemView.findViewById(R.id.id_save);
            comment = itemView.findViewById(R.id.id_comment);
            more = itemView.findViewById(R.id.id_more);

            username = itemView.findViewById(R.id.username_post);
            no_of_likes = itemView.findViewById(R.id.id_no_of_likes);
            no_of_comments = itemView.findViewById(R.id.id_no_of_Comments);
            author = itemView.findViewById(R.id.id_authorname);
            description = itemView.findViewById(R.id.description);

        }
    }

}
