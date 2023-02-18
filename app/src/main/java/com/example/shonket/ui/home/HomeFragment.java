package com.example.shonket.ui.home;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.shonket.R;
import com.example.shonket.databinding.FragmentHomeBinding;
import com.example.shonket.ui.gallery.GalleryFragment;

import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    SpeechRecognizer speechRecognizer;
    int coutn=0;
    String speech="";
    ImageButton imageButton;
    TextView editText;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        WebView wv=binding.webview;
        imageButton=binding.imgbtn;
        editText=binding.editext;
        WebSettings webSettings=wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        wv.setWebViewClient(new Callback());

        //wv.addJavascriptInterface(new JavaScriptInterface(), "Android");
        wv.addJavascriptInterface(new WebAppInterface(getActivity()), "Android");
        
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        wv.loadUrl("file:///android_asset/mobileavatar/index4.html");



        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recgonize();
            }
        });

        return root;
    }

    public void recgonize(){

        if(ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.RECORD_AUDIO},1);
        }

        speechRecognizer= SpeechRecognizer.createSpeechRecognizer(getActivity().getApplicationContext());
        Intent speechRecognizerIntent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"bn-BD");
                if(coutn==0){
                    imageButton.setImageDrawable(getActivity().getDrawable(R.drawable.mic_on));
                    editText.setText("Tap again to stop...");
                    //start Listening
                    coutn=1;
                    speechRecognizer.startListening(speechRecognizerIntent);
                }
                else{
                    imageButton.setImageDrawable(getActivity().getDrawable(R.drawable.mic_off));
                    editText.setText("Tap on the mic icon for voice..");
                    //stop listening
                    coutn=0;
                    speechRecognizer.stopListening();
                }

        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {
                ArrayList<String> data=bundle.getStringArrayList(speechRecognizer.RESULTS_RECOGNITION);
                //editText.setText(data.get(0));
                speech=data.get(0);
                //imageButton.setImageDrawable(getActivity().getDrawable(R.drawable.mic_off));
            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });

    }

    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Get a string from the Java method */
        @JavascriptInterface
        public String getString() {
            return speech;
        }
    }

    private class JavaScriptInterface {
        public void StartRecognizing(){
            recgonize();
        }
        public String getSpeech(){
            return "বালতি";
        }
        @JavascriptInterface
        public void javaFunction(String input) {

            Log.d("Trial", "The input is:"+input);

            String url = "http://192.168.0.194:5000/?input="+input;

            RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("Response", "onResponse: "+response);
                            // Handle the response
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Volley", "Error: " + error.toString());
                            // Handle the error
                        }
                    });

            queue.add(jsonObjectRequest);


            // Code to be executed when the JavaScript function is called
        }
    }

    private  class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==1){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(getActivity().getApplicationContext(),"permission granted",Toast.LENGTH_SHORT);
            }
            else{
                Toast.makeText(getActivity().getApplicationContext(),"permission denied",Toast.LENGTH_SHORT);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}