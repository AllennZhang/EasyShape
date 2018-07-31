package com.hipac.webviewtest;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

public class VideoRecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private  Context mContext;
    public static final int typenormal = 0;
    public static final int typevideo = 1;

    public VideoRecAdapter(Context context){
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == typevideo) {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recy_video, parent, false));
        }else {
            return new TextVH(LayoutInflater.from(mContext).inflate(R.layout.item_recy_normal,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
           if (holder instanceof VideoRecAdapter.ViewHolder) {
               ((VideoRecAdapter.ViewHolder)holder).play(position);
           }
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 3 ? typevideo : typenormal;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextureView textureView ;
        Surface mSurface;
        MediaPlayer mMediaPlayer;

        public ViewHolder(View itemView) {
            super(itemView);
            textureView =itemView.findViewById(R.id.textureView);


        }

        public void play(int position){
            if (position == 3){
                textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {

                    //创建完成  TextureView才可以进行视频画面的显示
                    @Override
                    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
                        mSurface = new Surface(surface);//连接对象（MediaPlayer和TextureView）
                        if (mMediaPlayer == null){
                            mMediaPlayer = new MediaPlayer();
                        }
                        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                //当MediaPlayer对象处于Prepared状态的时候，可以调整音频/视频的属性，如音量，播放时是否一直亮屏，循环播放等。
                                mMediaPlayer.setVolume(0f,0f);
                            }
                        });
                        mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                            @Override
                            public boolean onError(MediaPlayer mp, int what, int extra) {
                                return false;
                            }
                        });

                        mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                            @Override
                            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                                //此方法获取的是缓冲的状态
                                Log.e("TEXTUREVIDEO_TAG","缓冲中:"+percent);
                            }
                        });

                        //播放完成的监听
                        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
//                            mState = VideoState.init;
//                            if (listener!=null) listener.onPlayingFinish();
                            }
                        });
                        mMediaPlayer.setSurface(mSurface);
                        try {
                            mMediaPlayer.reset();
                            mMediaPlayer.setDataSource(mContext, Uri.parse("https://in-20180316144433577-i2a3xkgcul.oss-cn-shanghai.aliyuncs.com/video/126c403a-164b0448c07-0006-f645-5fd-63c7a.mp4?Expires=1532440716&OSSAccessKeyId=LTAIXduujLCSSEHS&Signature=A78gW%2FARXEpmdO6ax6Zlr9usSU4%3D"));
                            mMediaPlayer.prepare();
                            mMediaPlayer.start();
                        } catch (IOException e) {
                            Log.e("TEXTUREVIDEO_TAG","error:"+e.toString());
                        }

                    }

                    @Override
                    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

                    }

                    @Override
                    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                        mMediaPlayer.pause();
                        mMediaPlayer.stop();
                        mMediaPlayer.reset();
                        return false;
                    }

                    @Override
                    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

                    }
                });
            }
        }

        public void readyPlay(){

        }

    }

    class TextVH  extends RecyclerView.ViewHolder{

        public TextVH(View itemView) {
            super(itemView);
        }
    }
}
