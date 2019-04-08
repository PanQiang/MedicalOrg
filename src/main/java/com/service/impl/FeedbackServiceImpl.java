package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.FeedbackMapper;
import com.model.Feedback;
import com.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("feedbackService")
public class FeedbackServiceImpl extends BaseService<Feedback> implements FeedbackService {

	@Autowired
	private FeedbackMapper feedbackMapper;


	@Override
	public PageInfo<Feedback> listByPage(Feedback feedback, int start, int length) {
        int page = start/length+1;
        PageHelper.startPage(page, length);
		List<Feedback> list = feedbackMapper.getAll(feedback);

        return new PageInfo<>(list);
	}

	@Override
	public List<Feedback> listWithoutPage(Feedback feedback) {
		return feedbackMapper.listWithoutPage(feedback);
	}

	@Override
	public void saveFeedback(Feedback feedback) {
		feedbackMapper.saveFeedback(feedback);
	}

}
