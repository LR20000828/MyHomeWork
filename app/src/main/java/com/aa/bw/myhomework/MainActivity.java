package com.aa.bw.myhomework;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;


public class MainActivity extends AppCompatActivity {

    private float a = 945/688f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*http://ww3.sinaimg.cn/large/610dc034jw1f6m4aj83g9j20zk1hcww3.jpg*/
        /*http://pic31.nipic.com/20130701/12270044_163555570320_2.jpg*/
        /*http://www.imagewa.com/PhotoPreview/361/361_31935.jpg*/
        SimpleDraweeView simple2 = findViewById(R.id.sdv_2);
        SimpleDraweeView simple3 = findViewById(R.id.sdv_3);
        SimpleDraweeView simple4 = findViewById(R.id.sdv_4);
        final SimpleDraweeView simple5 = findViewById(R.id.sdv_5);
        SimpleDraweeView simple6 = findViewById(R.id.sdv_6);

        Uri parse = Uri.parse("http://img3.3lian.com/2006/013/02/20050515181009495.png");
        String b = ("http://www.910club.cn/ppt/beijing/UploadFiles_8374/201201/2012011410371932.gif");

        simple4.setAspectRatio(a);
        simple4.setImageURI(parse);

        simple2.setImageURI(parse);
        simple3.setImageURI(parse);

        //加载动图
        DraweeController controller5 = Fresco.newDraweeControllerBuilder()
                .setUri(b)
                .setAutoPlayAnimations(true)
                .setControllerListener(new ControllerListener<ImageInfo>() {
                    @Override
                    public void onSubmit(String id, Object callerContext) {

                    }

                    @Override
                    public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {

                    }

                    @Override
                    public void onIntermediateImageSet(String id, ImageInfo imageInfo) {

                    }

                    @Override
                    public void onIntermediateImageFailed(String id, Throwable throwable) {

                    }

                    @Override
                    public void onFailure(String id, Throwable throwable) {

                    }

                    @Override
                    public void onRelease(String id) {

                    }
                })
                .build();
        simple5.setController(controller5);

        //高斯模糊
        GaussianBlur.showUrlBlur(simple6,"http://img3.3lian.com/2006/013/02/20050515181009495.png",10);


        SimpleDraweeView viewById = findViewById(R.id.sdv_7);
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                //图片地址
                .setUri(parse)
                //播放gif 图片
                .setAutoPlayAnimations(true)
                //点击重新加载时 可以重新加载4 次
                .setTapToRetryEnabled(true)
                .build();

        viewById.setController(controller);

    }
}
