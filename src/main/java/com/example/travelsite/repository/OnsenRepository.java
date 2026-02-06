package com.example.travelsite.repository;

import com.example.travelsite.entity.Onsen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnsenRepository extends JpaRepository<Onsen, Integer> {
    //keyword(温泉名、都道府県)＋ページング機能
    Page<Onsen> findByNameContainingOrPrefectureContaining(String name, String prefecture, Pageable pageable);
}
