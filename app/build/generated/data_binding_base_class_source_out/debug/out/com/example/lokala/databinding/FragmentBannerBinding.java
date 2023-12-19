// Generated by view binder compiler. Do not edit!
package com.example.lokala.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.lokala.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentBannerBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView circle1Banner;

  @NonNull
  public final ImageView circle2Banner;

  @NonNull
  public final ImageView circle3Banner;

  @NonNull
  public final ImageView circle4Banner;

  @NonNull
  public final ImageView circle5Banner;

  @NonNull
  public final ImageView imageBanner;

  @NonNull
  public final LinearLayout layoutCircle;

  private FragmentBannerBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView circle1Banner, @NonNull ImageView circle2Banner,
      @NonNull ImageView circle3Banner, @NonNull ImageView circle4Banner,
      @NonNull ImageView circle5Banner, @NonNull ImageView imageBanner,
      @NonNull LinearLayout layoutCircle) {
    this.rootView = rootView;
    this.circle1Banner = circle1Banner;
    this.circle2Banner = circle2Banner;
    this.circle3Banner = circle3Banner;
    this.circle4Banner = circle4Banner;
    this.circle5Banner = circle5Banner;
    this.imageBanner = imageBanner;
    this.layoutCircle = layoutCircle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentBannerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentBannerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_banner, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentBannerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.circle_1_banner;
      ImageView circle1Banner = ViewBindings.findChildViewById(rootView, id);
      if (circle1Banner == null) {
        break missingId;
      }

      id = R.id.circle_2_banner;
      ImageView circle2Banner = ViewBindings.findChildViewById(rootView, id);
      if (circle2Banner == null) {
        break missingId;
      }

      id = R.id.circle_3_banner;
      ImageView circle3Banner = ViewBindings.findChildViewById(rootView, id);
      if (circle3Banner == null) {
        break missingId;
      }

      id = R.id.circle_4_banner;
      ImageView circle4Banner = ViewBindings.findChildViewById(rootView, id);
      if (circle4Banner == null) {
        break missingId;
      }

      id = R.id.circle_5_banner;
      ImageView circle5Banner = ViewBindings.findChildViewById(rootView, id);
      if (circle5Banner == null) {
        break missingId;
      }

      id = R.id.image_banner;
      ImageView imageBanner = ViewBindings.findChildViewById(rootView, id);
      if (imageBanner == null) {
        break missingId;
      }

      id = R.id.layout_circle;
      LinearLayout layoutCircle = ViewBindings.findChildViewById(rootView, id);
      if (layoutCircle == null) {
        break missingId;
      }

      return new FragmentBannerBinding((ConstraintLayout) rootView, circle1Banner, circle2Banner,
          circle3Banner, circle4Banner, circle5Banner, imageBanner, layoutCircle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
