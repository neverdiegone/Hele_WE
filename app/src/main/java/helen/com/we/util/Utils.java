package helen.com.we.util;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;
import helen.com.we.R;
import helen.com.we.network.UnsafeOkHttpGlideModule;

public class Utils {

    public static void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setEnabled(false);
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
        editText.setBackgroundColor(Color.TRANSPARENT);
        editText.setFocusableInTouchMode(false);
    }

    public static void enableEditText(EditText editText) {
        editText.setFocusable(true);
        editText.setEnabled(true);
        editText.setCursorVisible(true);
        editText.setFocusableInTouchMode(true);
    }

    public static String dateTimeVN(String dateTime) {
        Date date = null;
        SimpleDateFormat targetDateFormat = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateTime);

            targetDateFormat = new SimpleDateFormat("EEEE");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return targetDateFormat.format(date);
    }

    public static String dateTime(String dateTime) {
        Date date = null;
        SimpleDateFormat targetDateFormat = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateTime);

            targetDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return targetDateFormat.format(date);
    }

    public static String dateTimeHour(String dateTime) {
        Date date = null;
        SimpleDateFormat targetDateFormat = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateTime);

            targetDateFormat = new SimpleDateFormat("hh:mm");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return targetDateFormat.format(date);
    }


    public static void loadImageAvatar(String url, ImageView imageView, Context context) {

        Glide.with(context)
                .load(url)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Log.e("TAG", "Error loading image", e);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(imageView);
    }

    public static void showDialog(Context context, int icon, String title, String description) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.layout_dialog);
        ImageView imgDialog = dialog.findViewById(R.id.img_dialog);
        TextView tvTitle = dialog.findViewById(R.id.tv_title_dialog);
        TextView tvDescription = dialog.findViewById(R.id.tv_des_dialog);
        Button btnClose = dialog.findViewById(R.id.btn_close_dialog);
        imgDialog.setBackgroundResource(icon);
        tvTitle.setText(title);
        tvDescription.setText(description);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}
