package mx.com.devare.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class EjemploAnimation extends AppCompatActivity implements Animator.AnimatorListener{
    RelativeLayout  rl_fondo;
    ImageView iv_nube1,iv_nube2, iv_rayo1, iv_rayo2, iv_animation_chico;
    Drawable drawable;
    Animation animation_rayo1,animation_rayo2;
    AnimationDrawable chicoAnimation;
    ObjectAnimator oa,oa_chico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_animation);
        inicicializarComponenetesUI();
        iniciarAnimacion();
    }

    private void inicicializarComponenetesUI() {
        rl_fondo = (RelativeLayout) findViewById(R.id.rl_fondo);

        iv_nube1 = (ImageView) findViewById( R.id.iv_nube1);
        iv_nube2 = (ImageView) findViewById( R.id.iv_nube2);
        iv_rayo1 = (ImageView) findViewById(R.id.iv_rayo1);
        iv_rayo2 = (ImageView) findViewById(R.id.iv_rayo2);
        iv_animation_chico = (ImageView) findViewById(R.id.iv_animation_chico);
    }

    private void iniciarAnimacion(){

        //Asignamos al RelativeLayout la animación de cambio de fondo -- property animation
        oa = (ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.animation_background);
        oa.setTarget(rl_fondo);
        oa.start();

        drawable = iv_nube1.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

        drawable = iv_nube2.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

        //Property animation del iv_animation_chico
        oa_chico = (ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.animation_movimiento_chico);
        oa_chico.setTarget(iv_animation_chico);

        //Cuando acabe la animación del fondo comenzamos la de los rayos y la del iv_animation_chico
        oa.addListener(this);

    }

    private void iniciarTweenAnimations() {
        //Animación tween para los rayos
        animation_rayo1 = AnimationUtils.loadAnimation(this, R.anim.animation_rayo1);
        animation_rayo2 = AnimationUtils.loadAnimation(this, R.anim.animation_rayo2);

        iv_rayo1.startAnimation(animation_rayo1);
        iv_rayo2.startAnimation(animation_rayo2);
    }

    private void iniciarFrameAnimation() {
        //Animación por frames del iv_animation_chico
        chicoAnimation = (AnimationDrawable) iv_animation_chico.getBackground();
        chicoAnimation.start();
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        iniciarTweenAnimations();
        iniciarFrameAnimation();
        oa_chico.start();
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {
        Toast.makeText(this, "repeat", Toast.LENGTH_SHORT).show();
    }
}
