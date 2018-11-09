package com.cad.carlink.weixin.test.annotation;

public enum ELiteratureType {
    KEHUAN(70,"科幻"),
    SHIGE(80,"诗歌"),
    SANWEN(90,"散文");
    /** 主键 */
    private final Long key;

    /** 描述 */
    private final String desc;

    private ELiteratureType(long key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public Long getKey() {
        return key;
    }

    public String GetDesc() {
        return desc;
    }

    public static String GetDesc(Long key){
        for(ELiteratureType typeEnum : ELiteratureType.values()){
            if(typeEnum.key.equals(key)){
                return typeEnum.desc;
            }
        }
        return "";
    }
}
