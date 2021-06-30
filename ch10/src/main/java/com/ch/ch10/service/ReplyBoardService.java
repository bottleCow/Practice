package com.ch.ch10.service;

import java.util.List;
import com.ch.ch10.model.ReplyBoard;

public interface ReplyBoardService {
	List<ReplyBoard> list(int bno);

	void delete(ReplyBoard rbd);

	void insert(ReplyBoard rb);

	void update(ReplyBoard rb);

}