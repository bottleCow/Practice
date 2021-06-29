package com.ch.ch09.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ch.ch09.model.Board;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSessionTemplate sst;

	public List<Board> list(Board board) {
		return sst.selectList("boardns.list", board);
	}

	public int getTotal(Board board) {
		return sst.selectOne("boardns.getTotal", board);
	}

	public int getMaxNum() {
		return sst.selectOne("boardns.getMaxNum");
	}

	public int insert(Board board) {
		return sst.insert("boardns.insert", board);
	}

	public void updateReadCount(int num) {
		sst.update("boardns.updateReadCount", num);
	}

	public Board select(int num) {
		return sst.selectOne("boardns.select", num);
	}

	public int update(Board board) {
		return sst.update("boardns.update", board);
	}

	public int delete(int num) {
		return sst.update("boardns.delete", num);
	}

	public void updateStep(Board board) {
		sst.update("boardns.updateStep", board);
	}
}