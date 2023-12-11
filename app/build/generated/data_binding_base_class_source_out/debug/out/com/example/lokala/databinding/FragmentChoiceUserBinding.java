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
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.lokala.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentChoiceUserBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayoutCompat bacgroundTitleChoiceUser;

  @NonNull
  public final LinearLayout layoutCircle;

  @NonNull
  public final TextView tvTitleChoice;

  @NonNull
  public final ImageView unselectedCircle1ChoiceUser;

  @NonNull
  public final ImageView unselectedCircle2ChoiceUser;

  @NonNull
  public final ImageView unselectedCircle3ChoiceUser;

  private FragmentChoiceUserBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayoutCompat bacgroundTitleChoiceUser, @NonNull LinearLayout layoutCircle,
      @NonNull TextView tvTitleChoice, @NonNull ImageView unselectedCircle1ChoiceUser,
      @NonNull ImageView unselectedCircle2ChoiceUser,
      @NonNull ImageView unselectedCircle3ChoiceUser) {
    this.rootView = rootView;
    this.bacgroundTitleChoiceUser = bacgroundTitleChoiceUser;
    this.layoutCircle = layoutCircle;
    this.tvTitleChoice = tvTitleChoice;
    this.unselectedCircle1ChoiceUser = unselectedCircle1ChoiceUser;
    this.unselectedCircle2ChoiceUser = unselectedCircle2ChoiceUser;
    this.unselectedCircle3ChoiceUser = unselectedCircle3ChoiceUser;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentChoiceUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentChoiceUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_choice_user, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentChoiceUserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bacground_title_choice_user;
      LinearLayoutCompat bacgroundTitleChoiceUser = ViewBindings.findChildViewById(rootView, id);
      if (bacgroundTitleChoiceUser == null) {
        break missingId;
      }

      id = R.id.layout_circle;
      LinearLayout layoutCircle = ViewBindings.findChildViewById(rootView, id);
      if (layoutCircle == null) {
        break missingId;
      }

      id = R.id.tv_title_choice;
      TextView tvTitleChoice = ViewBindings.findChildViewById(rootView, id);
      if (tvTitleChoice == null) {
        break missingId;
      }

      id = R.id.unselected_circle_1_choice_user;
      ImageView unselectedCircle1ChoiceUser = ViewBindings.findChildViewById(rootView, id);
      if (unselectedCircle1ChoiceUser == null) {
        break missingId;
      }

      id = R.id.unselected_circle_2_choice_user;
      ImageView unselectedCircle2ChoiceUser = ViewBindings.findChildViewById(rootView, id);
      if (unselectedCircle2ChoiceUser == null) {
        break missingId;
      }

      id = R.id.unselected_circle_3_choice_user;
      ImageView unselectedCircle3ChoiceUser = ViewBindings.findChildViewById(rootView, id);
      if (unselectedCircle3ChoiceUser == null) {
        break missingId;
      }

      return new FragmentChoiceUserBinding((ConstraintLayout) rootView, bacgroundTitleChoiceUser,
          layoutCircle, tvTitleChoice, unselectedCircle1ChoiceUser, unselectedCircle2ChoiceUser,
          unselectedCircle3ChoiceUser);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}