package com.service;

import com.github.pagehelper.PageInfo;
import com.model.Feedback;

import java.util.List;

public interface FeedbackService extends IService<Feedback> {
    PageInfo<Feedback> listByPage(Feedback feedback, int start, int length);

    List<Feedback> listWithoutPage(Feedback feedback);

    void saveFeedback(Feedback feedback);
}
