// Generated by view binder compiler. Do not edit!
package com.example.lokala.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.lokala.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class OrangListItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout carouselItemContainer;

  @NonNull
  public final ImageView ivArrow;

  @NonNull
  public final ImageView ivOrang;

  @NonNull
  public final TextView tvGender;

  @NonNull
  public final TextView tvKota;

  @NonNull
  public final TextView tvNama;

  private OrangListItemBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout carouselItemContainer, @NonNull ImageView ivArrow,
      @NonNull ImageView ivOrang, @NonNull TextView tvGender, @NonNull TextView tvKota,
      @NonNull TextView tvNama) {
    this.rootView = rootView;
    this.carouselItemContainer = carouselItemContainer;
    this.ivArrow = ivArrow;
    this.ivOrang = ivOrang;
    this.tvGender = tvGender;
    this.tvKota = tvKota;
    this.tvNama = tvNama;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static OrangListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static OrangListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.orang_list_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static OrangListItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      LinearLayout carouselItemContainer = (LinearLayout) rootView;

      id = R.id.iv_arrow;
      ImageView ivArrow = ViewBindings.findChildViewById(rootView, id);
      if (ivArrow == null) {
        break missingId;
      }

      id = R.id.iv_orang;
      ImageView ivOrang = ViewBindings.findChildViewById(rootView, id);
      if (ivOrang == null) {
        break missingId;
      }

      id = R.id.tv_gender;
      TextView tvGender = ViewBindings.findChildViewById(rootView, id);
      if (tvGender == null) {
        break missingId;
      }

      id = R.id.tv_kota;
      TextView tvKota = ViewBindings.findChildViewById(rootView, id);
      if (tvKota == null) {
        break missingId;
      }

      id = R.id.tv_nama;
      TextView tvNama = ViewBindings.findChildViewById(rootView, id);
      if (tvNama == null) {
        break missingId;
      }

      return new OrangListItemBinding((LinearLayout) rootView, carouselItemContainer, ivArrow,
          ivOrang, tvGender, tvKota, tvNama);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
