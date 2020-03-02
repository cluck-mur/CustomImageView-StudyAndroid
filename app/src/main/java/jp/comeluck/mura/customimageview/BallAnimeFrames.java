package jp.comeluck.mura.customimageview;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class BallAnimeFrames {
    // 親であるView
    View ParentView;
    // 現在フレームのインデックス
    private int CurrentImageIndex;
    // フレームデータ
    private List<String> Images;

    /**
     * コンストラクタ
     */
    public BallAnimeFrames(View parent_view) {
        ParentView = parent_view;
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
    }

    /**
     * 現在のフレームのリソース名を取得
     * @return
     */
    public String GetCurrentFrameResourceName() {
        return Images.get(CurrentImageIndex);
    }

    /**
     * 現在のフレームのリソースIDを取得
     * @return
     */
    public int GetCurrentFrameResourceId() {
        return ParentView.getResources().getIdentifier(GetCurrentFrameResourceName(), "drawable", this.getClass().getPackage().getName());
    }

    /**
     * 次のフレームへ
     */
    public void Next() {
        // 現在表示中イメージのインデックスを更新
        if (CurrentImageIndex < (Images.size() - 1)) {
            CurrentImageIndex++;
        } else {
            CurrentImageIndex = 0;
        }
    }
}
