package com.example.travelsite.controller;

import com.example.travelsite.entity.Favorite;
import com.example.travelsite.entity.User;
import com.example.travelsite.security.UserDetailsImpl;
import com.example.travelsite.service.FavoriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    //お気に入り追加
    @PostMapping("/add")
    public ResponseEntity<?> addListFavorite(Integer onsenId, @RequestParam("redirect") String redirect, @AuthenticationPrincipal UserDetailsImpl user) {

        if (user == null) {
            return ResponseEntity.status(401).body("unauthorized");
        }

        Integer userId = user.getUser().getId();

        if(favoriteService.isAlreadyFavorite(userId,onsenId)){
            return ResponseEntity.status(409).body("already");
        }

        favoriteService.addFavorite(userId, onsenId);

        return ResponseEntity.ok("success");
    }

    //お気に入り削除
    @PostMapping("/remove")
    public String removeFavorite(Integer favoriteId, @RequestParam("redirect") String redirect, @AuthenticationPrincipal UserDetailsImpl user) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }

        favoriteService.removeFavorite(favoriteId);
        return "redirect:" + redirect;
    }

    //お気に入り一覧ページ
    @GetMapping("/list")
    public String list(Model model, @AuthenticationPrincipal UserDetailsImpl user) {
        Integer userId = user.getUser().getId();
        List<Favorite> list = favoriteService.getFavorites(userId);
        model.addAttribute("favoriteList", list);
        model.addAttribute("pageTitle", "お気に入り温泉一覧");
        return "onsen/favorite";
    }
}
