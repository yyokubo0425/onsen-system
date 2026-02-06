package com.example.travelsite.service;

import com.example.travelsite.entity.Favorite;
import com.example.travelsite.entity.Onsen;
import com.example.travelsite.entity.User;
import com.example.travelsite.repository.FavoriteRepository;
import com.example.travelsite.repository.OnsenRepository;
import com.example.travelsite.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final OnsenRepository onsenRepository;
    private final UserRepository userRepository;

    public FavoriteService(FavoriteRepository favoriteRepository, OnsenRepository onsenRepository, UserRepository userRepository) {
        this.favoriteRepository = favoriteRepository;
        this.onsenRepository = onsenRepository;
        this.userRepository = userRepository;
    }

    //お気に入り登録
    public void addFavorite(Integer userId, Integer onsenId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Onsen onsen = onsenRepository.findById(onsenId)
                .orElseThrow(() -> new RuntimeException("Onsen not found"));

        //既に登録済みなら何もしない
        if (favoriteRepository.findByUserAndOnsen(user, onsen).isPresent()) {
            return;
        }

        Favorite fav = new Favorite();
        fav.setUser(user);
        fav.setOnsen(onsen);

        favoriteRepository.save(fav);
    }

    //お気に入り解除
    public void removeFavorite(Integer favoriteId) {
        Favorite fav = favoriteRepository.findById(favoriteId)
                .orElseThrow(() -> new RuntimeException("Favorite not found"));

        favoriteRepository.delete(fav);
    }

    //お気に入り一覧
    public List<Favorite> getFavorites(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return favoriteRepository.findByUser(user);
    }

    public boolean isAlreadyFavorite(Integer userId, Integer onsenId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Onsen onsen = onsenRepository.findById(onsenId)
                .orElseThrow(() -> new RuntimeException("Onsen not found"));
        return favoriteRepository.findByUserAndOnsen(user,onsen).isPresent();
    }
}
