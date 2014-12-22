package com.zykj.landous.fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.frontia.Frontia;
import com.baidu.frontia.api.FrontiaSocialShare;
import com.baidu.frontia.api.FrontiaSocialShareContent;
import com.baidu.frontia.api.FrontiaAuthorization.MediaType;
import com.baidu.frontia.api.FrontiaSocialShare.FrontiaTheme;
import com.zykj.landous.R;
import com.zykj.landous.push.PushActivity;

public class TestFragment extends Fragment {
	Button btn_push;
	Button btn_share;
	/**
	 * 百度推送
	 */
	private FrontiaSocialShare mSocialShare;
	private FrontiaSocialShareContent mImageContent = new FrontiaSocialShareContent();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initshare();
	}

	private void initshare() {
		mSocialShare = Frontia.getSocialShare();
		mSocialShare.setContext(getActivity());
		// mSocialShare.setClientId(MediaType.SINAWEIBO.toString(),
		// Conf.SINA_APP_KEY);新浪key
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

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.test_fragment, null);
		TextView tv = (TextView) view.findViewById(R.id.top_view_text);
		tv.setText("测试数据哟");
		btn_push = (Button) view.findViewById(R.id.btn_push);
		btn_push.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent it = new Intent(getActivity(), PushActivity.class);
				startActivity(it);
			}
		});
		btn_share = (Button) view.findViewById(R.id.btn_share);
		btn_share.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				mSocialShare.show(getActivity().getWindow().getDecorView(), mImageContent, FrontiaTheme.DARK,  null);
			}
		});
		return view;
	}

	@Override
	public void onResume() {

		super.onResume();
	}

	@Override
	public void onPause() {

		super.onPause();
	}

}
