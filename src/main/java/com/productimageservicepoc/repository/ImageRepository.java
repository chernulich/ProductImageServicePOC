package com.productimageservicepoc.repository;

import com.productimageservicepoc.entity.ImageTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageTest, Long> {
}
