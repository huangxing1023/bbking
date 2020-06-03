package com.family.bbkingservice.impl;

import com.family.bbkingdao.entity.contribute.UploadFile;
import com.family.bbkingdao.mapper.UploadFileMapper;
import com.family.bbkingservice.UploadService;
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
