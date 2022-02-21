package takutaku.app.la22_sound

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import takutaku.app.la22_sound.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private lateinit var soundList :Array<MediaPlayer?>

    val imagePlayingList = arrayListOf(
        R.drawable.drum_playing_image,
        R.drawable.cymbal_playing_image,
        R.drawable.guitar_playing_image,
        R.drawable.piano_playing_image
    )
    val imageList = arrayListOf(
        R.drawable.drum_image,
        R.drawable.cymbal_image,
        R.drawable.guitar_image,
        R.drawable.piano_image
    )
    private lateinit var imageViewList:Array<ImageView>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        soundList = arrayOf(
            MediaPlayer.create(this, R.raw.drum_sound),
            MediaPlayer.create(this, R.raw.cymbal_sound),
            MediaPlayer.create(this, R.raw.guitar_sound),
            MediaPlayer.create(this, R.raw.piano_sound)
        )

        imageViewList = arrayOf(
            binding.drumImage,
            binding.cymbalImage,
            binding.guitarImage,
            binding.pianoImage
        )

        imageViewList[0].setOnTouchListener{ view, motionEvent ->
            touchImage(0,motionEvent)
            true
        }
        imageViewList[1].setOnTouchListener{ view, motionEvent ->
            touchImage(1,motionEvent)
            true
        }
        imageViewList[2].setOnTouchListener{ view, motionEvent ->
            touchImage(2,motionEvent)
            true
        }
        imageViewList[3].setOnTouchListener{ view, motionEvent ->
            touchImage(3,motionEvent)
            true
        }
    }

    fun touchImage(number:Int,motionEvent:MotionEvent){
            if(motionEvent.action == MotionEvent.ACTION_DOWN) {

                imageViewList[number].setImageResource((imagePlayingList[number]))

                soundList[number]?.seekTo(0)
                soundList[number]?.start()
            }

            else if (motionEvent.action == MotionEvent.ACTION_UP){

                imageViewList[number].setImageResource(imageList[number])
            }

    }

}