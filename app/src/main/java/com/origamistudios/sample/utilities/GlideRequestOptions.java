package com.origamistudios.sample.utilities;

import com.origamistudios.sample.R;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;


public class GlideRequestOptions {

    public static final RequestOptions profileImageOptions = new RequestOptions()
            .dontAnimate()
            .placeholder(R.drawable.ic_default_profile)
            .diskCacheStrategy(DiskCacheStrategy.ALL);

    public static final RequestOptions mapsMarkerOptions = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .placeholder(R.drawable.ic_default_profile);

    public static final RequestOptions productsImageOptions = new RequestOptions()
            .dontAnimate()
            .placeholder(R.drawable.ic_image_place_holder)
            .diskCacheStrategy(DiskCacheStrategy.ALL);

    public static final RequestOptions brandsImageOptions = new RequestOptions()
            .dontAnimate()
            .placeholder(R.drawable.ic_image_place_holder)
            .diskCacheStrategy(DiskCacheStrategy.ALL);

    public static final RequestOptions chatUserProfile = new RequestOptions()
            .dontAnimate()
            .placeholder(R.drawable.profileicon)
            .diskCacheStrategy(DiskCacheStrategy.ALL);
}
