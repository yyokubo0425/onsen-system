package com.example.travelsite.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.travelsite.dto.OnsenDto;
import com.example.travelsite.dto.UploadResult;
import com.example.travelsite.entity.Onsen;
import com.example.travelsite.exception.OnsenNotFoundException;
import com.example.travelsite.form.OnsenForm;
import com.example.travelsite.repository.OnsenRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OnsenService {

    private final OnsenRepository onsenRepository;
    private final Cloudinary cloudinary;

    public OnsenService(OnsenRepository onsenRepository, Cloudinary cloudinary) {
        this.onsenRepository = onsenRepository;
        this.cloudinary = cloudinary;
    }

    //keyWordに応じてControllerに返却
    public Page<OnsenDto> getListDto(String keyWord, int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Onsen> onsenPage = (keyWord != null && !keyWord.isEmpty())
                ? onsenRepository.findByNameContainingOrPrefectureContaining(keyWord, keyWord, pageable)
                : onsenRepository.findAll(pageable);

        return onsenPage.map(o -> new OnsenDto(
                        o.getId(),
                        o.getRank(),
                        o.getPrefecture(),
                        o.getName(),
                        o.getDescription(),
                        o.getImage1(),
                        o.getImage2(),
                        o.getImage3(),
                        o.getImage4(),
                        o.getImage1PublicId(),
                        o.getImage2PublicId(),
                        o.getImage3PublicId(),
                        o.getImage4PublicId()
                ));
    }

    //登録温泉全件取得
    @Transactional(readOnly = true)
    public List<OnsenDto> listAllDto() {

        List<Onsen> list = onsenRepository.findAll();

        return list.stream()
                .map(o -> new OnsenDto(
                        o.getId(),
                        o.getRank(),
                        o.getPrefecture(),
                        o.getName(),
                        o.getDescription(),
                        o.getImage1(),
                        o.getImage2(),
                        o.getImage3(),
                        o.getImage4(),
                        o.getImage1PublicId(),
                        o.getImage2PublicId(),
                        o.getImage3PublicId(),
                        o.getImage4PublicId()
                ))
                .collect((Collectors.toList()));
    }

    //詳細
    @Transactional(readOnly = true)
    public OnsenDto findById(Integer id) {
        Onsen onsen = onsenRepository.findById(id)
                .orElseThrow(() -> new OnsenNotFoundException("温泉が見つかりません ID: " + id));
        return new OnsenDto(
                onsen.getId(),
                onsen.getRank(),
                onsen.getPrefecture(),
                onsen.getName(),
                onsen.getDescription(),
                onsen.getImage1(),
                onsen.getImage2(),
                onsen.getImage3(),
                onsen.getImage4(),
                onsen.getImage1PublicId(),
                onsen.getImage2PublicId(),
                onsen.getImage3PublicId(),
                onsen.getImage4PublicId()
        );
    }

    //CloudinaryにアップロードしてURLを返す
    public UploadResult uploadImage(MultipartFile file) {

        try{
            //CloudinaryのuploadのModeがSignedの場合
            var result = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap("folder" , "onsen_images"
                    )
            );

            UploadResult resultDto = new UploadResult();
            resultDto.setUrl(result.get("secure_url").toString());
            resultDto.setPublicId(result.get("public_id").toString());
            return resultDto;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Upload failed", e);
        }
    }


    //新規作成
    @Transactional
    public Onsen createWithImages(OnsenForm form){

        Onsen onsen = new Onsen();
        onsen.setName(form.getName());
        onsen.setPrefecture(form.getPrefecture());
        onsen.setRank(form.getRank());
        onsen.setDescription(form.getDescription());
        onsen.setCreatedAt(LocalDateTime.now());
        onsen.setUpdatedAt(LocalDateTime.now());
        MultipartFile image1 = form.getImage1();
        MultipartFile image2 = form.getImage2();
        MultipartFile image3 = form.getImage3();
        MultipartFile image4 = form.getImage4();


        //画像1
        if (image1 != null && !image1.isEmpty()) {
            UploadResult r = this.uploadImage(image2);
            onsen.setImage1(r.getUrl());
            onsen.setImage1PublicId(r.getPublicId());
        }

        //画像2
        if (image2 != null && !image2.isEmpty()) {
            UploadResult r = this.uploadImage(image2);
            onsen.setImage2(r.getUrl());
            onsen.setImage2PublicId(r.getPublicId());
        }

        //画像3
        if (image3 != null && !image3.isEmpty()) {
            UploadResult r = this.uploadImage(image3);
            onsen.setImage3(r.getUrl());
            onsen.setImage3PublicId(r.getPublicId());
        }

        //画像4
        if (image4 != null && !image4.isEmpty()) {
            UploadResult r = this.uploadImage(image4);
           onsen.setImage4(r.getUrl());
           onsen.setImage4PublicId(r.getPublicId());
        }

        return onsenRepository.save(onsen);
    }

    //更新
    @Transactional
    public Onsen updateWithImages(Integer id, OnsenForm form) {
        Onsen current = onsenRepository.findById(id)
                .orElseThrow(() -> new OnsenNotFoundException("Not Found ID +" + id));

        current.setName(form.getName());
        current.setPrefecture(form.getPrefecture());
        current.setRank(form.getRank());
        current.setDescription(form.getDescription());
        current.setUpdatedAt(LocalDateTime.now());
        MultipartFile image1 = form.getImage1();
        MultipartFile image2 = form.getImage2();
        MultipartFile image3 = form.getImage3();
        MultipartFile image4 = form.getImage4();

        //画像１
        if (image1 != null && !image1.isEmpty()) {
            deleteCloudinary(current.getImage1PublicId());
            UploadResult r = uploadImage(image1);
            current.setImage1(r.getUrl());
            current.setImage1PublicId(r.getPublicId());
        }

        //画像2
        if (image2 != null && !image2.isEmpty()) {
            deleteCloudinary(current.getImage2PublicId());
            UploadResult r = uploadImage(image2);
            current.setImage2(r.getUrl());
            current.setImage2PublicId(r.getPublicId());
        }

        //画像3
        if (image3 != null && !image3.isEmpty()) {
            deleteCloudinary(current.getImage3PublicId());
            UploadResult r = uploadImage(image3);
            current.setImage3(r.getUrl());
            current.setImage3PublicId(r.getPublicId());
        }

        //画像4
        if (image4 != null && !image4.isEmpty()) {
            deleteCloudinary(current.getImage4PublicId());
            UploadResult r = uploadImage(image4);
            current.setImage4(r.getUrl());
            current.setImage4PublicId(r.getPublicId());
        }

        return onsenRepository.save(current);
    }

    //削除(物理削除)
    @Transactional
    public void delete(Integer id) {
        Onsen onsen = onsenRepository.findById(id)
                .orElseThrow(() -> new OnsenNotFoundException("削除対象の温泉が見つかりません ID: " + id));

        deleteCloudinary(onsen.getImage1PublicId());
        deleteCloudinary(onsen.getImage2PublicId());
        deleteCloudinary(onsen.getImage3PublicId());
        deleteCloudinary(onsen.getImage4PublicId());

        onsenRepository.deleteById(id);
    }

    //Cloudinaryの画像削除
    private void deleteCloudinary(String publicId) {
        if (publicId == null || publicId.isBlank()) return;

        try {
            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        } catch (Exception e) {
            System.out.println("Cloudinary delete failed:" + publicId);
        }
    }
}
