package com.zykj.landous.Tools;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;

import com.baidu.frontia.Frontia;
import com.baidu.frontia.api.FrontiaAuthorization.MediaType;
import com.baidu.frontia.api.FrontiaSocialShare;
import com.baidu.frontia.api.FrontiaSocialShare.FrontiaTheme;
import com.baidu.frontia.api.FrontiaSocialShareContent;

public class Share {
	private Activity activity;
	public FrontiaSocialShare mSocialShare;
	private FrontiaSocialShareContent mImageContent = new FrontiaSocialShareContent();

	public Share(Context context) {
		activity = (Activity) context;
		mSocialShare = Frontia.getSocialShare();
		mSocialShare.setContext(context);
		mSocialShare.setClientId(MediaType.QZONE.toString(), "100358052");
		mSocialShare.setClientId(MediaType.QQFRIEND.toString(), "100358052");
		mSocialShare.setClientName(MediaType.QQFRIEND.toString(), "百度");
		mSocialShare.setClientId(MediaType.WEIXIN.toString(),
				"wx329c742cb69b41b8");
		mImageContent.setTitle("百度开发中心");
		mImageContent.setContent("欢迎使用百度社会化分享组件，相关问题请邮件dev_support@baidu.com");
		mImageContent.setLinkUrl("http://developer.baidu.com/");
		mImageContent
				.setImageUri(Uri
						.parse("http://apps.bdimg.com/developer/static/04171450/developer/images/icon/terminal_adapter.png"));
	}

	public void show() {
		mSocialShare.show(activity.getWindow().getDecorView(), mImageContent,
				FrontiaTheme.DARK, null);
	}

}
