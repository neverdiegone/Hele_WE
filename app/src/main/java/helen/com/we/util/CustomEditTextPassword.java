package helen.com.we.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;

import helen.com.we.R;

@SuppressLint("AppCompatCustomView")
public class CustomEditTextPassword extends EditText {
    Drawable eye, eyeStrike;
    Boolean visiable = false;
    Boolean useStrike = false;
    Boolean validate = false;
    Drawable drawable;
    int ALPHA = (int) (255 * .65f);

    public CustomEditTextPassword(Context context) {
        super(context);
        init(null);
    }

    public CustomEditTextPassword(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomEditTextPassword(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomEditTextPassword(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }
    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray array = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.PassWordEditText, 0, 0);//goi thuoc tinh bên style
            this.useStrike = array.getBoolean(R.styleable.PassWordEditText_useStrike, false);
        }
        eye = ContextCompat.getDrawable(getContext(), R.drawable.background_password_editext_open).mutate();
        eyeStrike = ContextCompat.getDrawable(getContext(), R.drawable.background_password_editext_close).mutate();
        settingPassword();
    }
    private void settingPassword(){
        setInputType(InputType.TYPE_CLASS_TEXT | (visiable ? InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD : InputType.TYPE_TEXT_VARIATION_PASSWORD));
        Drawable[] drawables = getCompoundDrawables();
        drawable = useStrike && !visiable ? eyeStrike : eye;
        drawable.setAlpha(ALPHA);
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], drawable, drawables[3]);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("evenX", String.valueOf(event.getX()));
        Log.d("even123", String.valueOf(drawable.getBounds().width()));
        if (event.getAction() == MotionEvent.ACTION_UP && event.getX() >= (getRight() - (drawable.getBounds().width()+50))) {
            visiable = !visiable;
            settingPassword();
            invalidate();
        }
        return super.onTouchEvent(event);
    }
}
