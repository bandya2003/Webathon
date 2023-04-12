package com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;


import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.R;
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.customclasses.Constant;
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.utils.Utils;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.customclasses.Constant.switchState;

public class SettingActivity extends AppCompatActivity {
    RelativeLayout llAdView;
    LinearLayout llAdViewFacebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().hide();
        initDefine();
        llAdView = findViewById(R.id.llAdView);
        llAdViewFacebook = findViewById(R.id.llAdViewFacebook);
        Utils.loadBannerAd(this,llAdView,llAdViewFacebook);
    }


    Switch soundOnOff;
    private void initDefine() {
        soundOnOff=findViewById(R.id.soundOnOff);
        if(Utils.getPref(Constant.SOUND,true)){
            soundOnOff.setChecked(true);
            switchState=true;
        }else{
            switchState=false;
            soundOnOff.setChecked(false);
        }
        soundOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchState){
                    switchState=false;
                    soundOnOff.setChecked(false);
                    Utils.setPref(Constant.SOUND,false);
                }else {
                    switchState=true;
                    soundOnOff.setChecked(true);
                    Utils.setPref(Constant.SOUND,true);
                }
            }
        });

    }

    public void onClickBack(View view) {
        finish();
    }





   

    public void MoreApp(View view) {
        Uri uri = Uri.parse("https://play.google.com/store/apps/developer?id=Ninety+Nine+Apps");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void PrivacyPolicy(View view) {
        startActivity(new Intent(SettingActivity.this,PrivacyPolicyActivity.class));
    }
}
