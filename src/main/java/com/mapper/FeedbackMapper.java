package com.mapper;

import com.model.Feedback;
import com.util.MyMapper;

import java.util.List;

public interface FeedbackMapper extends MyMapper<Feedback> {
    List<Feedback> getAll(Feedback feedback);

    List<Feedback> listWithoutPage(Feedback feedback);

    void saveFeedback(Feedback feedback);
}
