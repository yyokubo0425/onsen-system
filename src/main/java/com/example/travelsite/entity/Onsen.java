package com.example.travelsite.entity;

import jakarta.persistence.*;

import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "onsen")
public class Onsen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String prefecture;
    @Column(name = "ranking")
    private Integer rank;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String image1;
    private String image2;
    private String image3;
    private String image4;

    private String image1PublicId;
    private String image2PublicId;
    private String image3PublicId;
    private String image4PublicId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(
            mappedBy = "onsen",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    private List<Favorite> favoriteList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage1PublicId() {
        return image1PublicId;
    }

    public void setImage1PublicId(String id) {
        this.image1PublicId = id;
    }

    public String getImage2PublicId() {
        return image2PublicId;
    }

    public void setImage2PublicId(String id) {
        this.image2PublicId = id;
    }

    public String getImage3PublicId() {
        return image3PublicId;
    }

    public void setImage3PublicId(String id) {
        this.image3PublicId = id;
    }

    public String getImage4PublicId() {
        return image4PublicId;
    }

    public void setImage4PublicId(String id) {
        this.image4PublicId = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
