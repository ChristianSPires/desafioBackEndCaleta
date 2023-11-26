package com.challenge.caleta.repository;

import com.challenge.caleta.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/*  Neste caso não necessitamos de um estereótipo do Spring (@Repository), visto que, ao extender o JpaRepository,
*   o Spring já reconhece que esta interface será do tipo Repository    */
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
