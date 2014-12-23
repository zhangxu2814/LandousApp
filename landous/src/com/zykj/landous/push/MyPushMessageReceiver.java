package com.zykj.landous.push;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.baidu.frontia.api.FrontiaPushMessageReceiver;

/**
 * Push娑����澶����receiver���璇风�������ㄩ��瑕�������璋���芥�帮�� 涓������ヨ�达�� onBind���蹇�椤荤��锛���ㄦ�ュ�����startWork杩������硷��
 * onMessage��ㄦ�ユ�ユ�堕��浼�娑����锛� onSetTags���onDelTags���onListTags���tag��稿�虫��浣�������璋�锛�
 * onNotificationClicked��ㄩ����ヨ����瑰�绘�跺��璋�锛� onUnbind���stopWork��ュ�ｇ��杩������煎��璋�
 * 
 * 杩������间腑���errorCode锛�瑙ｉ��濡�涓�锛� 
 *  0 - Success
 *  10001 - Network Problem
 *  30600 - Internal Server Error
 *  30601 - Method Not Allowed 
 *  30602 - Request Params Not Valid
 *  30603 - Authentication Failed 
 *  30604 - Quota Use Up Payment Required 
 *  30605 - Data Required Not Found 
 *  30606 - Request Time Expires Timeout 
 *  30607 - Channel Token Timeout 
 *  30608 - Bind Relation Not Found 
 *  30609 - Bind Number Too Many
 * 
 * 褰���ㄩ����颁互涓�杩�������璇���讹��濡����瑙ｉ��涓�浜���ㄧ�����棰�锛�璇风�ㄥ��涓�璇锋�����杩�������requestId���errorCode���绯绘��浠�杩芥�ラ��棰����
 * 
 */
public class MyPushMessageReceiver extends FrontiaPushMessageReceiver {
    /** TAG to Log */
    public static final String TAG = MyPushMessageReceiver.class
            .getSimpleName();

    /**
     * 璋����PushManager.startWork���锛�sdk灏�瀵�push
     * server���璧风��瀹�璇锋��锛�杩�涓�杩�绋����寮�姝ョ�����缁�瀹�璇锋�����缁�������杩�onBind杩������� 濡������ㄩ��瑕���ㄥ�������ㄩ��锛����瑕����杩������峰�����channel
     * id���user id涓�浼���板�����server涓�锛����璋����server��ュ�ｇ��channel id���user id缁����涓������烘�������ㄦ�锋�ㄩ�����
     * 
     * @param context
     *            BroadcastReceiver�����ц��Context
     * @param errorCode
     *            缁�瀹���ュ�ｈ�������硷��0 - ������
     * @param appid
     *            搴����id���errorCode���0��朵负null
     * @param userId
     *            搴����user id���errorCode���0��朵负null
     * @param channelId
     *            搴����channel id���errorCode���0��朵负null
     * @param requestId
     *            ��������＄�����璧风��璇锋��id�����ㄨ拷��ラ��棰���舵�����锛�
     * @return none
     */
    @Override
    public void onBind(Context context, int errorCode, String appid,
            String userId, String channelId, String requestId) {
        String responseString = "onBind errorCode=" + errorCode + " appid="
                + appid + " userId=" + userId + " channelId=" + channelId
                + " requestId=" + requestId;
        Log.d(TAG, responseString);

        // 缁�瀹�������锛�璁剧疆宸茬��瀹�flag锛����浠ユ�����������灏�涓�蹇�瑕����缁�瀹�璇锋��
        if (errorCode == 0) {
//            Utils.setBind(context, true);
        }
        // Demo��存�扮����㈠��绀轰唬���锛�搴���ㄨ�峰�ㄨ����������ヨ��宸辩��澶������昏��
        updateContent(context, responseString);
    }

