package youdu.com;

/**
 * Created on 19-05-30
 *
 * @function 负责展示和管理这些音乐文件
 */
public class Sound {
    private String mAssetPath;
    private String mName;
    private Integer mSoundId;

    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length - 1];
        mName = filename.replace(".wav", "");
    }

    /**
     * 返回单文件完整路径
     *
     * @return
     */
    public String getAssetPath() {
        return mAssetPath;
    }

    /**
     * 仅返回单个文件名（不带后缀）
     *
     * @return
     */
    public String getName() {
        return mName;
    }

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }
}
