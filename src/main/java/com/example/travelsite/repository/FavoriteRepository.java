package com.example.travelsite.repository;

import com.example.travelsite.entity.Favorite;
import com.example.travelsite.entity.Onsen;
import com.example.travelsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    Optional<Favorite> findByUserAndOnsen(User user, Onsen onsen);

    List<Favorite> findByUser(User user);
}
