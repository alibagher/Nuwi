package com.example.Nuwi

//import android.R
import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.MediaController
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.amazonaws.auth.CognitoCachingCredentialsProvider
import com.amazonaws.mobileconnectors.lambdainvoker.*
import com.amazonaws.regions.Regions
import com.example.Nuwi.fragments.EXTRA_MESSAGE
import com.example.Nuwi.fragments.EXTRA_MESSAGE_TIME
import com.example.Nuwi.fragments.EXTRA_MESSAGE_TWO

var myActivity:Activity ? = null;

//class SimpleThread: Thread() {
//    public override fun run() {
//        println("${currentThread()} has run.")
//
////        (myActivity?.getParent()).removeView();
//        val myVideoView = myActivity?.findViewById<View>(R.id.videoView) as VideoView
//        val path = "android.resource://" + myActivity?.packageName + "/" + R.raw.lifting
//        myVideoView.setVideoURI(Uri.parse(path))
//
//        val mediaC :MediaController  = MediaController(myActivity);
//        myVideoView.setMediaController(mediaC)
////        mediaC.setAnchorView(myVideoView);
//        myVideoView.start()
//    }
//}

//TODO: CHECK OUT THIS LINK FOR PLAYING VIDEO
//https://stackoverflow.com/questions/20755586/skipped-75-frames-the-application-may-be-doing-too-much-in-its-main-thread

class LoadStartActivity : AppCompatActivity() {
    val myVideoView : VideoView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_start)
        myActivity = this;
        // Get the Intent that started this activity and extract the string
        val intensity = intent.getStringExtra(EXTRA_MESSAGE)
        val focus = intent.getStringExtra(EXTRA_MESSAGE_TWO)
        val duration = intent.getStringExtra(EXTRA_MESSAGE_TIME)


        //todo - call lambda and pass params to it
        val credentialsProvider = CognitoCachingCredentialsProvider(
            getApplicationContext(),
            "us-east-1:4ceb213b-4af1-4689-92ed-1f7edc580474", // Identity pool ID
            Regions.US_EAST_1 // Region
        );

        val factory = LambdaInvokerFactory(this.getApplicationContext(), Regions.US_EAST_1,
            credentialsProvider);

        val lambda = factory.build(Lambda::class.java)

        val request = RequestClass("John", "Doe")

        //todo - get response url from lambda and store as variable

        val result = lambda.AndroidBackendLambdaFunction(request)

        // The Lambda function invocation results in a network call.
// Make sure it is not called from the main thread.
        object : AsyncTask<RequestClass?, Void?, ResponseClass?>() {
            protected fun doInBackground(vararg params: RequestClass): ResponseClass? {
                // invoke "echo" method. In case it fails, it will throw a
                // LambdaFunctionException.
                return try {
                    lambda.AndroidBackendLambdaFunction(params[0])
                } catch (lfe: LambdaFunctionException) {
                    Log.e("Tag", "Failed to invoke echo", lfe)
                    null
                }
            }

            override fun onPostExecute(result: ResponseClass?) {
                if (result == null) {
                    return
                }
            }
        }.execute(request)

        if (result != null) {
            Toast.makeText(getApplicationContext(), result.greetings, Toast.LENGTH_LONG).show()
        }

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = intensity + focus + duration
        }
//        val thread = SimpleThread()
//        thread.start()

        // Run the video in another thread
        Thread {
            runOnUiThread {
                //your code or your request that you want to run on uiThread
                val myVideoView = this?.findViewById<View>(R.id.videoView) as VideoView



                //todo - pass variable holding url of workout video to play in video player
                val path = "android.resource://" + this?.packageName + "/" + R.raw.movie
                myVideoView.setVideoURI(Uri.parse(path))



                val mediaC :MediaController  = MediaController(this);
                myVideoView.setMediaController(mediaC)
                mediaC.setAnchorView(myVideoView);
                myVideoView.setOnPreparedListener(MediaPlayer.OnPreparedListener {
                        myVideoView.start()
                        println("started.")
                })
                myVideoView.setOnCompletionListener(MediaPlayer.OnCompletionListener {
                    // Now need to move to the new activity showing results.
                    val intent = Intent(this, PostWorkout::class.java).apply {
                        putExtra(EXTRA_MESSAGE, intensity)
                        putExtra(EXTRA_MESSAGE_TWO, focus)
                        putExtra(EXTRA_MESSAGE_TIME, duration)
                    }
                    startActivity(intent);
                })
            }
        }.start()




//        videoPlay();
//        val mediaC :MediaController  = MediaController(this);
//
//        val myVideoView = findViewById<View>(R.id.videoView) as VideoView
//        val path = "android.resource://" + packageName + "/" + R.raw.lifting
//        myVideoView.setVideoURI(Uri.parse(path))
//        myVideoView.setMediaController(mediaC)
//        mediaC.setAnchorView(myVideoView);
//        myVideoView.start()
    }



//    val t = Thread()
//    val view1Thrad: Thread = Thread(Runnable(){
//        void run(){
//            android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_URGENT_DISPLAY);
//            myVideoView.start();
//        });


        fun videoPlay(v: View){
//        val am: AssetManager = this.getAssets()
//        val iss = am.open("lifting.mp4")

//        val videoPath = "android.resource://com.example.Nuwi/" + A.lifting;


    }
}