// Generated by view binder compiler. Do not edit!
package com.example.lokala.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.example.lokala.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDetailUserBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final LinearLayout containerDataUmur;

  @NonNull
  public final ConstraintLayout containerFormUser;

  @NonNull
  public final ViewPager2 containerFotoUser;

  @NonNull
  public final LinearLayout containerLokasiTerakhir;

  @NonNull
  public final CardView containerStatus;

  @NonNull
  public final TextInputLayout containerUserCiriFisik;

  @NonNull
  public final TextInputLayout containerUserSeringDitemukan;

  @NonNull
  public final Guideline guidelineHorizontal;

  @NonNull
  public final TextView tvCallCenter;

  @NonNull
  public final TextView tvLokasiTerakhir;

  @NonNull
  public final TextInputEditText tvLokasiUser;

  @NonNull
  public final TextView tvNamaUser;

  @NonNull
  public final TextView tvSeringDitemukan;

  @NonNull
  public final TextView tvTitleCiriFisik;

  @NonNull
  public final TextView tvUserBerat;

  @NonNull
  public final TextInputEditText tvUserCiriFisik;

  @NonNull
  public final TextView tvUserGender;

  @NonNull
  public final TextInputEditText tvUserSeringDitemukan;

  @NonNull
  public final TextView tvUserStatus;

  @NonNull
  public final TextView tvUserUsia;

  private ActivityDetailUserBinding(@NonNull ScrollView rootView,
      @NonNull LinearLayout containerDataUmur, @NonNull ConstraintLayout containerFormUser,
      @NonNull ViewPager2 containerFotoUser, @NonNull LinearLayout containerLokasiTerakhir,
      @NonNull CardView containerStatus, @NonNull TextInputLayout containerUserCiriFisik,
      @NonNull TextInputLayout containerUserSeringDitemukan, @NonNull Guideline guidelineHorizontal,
      @NonNull TextView tvCallCenter, @NonNull TextView tvLokasiTerakhir,
      @NonNull TextInputEditText tvLokasiUser, @NonNull TextView tvNamaUser,
      @NonNull TextView tvSeringDitemukan, @NonNull TextView tvTitleCiriFisik,
      @NonNull TextView tvUserBerat, @NonNull TextInputEditText tvUserCiriFisik,
      @NonNull TextView tvUserGender, @NonNull TextInputEditText tvUserSeringDitemukan,
      @NonNull TextView tvUserStatus, @NonNull TextView tvUserUsia) {
    this.rootView = rootView;
    this.containerDataUmur = containerDataUmur;
    this.containerFormUser = containerFormUser;
    this.containerFotoUser = containerFotoUser;
    this.containerLokasiTerakhir = containerLokasiTerakhir;
    this.containerStatus = containerStatus;
    this.containerUserCiriFisik = containerUserCiriFisik;
    this.containerUserSeringDitemukan = containerUserSeringDitemukan;
    this.guidelineHorizontal = guidelineHorizontal;
    this.tvCallCenter = tvCallCenter;
    this.tvLokasiTerakhir = tvLokasiTerakhir;
    this.tvLokasiUser = tvLokasiUser;
    this.tvNamaUser = tvNamaUser;
    this.tvSeringDitemukan = tvSeringDitemukan;
    this.tvTitleCiriFisik = tvTitleCiriFisik;
    this.tvUserBerat = tvUserBerat;
    this.tvUserCiriFisik = tvUserCiriFisik;
    this.tvUserGender = tvUserGender;
    this.tvUserSeringDitemukan = tvUserSeringDitemukan;
    this.tvUserStatus = tvUserStatus;
    this.tvUserUsia = tvUserUsia;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_detail_user, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailUserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.container_data_umur;
      LinearLayout containerDataUmur = ViewBindings.findChildViewById(rootView, id);
      if (containerDataUmur == null) {
        break missingId;
      }

      id = R.id.container_form_user;
      ConstraintLayout containerFormUser = ViewBindings.findChildViewById(rootView, id);
      if (containerFormUser == null) {
        break missingId;
      }

      id = R.id.container_foto_user;
      ViewPager2 containerFotoUser = ViewBindings.findChildViewById(rootView, id);
      if (containerFotoUser == null) {
        break missingId;
      }

      id = R.id.container_lokasi_terakhir;
      LinearLayout containerLokasiTerakhir = ViewBindings.findChildViewById(rootView, id);
      if (containerLokasiTerakhir == null) {
        break missingId;
      }

      id = R.id.container_status;
      CardView containerStatus = ViewBindings.findChildViewById(rootView, id);
      if (containerStatus == null) {
        break missingId;
      }

      id = R.id.container_user_ciri_fisik;
      TextInputLayout containerUserCiriFisik = ViewBindings.findChildViewById(rootView, id);
      if (containerUserCiriFisik == null) {
        break missingId;
      }

      id = R.id.container_user_Sering_ditemukan;
      TextInputLayout containerUserSeringDitemukan = ViewBindings.findChildViewById(rootView, id);
      if (containerUserSeringDitemukan == null) {
        break missingId;
      }

      id = R.id.guidelineHorizontal;
      Guideline guidelineHorizontal = ViewBindings.findChildViewById(rootView, id);
      if (guidelineHorizontal == null) {
        break missingId;
      }

      id = R.id.tv_call_center;
      TextView tvCallCenter = ViewBindings.findChildViewById(rootView, id);
      if (tvCallCenter == null) {
        break missingId;
      }

      id = R.id.tv_lokasi_terakhir;
      TextView tvLokasiTerakhir = ViewBindings.findChildViewById(rootView, id);
      if (tvLokasiTerakhir == null) {
        break missingId;
      }

      id = R.id.tv_lokasi_user;
      TextInputEditText tvLokasiUser = ViewBindings.findChildViewById(rootView, id);
      if (tvLokasiUser == null) {
        break missingId;
      }

      id = R.id.tv_nama_user;
      TextView tvNamaUser = ViewBindings.findChildViewById(rootView, id);
      if (tvNamaUser == null) {
        break missingId;
      }

      id = R.id.tv_sering_ditemukan;
      TextView tvSeringDitemukan = ViewBindings.findChildViewById(rootView, id);
      if (tvSeringDitemukan == null) {
        break missingId;
      }

      id = R.id.tv_title_ciri_fisik;
      TextView tvTitleCiriFisik = ViewBindings.findChildViewById(rootView, id);
      if (tvTitleCiriFisik == null) {
        break missingId;
      }

      id = R.id.tv_user_berat;
      TextView tvUserBerat = ViewBindings.findChildViewById(rootView, id);
      if (tvUserBerat == null) {
        break missingId;
      }

      id = R.id.tv_user_ciri_fisik;
      TextInputEditText tvUserCiriFisik = ViewBindings.findChildViewById(rootView, id);
      if (tvUserCiriFisik == null) {
        break missingId;
      }

      id = R.id.tv_user_gender;
      TextView tvUserGender = ViewBindings.findChildViewById(rootView, id);
      if (tvUserGender == null) {
        break missingId;
      }

      id = R.id.tv_user_sering_ditemukan;
      TextInputEditText tvUserSeringDitemukan = ViewBindings.findChildViewById(rootView, id);
      if (tvUserSeringDitemukan == null) {
        break missingId;
      }

      id = R.id.tv_user_status;
      TextView tvUserStatus = ViewBindings.findChildViewById(rootView, id);
      if (tvUserStatus == null) {
        break missingId;
      }

      id = R.id.tv_user_usia;
      TextView tvUserUsia = ViewBindings.findChildViewById(rootView, id);
      if (tvUserUsia == null) {
        break missingId;
      }

      return new ActivityDetailUserBinding((ScrollView) rootView, containerDataUmur,
          containerFormUser, containerFotoUser, containerLokasiTerakhir, containerStatus,
          containerUserCiriFisik, containerUserSeringDitemukan, guidelineHorizontal, tvCallCenter,
          tvLokasiTerakhir, tvLokasiUser, tvNamaUser, tvSeringDitemukan, tvTitleCiriFisik,
          tvUserBerat, tvUserCiriFisik, tvUserGender, tvUserSeringDitemukan, tvUserStatus,
          tvUserUsia);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
