package com.example.androidproyectounivalle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageGalleryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Galería de Imágenes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<String> imageUrls = Arrays.asList(
            "https://picsum.photos/500/500?random=1",
            "https://picsum.photos/500/500?random=2",
            "https://picsum.photos/500/500?random=3",
            "https://picsum.photos/500/500?random=4",
            "https://picsum.photos/500/500?random=5",
            "https://picsum.photos/500/500?random=6",
            "https://picsum.photos/500/500?random=7",
            "https://picsum.photos/500/500?random=8",
            "https://picsum.photos/500/500?random=9",
            "https://picsum.photos/500/500?random=10",
            "https://picsum.photos/500/500?random=11",
            "https://picsum.photos/500/500?random=12",
            "https://picsum.photos/500/500?random=13",
            "https://picsum.photos/500/500?random=14",
            "https://picsum.photos/500/500?random=15",
            "https://picsum.photos/500/500?random=16",
            "https://picsum.photos/500/500?random=17",
            "https://picsum.photos/500/500?random=18",
            "https://picsum.photos/500/500?random=19",
            "https://picsum.photos/500/500?random=20"
        );

        adapter = new ImageAdapter(imageUrls);
        recyclerView.setAdapter(adapter);
    }

    private class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
        private List<String> imageUrls;

        public ImageAdapter(List<String> imageUrls) {
            this.imageUrls = imageUrls;
        }

        @Override
        public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_image, parent, false);
            return new ImageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ImageViewHolder holder, int position) {
            String imageUrl = imageUrls.get(position);
            Glide.with(holder.itemView.getContext())
                    .load(imageUrl)
                    .centerCrop()
                    .into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return imageUrls.size();
        }

        class ImageViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            ImageViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
            }
        }
    }
}
