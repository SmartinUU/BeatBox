package youdu.com;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 19-05-30
 *
 * @function sound资源需要被定位，管理记录以及播放
 * <p>
 * BeatBox就是为此负责的资源管理类
 */
public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAsset;
    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context) {
        mAsset = context.getAssets();
        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames;
        try {
            //方法能列出指定目录下的所有文件名
            soundNames = mAsset.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found" + soundNames.length + "sounds");
        } catch (IOException e) {
            Log.e(TAG, "Could not list assets", e);
            return;
        }
        //仅返回文件名数组
        //先组成完整路径又分离它不是多此一举，是为了sound能拿到完整路径，但显示时候不会用到
        for (String filename : soundNames) {
            String assetPath = SOUNDS_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

    /**
     * 仅返回文件名数组
     * example：65_cjipie
     *
     * @return
     */
    public List<Sound> getSounds() {
        return mSounds;
    }
}
