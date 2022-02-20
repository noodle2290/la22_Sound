package takutaku.app.la22_sound

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import takutaku.app.la22_sound.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val drumSound = MediaPlayer.create(this, R.raw.drum_sound)
        val cymbalSound = MediaPlayer.create(this, R.raw.cymbal_sound)
        val guitarSound = MediaPlayer.create(this, R.raw.guitar_sound)
        val pianoSound = MediaPlayer.create(this, R.raw.piano_sound)

        binding.drumImage.setOnTouchListener { view, event ->

            if(event.action == MotionEvent.ACTION_DOWN) {

                binding.drumImage.setImageResource((R.drawable.drum_playing_image))

                drumSound.seekTo(0)
                drumSound.start()
            }

            else if (event.action == MotionEvent.ACTION_UP){

                binding.drumImage.setImageResource(R.drawable.drum_image)
            }
            true
        }

        binding.cymbalImage.setOnTouchListener { view, event ->

            if(event.action == MotionEvent.ACTION_DOWN) {

                binding.cymbalImage.setImageResource((R.drawable.cymbal_playing_image))

                cymbalSound.seekTo(0)
                cymbalSound.start()
            }

            else if (event.action == MotionEvent.ACTION_UP){

                binding.cymbalImage.setImageResource(R.drawable.cymbal_image)
            }
            true
        }

        binding.guitarImage.setOnTouchListener { view, event ->

            if(event.action == MotionEvent.ACTION_DOWN) {

                binding.guitarImage.setImageResource((R.drawable.guitar_playing_image))

                guitarSound.seekTo(0)
                guitarSound.start()
            }

            else if (event.action == MotionEvent.ACTION_UP){

                binding.guitarImage.setImageResource(R.drawable.guitar_image)
            }
            true
        }

        binding.pianoImage.setOnTouchListener { view, event ->

            if(event.action == MotionEvent.ACTION_DOWN) {

                binding.pianoImage.setImageResource((R.drawable.piano_playing_image))

                pianoSound.seekTo(0)
                pianoSound.start()
            }

            else if (event.action == MotionEvent.ACTION_UP){

                binding.pianoImage.setImageResource(R.drawable.piano_image)
            }
            true
        }
    }


}