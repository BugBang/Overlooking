package com.chat.bxchat.entity.common;

import java.util.List;

/**
 * @创建者 baoxin
 * @日期 2017/4/27.
 * @描述
 */

public class SplashImgEntity {

    private List<CreativesBean> creatives;

    public List<CreativesBean> getCreatives() {
        return creatives;
    }

    public void setCreatives(List<CreativesBean> creatives) {
        this.creatives = creatives;
    }

    public static class CreativesBean {
        /**
         * url : https://pic3.zhimg.com/v2-5af460972557190bd4306ad66f360d4a.jpg
         * start_time : 1491927091
         * impression_tracks : ["https://sugar.zhihu.com/track?vs=1&ai=3838&ut=&cg=2&ts=1491927091.68&si=52848dcc42b046bbb2d7a40921268157&lu=0&hn=ad-engine.ad-engine.7fab952b&at=impression&pf=PC&az=11&sg=4590d6230fc8f471ada5f10e6f27be94"]
         * type : 0
         * id : 3838
         */

        private String url;
        private int start_time;
        private int type;
        private String id;
        private List<String> impression_tracks;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getStart_time() {
            return start_time;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getImpression_tracks() {
            return impression_tracks;
        }

        public void setImpression_tracks(List<String> impression_tracks) {
            this.impression_tracks = impression_tracks;
        }
    }
}
