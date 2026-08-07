package com.mikuac.shiro.action;

import com.mikuac.shiro.dto.action.common.ActionData;
import com.mikuac.shiro.dto.action.common.ActionRaw;
import com.mikuac.shiro.dto.action.response.GetMsgListResp;
import com.mikuac.shiro.dto.action.response.SendQzoneResp;

import java.util.List;

public interface NapCatExtend {

    /**
     * 获取群聊历史消息记录
     *
     * @param groupId      指定的群聊
     * @param messageSeq   指定的消息id
     * @param count        获取的消息条数
     * @param reverseOrder 是否反转获取到的消息,false：返回的消息为正序；true:返回的消息为倒序
     * @return 返回的消息列表
     */
    ActionData<GetMsgListResp> getGroupMsgHistory(long groupId, Long messageSeq, int count, boolean reverseOrder);

    /**
     * 获取好友历史消息记录
     *
     * @param userId       指定的好友
     * @param messageSeq   指定的消息id
     * @param count        获取的消息条数
     * @param reverseOrder 是否反转获取到的消息,false：返回的消息为正序；true:返回的消息为倒序
     * @return 返回的消息列表
     */
    ActionData<GetMsgListResp> getFriendMsgHistory(long userId, Long messageSeq, int count, boolean reverseOrder);

    ActionRaw sendGroupPoke(long groupId, long userId);

    ActionRaw sendFriendPoke(long userId);

    ActionRaw sendFriendPoke(long userId, long targetId);

    /**
     * 设置消息表情回应(贴表情)
     *
     * @param msgId 消息 ID
     * @param code  表情 ID
     * @param isSet 添加/取消 回应
     * @return result {@link ActionRaw}
     */
    ActionRaw setMsgEmojiLike(int msgId, String code, boolean isSet);


    /**
     * 发表QQ空间说说
     * @param content 说说正文
     * @param richvals 每张图片对应的richval数组, 为空表示纯文字说说
     * @param ugcRight 查看权限 1所有人可见 4好友可见 16部分好友可见 64仅自己可见 128部分好友不可见
     * @param targetUins 权限作用QQ号数组, ugcRight为16/128时使用
     * @return {@link ActionData} of {@link SendQzoneResp}
     */
    ActionData<SendQzoneResp> publishQzoneMsg(String content, List<String> richvals, int ugcRight, List<Integer> targetUins);

    /**
     * 删除QQ空间说说
     * @param tid 说说Tid, 来自 publishQzoneMsg 的返回值
     * @return result {@link ActionRaw}
     */
    ActionRaw deleteQzoneMsg(String tid);
}
