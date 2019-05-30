package youdu.com;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created on 19-05-30
 *
 * @function 负责view和model之间的交互
 * <p>
 * 本质上来说，列表中显示的是通过BeatBox获取的Sound集合,
 * 所以在onBindViewHolder时，通过i可以在集合中拿到具体的某个Sound，并传递给viewModel进而控制它
 * <p>
 * 让view-model继承BaseObservable，注解属性，
 * 可绑定属性变化时更新
 */
public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private BeatBox mBeatBox;

    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    @Bindable
    public String getTitle() {
        return mSound.getName();
    }

    public Sound getSound() {
        return mSound;
    }

    /**
     * 这个方法会在bind()的时候调用
     *
     * @param sound
     */
    public void setSound(Sound sound) {
        mSound = sound;
        notifyChange();
    }

    public void onButtonClicked() {
        mBeatBox.play(mSound);
    }
}
