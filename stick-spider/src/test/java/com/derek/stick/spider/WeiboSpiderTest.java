package com.derek.stick.spider;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.derek.stick.common.serialize.SerializableTool;
import com.derek.stick.spider.common.ImageDownloader;
import com.derek.stick.spider.weibo.WeiboDbWriter;
import com.derek.stick.spider.weibo.WeiboSpider;
import com.derek.stick.spider.weibo.module.CommentInfo;
import com.derek.stick.spider.weibo.module.Mblog;
import com.derek.stick.spider.weibo.module.WeiboRecordInfo;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public class WeiboSpiderTest {

//    private String          uid         = "1798058151";
//    private String          containerId = "1076031798058151";

    private String          uid         = "5834408758";
    private String          containerId = "1076035834408758";

    private String          picDir      = "/Volumes/My Passport/spider/weibo/20181115";

    private WeiboSpider     spider;
    private ImageDownloader downloader;

    @Before
    public void before() {
        spider = new WeiboSpider(uid, containerId, new WeiboDbWriter() {

            @Override
            public Long writeWeiboRecord(WeiboRecordInfo recordInfo) {
                System.out.println("\n\n==========> weibo card: ============");
                System.out.println(SerializableTool.serializeFormat(recordInfo));
                return 1L;
            }

            @Override
            public void writeComment(Long dbId, String recordId, String recordMid, CommentInfo commentInfo) {
                System.out.println(String.format("\tdbId: %s | id: %s | mid: %s | comment: %s", dbId, recordId,
                                                 recordMid, SerializableTool.serializeFormat(commentInfo)));
            }
        });

        downloader = new ImageDownloader(picDir + "/" + uid);
    }

    @Test
    public void testPages() {
        int no = 1;
        boolean isEnd = false;
        while (!isEnd) {
            List<WeiboRecordInfo> recordInfoList = getPage(no++);
            if (recordInfoList == null || recordInfoList.isEmpty()) {
                isEnd = true;
                continue;
            }
            savePics(recordInfoList);
        }
    }

    @Test
    public void testGetPage() {
        List<WeiboRecordInfo> recordInfoList = getPage(1);
        savePics(recordInfoList);
    }

    @Test
    public void testGetCardAndComment() {
        spider.getPageAndWrite2Db(0);
    }

    private List<WeiboRecordInfo> getPage(int no) {
        List<WeiboRecordInfo> recordInfoList = spider.getPage(no);
//        System.out.println(SerializableTool.serializeFormat(recordInfoList));
        return recordInfoList;
    }

    private void savePics(List<WeiboRecordInfo> recordInfoList) {
        if (recordInfoList == null || recordInfoList.isEmpty()) {
            return;
        }
        for (WeiboRecordInfo recordInfo : recordInfoList) {
            if (recordInfo == null || recordInfo.getMblog() == null || recordInfo.getMblog().getPics() == null
                || recordInfo.getMblog().getPics().isEmpty()) {
                continue;
            }
            List<Mblog.PicInfo> picInfoList = recordInfo.getMblog().getPics();
            for (Mblog.PicInfo picInfo : picInfoList) {
                if (picInfo == null || picInfo.getLarge() == null || picInfo.getLarge().getUrl() == null) {
                    continue;
                }
                downloader.download(picInfo.getLarge().getUrl());
            }
        }
    }
}
