package jp.camluck.mura.customimageview;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class MyImageView extends ImageView {
    // 外部からもらうデータ
    private String PackageName;
    // 待機時間
    private int MilliSec = 100;
    private int CurrentImageIndex;
    private List<String> Images;

    // スレッドUI操作用ハンドラ
    private Handler MyHandler = new Handler();
    // アニメ処理（テキスト更新処理）
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
        // パッケージ名を保存
        //PackageName = packagename;
        PackageName = this.getClass().getPackage().getName();

        // 現在表示しているイメージのインデックスを初期化
        int CurrentImageIndex = 0;
        // イメージのリストを初期化
        Images = new ArrayList<String>();
        Images.add("ani01");
        Images.add("ani02");
        Images.add("ani03");
        Images.add("ani04");
        Images.add("ani05");
        Images.add("ani06");
        Images.add("ani07");
        Images.add("ani08");
        Images.add("ani07");
        Images.add("ani06");
        Images.add("ani05");
        Images.add("ani04");
        Images.add("ani03");
        Images.add("ani02");

        // 最初のイメージを表示
        int imageId = getResources().getIdentifier(Images.get(CurrentImageIndex), "drawable", PackageName);
        this.setImageResource(imageId);

        // アニメ開始
        MyHandler.postDelayed(UpdateImage, MilliSec);
    }

    /**
     * 新しいイメージをセットする
     */
    public void SetNextImage() {
        // 現在表示中イメージのインデックスを更新
        if (CurrentImageIndex < (Images.size() - 1)) {
            CurrentImageIndex++;
        } else {
            CurrentImageIndex = 0;
        }

        // 新しいイメージを表示
        int imageId = getResources().getIdentifier(Images.get(CurrentImageIndex), "drawable", PackageName);
        this.setImageResource(imageId);
    }
}
