package mx.com.devare.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv_frame_animation, iv_gif, iv_gif_dos, iv_gif_tres;
    ImageButton ibtn_iniciar_frame_animation, ibtn_parar_frame_animation;
    Button btn_iniciar_tween_animation,btn_iniciarEjemplo,btn_init_extras_tween;
    AnimationDrawable mAnimationDrawable;
    Animation mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentesUI();
        inicializarSetOnClickListener();
        inicializarGifs();
    }

    private void iniciarComponentesUI() {
        //Referencias a Buttons
        ibtn_iniciar_frame_animation = (ImageButton) findViewById(R.id.ibtn_iniciar_frame_animation);
        ibtn_parar_frame_animation = (ImageButton) findViewById(R.id.ibtn_parar_frame_animation);
        btn_iniciar_tween_animation = (Button) findViewById(R.id.btn_iniciar_tween_animation);
        btn_iniciarEjemplo = (Button) findViewById(R.id.btn_iniciarEjemplo);
        btn_init_extras_tween = (Button) findViewById(R.id.btn_init_extras_tween);

        //Refencias a ImageViews
        iv_frame_animation = (ImageView) findViewById(R.id.iv_frame_animation);
        iv_gif = (ImageView) findViewById(R.id.iv_gif);
        iv_gif_dos = (ImageView) findViewById(R.id.iv_gif_dos);
        iv_gif_tres = (ImageView) findViewById(R.id.iv_gif_tres);
    }

    private void inicializarSetOnClickListener() {
        ibtn_iniciar_frame_animation.setOnClickListener(this);
        ibtn_parar_frame_animation.setOnClickListener(this);
        btn_iniciar_tween_animation.setOnClickListener(this);
        btn_iniciarEjemplo.setOnClickListener(this);
        btn_init_extras_tween.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibtn_iniciar_frame_animation:
                iniciarFrameAnimation();
                break;

            case R.id.ibtn_parar_frame_animation:
                stopFrameAnimation();
                break;

            case R.id.btn_iniciar_tween_animation:
                iniciarTweenAnimation();
                break;

            case R.id.btn_iniciarEjemplo:
                iniciarActividadEjemplo();
                break;

            case R.id.btn_init_extras_tween:
                iniciarActividadExtras();
                break;
        }
    }

    private void iniciarFrameAnimation() {
        iv_frame_animation.setBackgroundResource(R.drawable.frame_animation);
        mAnimationDrawable = (AnimationDrawable) iv_frame_animation.getBackground();

        iv_frame_animation.post(new Runnable() {
            @Override
            public void run() {
                mAnimationDrawable.start();
            }
        });
    }
    private void stopFrameAnimation() {
        if (mAnimationDrawable!=null){
            mAnimationDrawable.stop();
        }else{
            Toast.makeText(this, "No has iniciado la Animación Frame", Toast.LENGTH_SHORT).show();
        }
    }

    private void iniciarTweenAnimation() {
        mAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_animation);
        iv_frame_animation.startAnimation(mAnimation);

    }

    private void inicializarGifs() {
        Glide.with(this).asGif().load(R.raw.androidify).into(iv_gif);
        Glide.with(this).asGif().load(R.raw.android_basketball).into(iv_gif_dos);
        Glide.with(this).asGif().load(R.raw.android_sleep).into(iv_gif_tres);
    }

    private void iniciarActividadEjemplo() {
        Intent mIntent=new Intent(this,EjemploAnimation.class);
        startActivity(mIntent);
    }

    private void iniciarActividadExtras() {
        Intent mIntent=new Intent(this,ExtrasAnim_Tween.class);
        startActivity(mIntent);
    }

}
