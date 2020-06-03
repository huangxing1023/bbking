package com.family.bbkingweb.service.impl;

import com.family.bbkingweb.dao.entity.contribute.UploadFile;
import com.family.bbkingweb.dao.mapper.UploadFileMapper;
import com.family.bbkingweb.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("uploadService")
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UploadFileMapper uploadFileMapper;
    @Override
    public int saveUploadFile(UploadFile uploadFile) {
        return uploadFileMapper.saveUploadFile(uploadFile);
    }
}
