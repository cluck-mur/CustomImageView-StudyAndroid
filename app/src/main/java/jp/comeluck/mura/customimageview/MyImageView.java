package jp.comeluck.mura.customimageview;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class MyImageView extends ImageView {
    // 待機時間
    private int MilliSec = 50;
    // アニメフレームを管理するオブジェクト
    private BallAnimeFrames AnimeMan = new BallAnimeFrames(this);

    // スレッドUI操作用ハンドラ
    private Handler MyHandler = new Handler();
    // アニメ処理（イメージ更新処理）
    private Runnable UpdateImage = new Runnable() {
        public void run() {
            // イメージの更新
            SetNextImage();

            // 再度タイマーを掛ける
            MyHandler.removeCallbacks(UpdateImage);
            MyHandler.postDelayed(UpdateImage, MilliSec);
        }
    };

    /**
     * コンストラクタ
     * AndroidStudioの新規->Javaクラス作成機能で自動生成した
     * @param context
     */
    public MyImageView(Context context) {
        super(context);
    }

    /**
     * コンストラクタ
     * AndroidStudioの新規->Javaクラス作成機能で自動生成した
     * @param context
     * @param attrs
     */
    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * コンストラクタ
     * AndroidStudioの新規->Javaクラス作成機能で自動生成した
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * コンストラクタ
     * AndroidStudioの新規->Javaクラス作成機能で自動生成した
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * フィールドの初期化
     */
    //public void Init(String packagename) {
    public void Init() {
        // 最初のイメージを表示
        int imageId = AnimeMan.GetCurrentFrameResourceId();
        this.setImageResource(imageId);

        // アニメ開始
        MyHandler.postDelayed(UpdateImage, MilliSec);
    }

    /**
     * 新しいイメージをセットする
     */
    public void SetNextImage() {
        // 次のフレームへ
        AnimeMan.Next();

        // 次フレームのイメージを表示
        int imageId = AnimeMan.GetCurrentFrameResourceId();
        this.setImageResource(imageId);
    }
}
