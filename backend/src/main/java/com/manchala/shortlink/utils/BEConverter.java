package com.manchala.shortlink.utils;

import com.manchala.shortlink.dto.URLBean;
import com.manchala.shortlink.entity.URLEntity;
import org.springframework.beans.BeanUtils;

public class BEConverter {

    public static URLBean convertEntityToBean(URLEntity urlEntity) {
        URLBean urlBean = new URLBean();
        BeanUtils.copyProperties(urlEntity, urlBean);
        return urlBean;
    }
    public static URLEntity convertBeanToEntity(URLBean urlBean) {
        URLEntity urlEntity = new URLEntity();
        BeanUtils.copyProperties(urlBean, urlEntity);
        return urlEntity;
    }
}
