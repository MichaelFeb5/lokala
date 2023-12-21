// Generated by view binder compiler. Do not edit!
package com.example.lokala.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.lokala.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLoadingBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final TextView textLoading;

  @NonNull
  public final TextView textLoadingMessage;

  private FragmentLoadingBinding(@NonNull RelativeLayout rootView, @NonNull ProgressBar progressBar,
      @NonNull TextView textLoading, @NonNull TextView textLoadingMessage) {
    this.rootView = rootView;
    this.progressBar = progressBar;
    this.textLoading = textLoading;
    this.textLoadingMessage = textLoadingMessage;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoadingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoadingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_loading, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoadingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.textLoading;
      TextView textLoading = ViewBindings.findChildViewById(rootView, id);
      if (textLoading == null) {
        break missingId;
      }

      id = R.id.textLoadingMessage;
      TextView textLoadingMessage = ViewBindings.findChildViewById(rootView, id);
      if (textLoadingMessage == null) {
        break missingId;
      }

      return new FragmentLoadingBinding((RelativeLayout) rootView, progressBar, textLoading,
          textLoadingMessage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}