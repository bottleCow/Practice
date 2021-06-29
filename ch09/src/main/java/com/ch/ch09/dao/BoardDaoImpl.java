package com.ch.ch09.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.ch09.model.Board;
@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public List<Board> list(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		// 보내줄때 startRow, endRow 둘 다 못쓰기때문에  HashMap으로 묶어서 보내줌
		return sst.selectList("boardns.list", map);
											// ^위 칸에는 1가지 밖에 못씀
	}

	@Override
	public int getTotal() {
		return sst.selectOne("boardns.getTotal");
	}
	
	public int getMaxNum() {
		return sst.selectOne("boardns.getMaxNum");
	}
	
	public int insert(Board board) {
		return sst.insert("boardns.insert", board);
	}

	@Override
	public void updateReadCount(int num) {
		sst.update("boardns.updateReadCount", num);
	}

	@Override
	public Board select(int num) {
		return sst.selectOne("boardns.select", num);
	}

	@Override
	public int update(Board board) {
		return sst.update("boardns.update", board);
	}
	
	
	
}