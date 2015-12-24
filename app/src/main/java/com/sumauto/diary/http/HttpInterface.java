package com.sumauto.diary.http;

import android.text.TextUtils;
import android.util.SparseArray;


/**
 * Created by user1 on 2015/7/28.
 * http请求接口
 */
@SuppressWarnings("unused")
public class HttpInterface
{

    private static SparseArray<String> HOSTS = new SparseArray<>();
    public static final String HOST;

    static
    {
        HOSTS.put(0, "http://dev.svmuu.com");//dev
        HOSTS.put(1, "http://m-dev.svmuu.com");//h5移动版
        HOSTS.put(2, "http://dev-test.svmuu.com");//test
        HOSTS.put(3, "http://mtest.svmuu.com");//h5移动版
        HOSTS.put(4, "http://www.svmuu.com");//正式环境
        HOST = HOSTS.get(2);//todo host类型
    }

    /**
     * 获取完整链接,即加上后缀的链接
     */
    public static String getCompleteUrl(String httpInterface)
    {
//        String url_suffix = SharedPreferenceUtil.getInstance().getUrlSuffix();
//        if (!TextUtils.isEmpty(url_suffix))
//        {
//            httpInterface += "/" + url_suffix;
//        }
        return httpInterface;
    }

    /**
     * 获取原生链接，即没后后缀的链接
     */
    public static String getRawUrl(String url)
    {
        if (TextUtils.isEmpty(url))
        {
            return "";
        }
//        String url_suffix = SharedPreferenceUtil.getInstance().getUrlSuffix();

//        if (!TextUtils.isEmpty(url_suffix) && url.contains(url_suffix))
//        {
//            int position = url.lastIndexOf("/");
//            return url.substring(0, position);
//        }

        return url;
    }

    /**
     *
     * @param type 1:热门 2:新秀 3:人气
     */
    public static HttpParams indexInfo(int pn,int pageSize,int type){
        return new HttpParams("pn",pn,"pagesize",pageSize,"type", type).setUrl(HOST + "/appapi/index_info");
    }

    public static final String INDEX_HISTORY = HOST + "/appapi/visitor";
    /**
     * 登录接口
     */
    public static final String LOGIN = HOST + "/appapi/login";

    /**
     * 获取用户信息
     */
    public static final String USER_INFO = HOST + "/appapi/leftinfo";

    /**
     * 我订阅的宝盒
     */
    public static final String MY_BOOK_BOX = HOST + "/appapi/getMyBookBox";

    /**
     * 文字宝盒详情
     */
    public static final String TEXT_BOX_DETAIL = HOST + "/appapi/getTextBoxDetail";

    /**
     * 获取视频宝盒详情
     */
    public static final String VIDEO_BOX_DETAIL = HOST + "/appapi/getVideoBoxDetail";
    /**
     * 获取直播信息
     */
    public static final String LIVE_INFO        = HOST + "/appapi/livevideo";

    /**
     * 加关注
     */
    public static final String ADD_ATTENTION        = HOST + "/appapi/attention";
    /**
     * 获取全部直播列表，包括未直播的圈子
     */
    public static final String GET_ALL_LIVE         = HOST + "/appapi/live";
    /**
     * 搜索圈子
     */
    public static final String FIND_ALL_CIRCLE      = HOST + "/appapi/find";
    /**
     * 获取所有我关注的圈子
     */
    public static final String GET_ALL_MY_ATTENTION = HOST + "/appapi/mycircle";
    /**
     * 搜索我关注的圈子
     */
    public static final String FIND_MY_ATTENTION    = HOST + "/appapi/searchmycircle";
    /**
     * 获取直播录像列表
     */
    public static final String GET_VIDEO_LIST       = HOST + "/appapi/videolist";
    /**
     * 退出登录
     */
    public static final String LOGOUT               = HOST + "/appapi/logout";
    /**
     * 添加建议反馈
     */
    public static final String ADD_SUGGESTION       = HOST + "/appapi/getadvice";
    /**
     * 注册
     */
    public static final String REGISTER             = HOST + "/appapi/register";
    /**
     * 获取短信验证码
     */
    public static final String GET_SMS_CODE         = HOST + "/appapi/phone_code";
    /**
     * 获取最新版本信息
     */
    public static final String GET_NEWEST_VERSION   = HOST + "/appapi/app_version";
    /**
     * 发送聊天消息
     */
    public static final String SEND_MESSAGE         = HOST + "/appapi/sendmssage";

    /**
     * 授权
     */
    public static final String OAUTH  = HOST + "/appapi/oauth";
    /**
     * 易宝支付
     */
    public static final String PAY_YB = HOST + "/appapi/ybconfirm";
    /**
     * 通联支付
     */
    public static final String PAY_TL = HOST + "/appapi/tlConfirm";

    /**
     * 汇付宝
     */
    public static final String PAY_PH = HOST + "/appapi/hpconfirm";


    /**
     * 银行支付，这个要调用html5页面
     */
    public static final String PAY_BANK = "http://mtest.svmuu.com/bankpay.html";

    /**
     * 获取聊天消息列表
     */
    public static final String GET_NEW_CHAT_LIST  = HOST + "/appapi/livemsg";
    /**
     * 获取浏览解盘
     */
    public static final String GET_CHAT_EXPLAIN   = HOST + "/appapi/getexplain";
    /**
     * 获取铁粉悄悄话
     */
    public static final String GET_CHAT_FANS      = HOST + "/appapi/getfans";
    /**
     * 获取提问
     */
    public static final String GET_CHAT_ANSWER    = HOST + "/appapi/getanswer";
    /**
     * groupid	圈主id
     * type	1.全部 2.接盘 3.悄悄话 4.提问
     * date	（2015-07-01）
     * page	请求的页数
     */
    public static final String GET_CHAT_HISTORY   = HOST + "/appapi/livehistory";
    /**
     * 提问
     */
    public static final String SEND_CHAT_QUESTION = HOST + "/appapi/sendquestion";
    /**
     * 送礼物
     */
    public static final String SEND_GIFT          = HOST + "/appapi/sendgift";
    /**
     * 取消关注
     */
    public static final String CANCEL_ATTENTION   = HOST + "/appapi/delrelation";
    /**
     * 获取账户余额
     */
    public static final String GET_MONEY          = HOST + "/appapi/getusermoney";

    /**
     * 成为粉丝
     */
    public static final String BE_COME_FANS = HOST + "/appapi/becomefans";
    /**
     * 投票
     */
    public static final String VOTE         = HOST + "/appapi/vote";
    /**
     * 获取排名
     */
    public static final String GET_RANK     = HOST + "/appapi/getrank";
}
