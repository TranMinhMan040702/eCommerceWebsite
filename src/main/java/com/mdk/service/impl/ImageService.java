package com.mdk.service.impl;

import com.mdk.dao.IImageDAO;
import com.mdk.dao.impl.ImageDAO;
import com.mdk.models.Image;
import com.mdk.service.IImageService;

public class ImageService implements IImageService {
    IImageDAO imageDAO = new ImageDAO();
    @Override
    public void insert(Image image) {
        imageDAO.insert(image);
    }
}
