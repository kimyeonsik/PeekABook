package kim.yeonsik.peekabook.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kim.yeonsik.peekabook.R

fun ImageView.fromUrl(url: String) {
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.ic_book_placeholder)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}