    /**
     * ��ユ�堕��浼�娑���������芥�般��
     * 
     * @param context
     *            涓�涓����
     * @param message
     *            ��ㄩ�����娑����
     * @param customContentString
     *            ���瀹�涔����瀹�,涓虹┖������json瀛�绗�涓�
     */
    @Override
    public void onMessage(Context context, String message,
            String customContentString) {
        String messageString = "���浼�娑���� message=\"" + message
                + "\" customContentString=" + customContentString;
        Log.d(TAG, messageString);

        // ���瀹�涔����瀹硅�峰����瑰��锛�mykey���myvalue瀵瑰�����浼�娑������ㄩ����惰��瀹�涔����瀹逛腑璁剧疆������������
        if (!TextUtils.isEmpty(customContentString)) {
            JSONObject customJson = null;
            try {
                customJson = new JSONObject(customContentString);
                String myvalue = null;
                if (!customJson.isNull("mykey")) {
                    myvalue = customJson.getString("mykey");
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // Demo��存�扮����㈠��绀轰唬���锛�搴���ㄨ�峰�ㄨ����������ヨ��宸辩��澶������昏��
        updateContent(context, messageString);
    }

    /**
     * ��ユ�堕����ョ�瑰�荤����芥�般��娉�锛���ㄩ�������ヨ����ㄦ�风�瑰�诲��锛�搴���ㄦ��娉����杩���ュ�ｈ�峰�������ョ�����瀹广��
     * 
     * @param context
     *            涓�涓����
     * @param title
     *            ��ㄩ����������ョ�����棰�
     * @param description
     *            ��ㄩ����������ョ�����杩�
     * @param customContentString
     *            ���瀹�涔����瀹癸��涓虹┖������json瀛�绗�涓�
     */
    @Override
    public void onNotificationClicked(Context context, String title,
            String description, String customContentString) {
        String notifyString = "�����ョ�瑰�� title=\"" + title + "\" description=\""
                + description + "\" customContent=" + customContentString;
        Log.d(TAG, notifyString);

        // ���瀹�涔����瀹硅�峰����瑰��锛�mykey���myvalue瀵瑰�������ユ�ㄩ����惰��瀹�涔����瀹逛腑璁剧疆������������
        if (!TextUtils.isEmpty(customContentString)) {
            JSONObject customJson = null;
            try {
                customJson = new JSONObject(customContentString);
                String myvalue = null;
                if (!customJson.isNull("mykey")) {
                    myvalue = customJson.getString("mykey");
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // Demo��存�扮����㈠��绀轰唬���锛�搴���ㄨ�峰�ㄨ����������ヨ��宸辩��澶������昏��
        updateContent(context, notifyString);
    }

    /**
     * setTags() ������璋���芥�般��
     * 
     * @param context
     *            涓�涓����
     * @param errorCode
     *            ���璇�������0琛ㄧず���浜�tag宸茬��璁剧疆������锛����0琛ㄧず������tag���璁剧疆���澶辫触���
     * @param successTags
     *            璁剧疆���������tag
     * @param failTags
     *            璁剧疆澶辫触���tag
     * @param requestId
     *            ������缁�瀵逛����ㄩ�����璇锋�����id
     */
    @Override
    public void onSetTags(Context context, int errorCode,
            List<String> sucessTags, List<String> failTags, String requestId) {
        String responseString = "onSetTags errorCode=" + errorCode
                + " sucessTags=" + sucessTags + " failTags=" + failTags
                + " requestId=" + requestId;
        Log.d(TAG, responseString);

        // Demo��存�扮����㈠��绀轰唬���锛�搴���ㄨ�峰�ㄨ����������ヨ��宸辩��澶������昏��
        updateContent(context, responseString);
    }

    /**
     * delTags() ������璋���芥�般��
     * 
     * @param context
     *            涓�涓����
     * @param errorCode
     *            ���璇�������0琛ㄧず���浜�tag宸茬�������ゆ�����锛����0琛ㄧず������tag��������ゅけ璐ャ��
     * @param successTags
     *            �����������ょ��tag
     * @param failTags
     *            �����ゅけ璐ョ��tag
     * @param requestId
     *            ������缁�瀵逛����ㄩ�����璇锋�����id
     */
    @Override
    public void onDelTags(Context context, int errorCode,
            List<String> sucessTags, List<String> failTags, String requestId) {
        String responseString = "onDelTags errorCode=" + errorCode
                + " sucessTags=" + sucessTags + " failTags=" + failTags
                + " requestId=" + requestId;
        Log.d(TAG, responseString);

        // Demo��存�扮����㈠��绀轰唬���锛�搴���ㄨ�峰�ㄨ����������ヨ��宸辩��澶������昏��
        updateContent(context, responseString);
    }

    /**
     * listTags() ������璋���芥�般��
     * 
     * @param context
     *            涓�涓����
     * @param errorCode
     *            ���璇�������0琛ㄧず���涓�tag������锛����0琛ㄧず澶辫触���
     * @param tags
     *            褰����搴���ㄨ�剧疆���������tag���
     * @param requestId
     *            ������缁�瀵逛����ㄩ�����璇锋�����id
     */
    @Override
    public void onListTags(Context context, int errorCode, List<String> tags,
            String requestId) {
        String responseString = "onListTags errorCode=" + errorCode + " tags="
                + tags;
        Log.d(TAG, responseString);

        // Demo��存�扮����㈠��绀轰唬���锛�搴���ㄨ�峰�ㄨ����������ヨ��宸辩��澶������昏��
        updateContent(context, responseString);
    }

    /**
     * PushManager.stopWork() ������璋���芥�般��
     * 
     * @param context
     *            涓�涓����
     * @param errorCode
     *            ���璇�������0琛ㄧず浠�浜���ㄩ��瑙ｇ��瀹�������锛����0琛ㄧず澶辫触���
     * @param requestId
     *            ������缁�瀵逛����ㄩ�����璇锋�����id
     */
    @Override
    public void onUnbind(Context context, int errorCode, String requestId) {
        String responseString = "onUnbind errorCode=" + errorCode
                + " requestId = " + requestId;
        Log.d(TAG, responseString);

        // 瑙ｇ��瀹�������锛�璁剧疆���缁�瀹�flag锛�
        if (errorCode == 0) {
//            Utils.setBind(context, false);
        }
        // Demo��存�扮����㈠��绀轰唬���锛�搴���ㄨ�峰�ㄨ����������ヨ��宸辩��澶������昏��
        updateContent(context, responseString);
    }

    private void updateContent(Context context, String content) {
        Log.d(TAG, "updateContent");
        String logText = "";

        if (!logText.equals("")) {
            logText += "\n";
        }

        SimpleDateFormat sDateFormat = new SimpleDateFormat("HH-mm-ss");
        logText += sDateFormat.format(new Date()) + ": ";
        logText += content;

//        Utils.logStringCache = logText;

//        Intent intent = new Intent();
//        intent.setClass(context.getApplicationContext(), PushActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.getApplicationContext().startActivity(intent);
    }

}
