package com.example.travelsite.dto;

public class OnsenDto {
    private Integer id;
    private Integer rank;
    private String prefecture;
    private String name;
    private String description;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image1PublicId;
    private String image2PublicId;
    private String image3PublicId;
    private String image4PublicId;


    public OnsenDto(Integer id, Integer rank, String prefecture, String name,
                    String description, String image1, String image2, String image3,
                    String image4, String image1PublicId, String image2PublicId, String image3PublicId,
                    String image4PublicId) {
        this.id = id;
        this.rank = rank;
        this.prefecture = prefecture;
        this.name = name;
        this.description = description;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image1PublicId = image1PublicId;
        this.image2PublicId = image2PublicId;
        this.image3PublicId = image3PublicId;
        this.image4PublicId = image4PublicId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRank() {
        return rank;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage1() {
        return image1;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage3() {
        return image3;
    }

    public String getImage4() {
        return image4;
    }

    public String getImage1PublicId() {
        return image1PublicId;
    }

    public String getImage2PublicId() {
        return image2PublicId;
    }

    public String getImage3PublicId() {
        return image3PublicId;
    }

    public String getImage4PublicId() {
        return image4PublicId;
    }
}
