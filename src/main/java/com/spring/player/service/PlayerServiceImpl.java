package com.spring.player.service;

import java.util.List;

import javax.transaction.Transactional;

import com.spring.player.dao.PlayerDAO;
import com.spring.player.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	private PlayerDAO playerDao;

	@Autowired
	public PlayerServiceImpl(PlayerDAO playerDao) {
		this.playerDao = playerDao;
	}

	@Override
	public List<Player> allPlayers() {
		// begain
		return playerDao.findAll();
		// commit
	}

	@Override
	public void savePlayer(Player player) {
		playerDao.save(player);
	}

	@Override
	public Player showPlayer(int id) {
		return playerDao.findById(id).get();
	}

	@Override
	public void deletePlayer(int id) {
		playerDao.deleteById(id);
	}

}
