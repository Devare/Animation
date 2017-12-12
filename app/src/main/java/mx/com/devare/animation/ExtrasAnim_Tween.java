package mx.com.devare.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ExtrasAnim_Tween extends AppCompatActivity implements View.OnClickListener {

    Button btn_anim_clockwise,
            btn_anim_fade_in,
            btn_anim_fade_out,
            btn_anim_blink,
            btn_anim_move,
            btn_anim_accelerate,
            btn_anim_slide_up,
            btn_anim_slide_down,
            btn_anim_zoom_in,
            btn_anim_zoom_out,
            btn_anim_rotate,
            btn_anim_bounce,
            btn_anim_sequential,
            btn_anim_together,
            btn_anim_traslate_right,
            btn_anim_traslate_left;
    ImageView iv_anim_tween;
    TextView tv_titulo, tv_subtitulo;

    Animation mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras_anim__tween);
        getSupportActionBar().hide();
        inicializarComponentesUI();
        iniciarIntroAnimacion();
        inicializarSetOnClickListener();
    }

    private void inicializarComponentesUI() {

        //Buttons
        btn_anim_clockwise = (Button) findViewById(R.id.btn_anim_clockwise);
        btn_anim_fade_in = (Button) findViewById(R.id.btn_anim_fade_in);
        btn_anim_fade_out = (Button) findViewById(R.id.btn_anim_fade_out);
        btn_anim_blink = (Button) findViewById(R.id.btn_anim_blink);
        btn_anim_move = (Button) findViewById(R.id.btn_anim_move);
        btn_anim_accelerate = (Button) findViewById(R.id.btn_anim_accelerate);
        btn_anim_zoom_in = (Button) findViewById(R.id.btn_anim_zoom_in);
        btn_anim_zoom_out = (Button) findViewById(R.id.btn_anim_zoom_out);
        btn_anim_rotate = (Button) findViewById(R.id.btn_anim_rotate);
        btn_anim_slide_up = (Button) findViewById(R.id.btn_anim_slide_up);
        btn_anim_slide_down = (Button) findViewById(R.id.btn_anim_slide_down);
        btn_anim_bounce = (Button) findViewById(R.id.btn_anim_bounce);
        btn_anim_sequential = (Button) findViewById(R.id.btn_anim_sequential);
        btn_anim_together = (Button) findViewById(R.id.btn_anim_together);
        btn_anim_traslate_right = (Button) findViewById(R.id.btn_anim_traslate_right);
        btn_anim_traslate_left = (Button) findViewById(R.id.btn_anim_traslate_left);

        //ImageViews
        iv_anim_tween = (ImageView) findViewById(R.id.iv_anim_tween);

        //TextViews
        tv_titulo = (TextView) findViewById(R.id.tv_titulo);
        tv_subtitulo = (TextView) findViewById(R.id.tv_subtitulo);
    }

    private void iniciarIntroAnimacion() {
        initAnimBounce(iv_anim_tween);
        initAnimTraslateRight(tv_titulo);
        initAnimTraslateLeft(tv_subtitulo);
    }

    private void inicializarSetOnClickListener() {

        btn_anim_clockwise.setOnClickListener(this);
        btn_anim_fade_in.setOnClickListener(this);
        btn_anim_fade_out.setOnClickListener(this);
        btn_anim_blink.setOnClickListener(this);
        btn_anim_move.setOnClickListener(this);
        btn_anim_accelerate.setOnClickListener(this);
        btn_anim_slide_up.setOnClickListener(this);
        btn_anim_zoom_in.setOnClickListener(this);
        btn_anim_zoom_out.setOnClickListener(this);
        btn_anim_rotate.setOnClickListener(this);
        btn_anim_slide_down.setOnClickListener(this);
        btn_anim_bounce.setOnClickListener(this);
        btn_anim_sequential.setOnClickListener(this);
        btn_anim_together.setOnClickListener(this);
        btn_anim_traslate_right.setOnClickListener(this);
        btn_anim_traslate_left.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_anim_clockwise:
                initAnimClockwise(iv_anim_tween);
                break;

            case R.id.btn_anim_fade_in:
                initAnimFadeIn(iv_anim_tween);
                break;

            case R.id.btn_anim_fade_out:
                initAnimFadeOut(iv_anim_tween);
                break;

            case R.id.btn_anim_blink:
                initAnimBlink(iv_anim_tween);
                break;

            case R.id.btn_anim_move:
                initAnimMove(iv_anim_tween);
                break;

            case R.id.btn_anim_accelerate:
                initAnimAccelerate(iv_anim_tween);
                break;

            case R.id.btn_anim_zoom_in:
                initAnimZoomIn(iv_anim_tween);
               break;

            case R.id.btn_anim_zoom_out:
                initAnimZoomOut(iv_anim_tween);
                break;

            case R.id.btn_anim_rotate:
                initAnimRotate(iv_anim_tween);
                break;

            case R.id.btn_anim_slide_up:
                initAnimSlideUp(iv_anim_tween);
                break;

            case R.id.btn_anim_slide_down:
                initAnimSlideDown(iv_anim_tween);
                break;

            case R.id.btn_anim_bounce:
                initAnimBounce(iv_anim_tween);
                break;

            case R.id.btn_anim_sequential:
                initAnimSequential(iv_anim_tween);
                break;

            case R.id.btn_anim_together:
                initAnimTogether(iv_anim_tween);
                break;

            case R.id.btn_anim_traslate_left:
                initAnimTraslateLeft(tv_subtitulo);
                break;

            case R.id.btn_anim_traslate_right:
                initAnimTraslateRight(tv_titulo);
                break;
        }
    }

    private void initAnimClockwise(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.clockwise);
        mView.startAnimation(mAnimation);
    }

    private void initAnimFadeIn(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.fade_in);
        mView.startAnimation(mAnimation);
    }

    private void initAnimFadeOut(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.fade_out);
        mView.startAnimation(mAnimation);
    }

    private void initAnimBlink(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.blink);
        mView.startAnimation(mAnimation);
    }

    private void initAnimMove(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.move);
        mView.startAnimation(mAnimation);
    }

    private void initAnimAccelerate(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.accelerate_decelerate);
        mView.startAnimation(mAnimation);
    }

    private void initAnimZoomIn(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.zoom_in);
        mView.startAnimation(mAnimation);
    }

    private void initAnimZoomOut(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.zoom_out);
        mView.startAnimation(mAnimation);
    }

    private void initAnimRotate(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.rotate);
        mView.startAnimation(mAnimation);
    }

    private void initAnimSlideUp(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.slide_up);
        mView.startAnimation(mAnimation);
    }

    private void initAnimSlideDown(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.slide_down);
        mView.startAnimation(mAnimation);
    }

    private void initAnimBounce(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.bounce);
        mView.startAnimation(mAnimation);
    }

    private void initAnimSequential(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.sequential);
        mView.startAnimation(mAnimation);
    }

    private void initAnimTogether(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.together);
        mView.startAnimation(mAnimation);
    }

    private void initAnimTraslateRight(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.traslate_right);
        mView.startAnimation(mAnimation);
    }

    private void initAnimTraslateLeft(View mView) {
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.traslate_left);
        mView.startAnimation(mAnimation);
    }


}
