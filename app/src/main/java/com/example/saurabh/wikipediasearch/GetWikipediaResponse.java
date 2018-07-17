package com.example.saurabh.wikipediasearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetWikipediaResponse implements Serializable{

@SerializedName("batchcomplete")
@Expose
private Boolean batchcomplete;
@SerializedName("query")
@Expose
private Query query;

public Boolean getBatchcomplete() {
return batchcomplete;
}

public void setBatchcomplete(Boolean batchcomplete) {
this.batchcomplete = batchcomplete;
}

public Query getQuery() {
return query;
}

public void setQuery(Query query) {
this.query = query;
}
    public static class Query  implements Serializable {

        @SerializedName("pages")
        @Expose
        private List<Page> pages = null;

        public List<Page> getPages() {
            return pages;
        }

        public void setPages(List<Page> pages) {
            this.pages = pages;
        }
        public class Page {

            @SerializedName("pageid")
            @Expose
            private Integer pageid;
            @SerializedName("ns")
            @Expose
            private Integer ns;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("thumbnail")
            @Expose
            private Thumbnail thumbnail;
            @SerializedName("pageimage")
            @Expose
            private String pageimage;
            @SerializedName("terms")
            @Expose
            private Terms terms;

            public Integer getPageid() {
                return pageid;
            }

            public void setPageid(Integer pageid) {
                this.pageid = pageid;
            }

            public Integer getNs() {
                return ns;
            }

            public void setNs(Integer ns) {
                this.ns = ns;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Thumbnail getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(Thumbnail thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getPageimage() {
                return pageimage;
            }

            public void setPageimage(String pageimage) {
                this.pageimage = pageimage;
            }

            public Terms getTerms() {
                return terms;
            }

            public void setTerms(Terms terms) {
                this.terms = terms;
            }


            public  class Terms  implements Serializable {

                @SerializedName("alias")
                @Expose
                private List<String> alias = null;
                @SerializedName("description")
                @Expose
                private List<String> description = null;
                @SerializedName("label")
                @Expose
                private List<String> label = null;

                public List<String> getAlias() {
                    return alias;
                }

                public void setAlias(List<String> alias) {
                    this.alias = alias;
                }

                public List<String> getDescription() {
                    return description;
                }

                public void setDescription(List<String> description) {
                    this.description = description;
                }

                public List<String> getLabel() {
                    return label;
                }

                public void setLabel(List<String> label) {
                    this.label = label;
                }

            }

            public class Thumbnail  implements Serializable{

                @SerializedName("source")
                @Expose
                private String source;
                @SerializedName("width")
                @Expose
                private Integer width;
                @SerializedName("height")
                @Expose
                private Integer height;

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public Integer getWidth() {
                    return width;
                }

                public void setWidth(Integer width) {
                    this.width = width;
                }

                public Integer getHeight() {
                    return height;
                }

                public void setHeight(Integer height) {
                    this.height = height;
                }

            }

        }
    }


}




