package com.example.embedsocial.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Review {
    private int id;
    private String reviewId;
    private String reviewFullText;
    private String reviewText;
    private int numLikes;
    private int numComments;
    private int numShares;
    private int rating;
    private String reviewCreatedOn;
    private String reviewCreatedOnDate;
    private long reviewCreatedOnTime;
    private String reviewerId;
    private String reviewerUrl;
    private String reviewerName;
    private String reviewerEmail;
    private String sourceType;
    private boolean isVerified;
    private String source;
    private String sourceName;
    private String sourceId;
    private List<String> tags;
    private String href;
    private String logoHref;
    private List<String> photos;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Review(
            @JsonProperty("id") int id,
            @JsonProperty("reviewId") String reviewId,
            @JsonProperty("reviewFullText") String reviewFullText,
            @JsonProperty("reviewText") String reviewText,
            @JsonProperty("numLikes") int numLikes,
            @JsonProperty("numComments") int numComments,
            @JsonProperty("numShares") int numShares,
            @JsonProperty("rating") int rating,
            @JsonProperty("reviewCreatedOn") String reviewCreatedOn,
            @JsonProperty("reviewCreatedOnDate") String reviewCreatedOnDate,
            @JsonProperty("reviewCreatedOnTime") long reviewCreatedOnTime,
            @JsonProperty("reviewerId") String reviewerId,
            @JsonProperty("reviewerUrl") String reviewerUrl,
            @JsonProperty("reviewerName") String reviewerName,
            @JsonProperty("reviewerEmail") String reviewerEmail,
            @JsonProperty("sourceType") String sourceType,
            @JsonProperty("isVerified") boolean isVerified,
            @JsonProperty("source") String source,
            @JsonProperty("sourceName") String sourceName,
            @JsonProperty("sourceId") String sourceId,
            @JsonProperty("tags") List<String> tags,
            @JsonProperty("href") String href,
            @JsonProperty("logoHref") String logoHref,
            @JsonProperty("photos") List<String> photos) {
        this.id = id;
        this.reviewId = reviewId;
        this.reviewFullText = reviewFullText;
        this.reviewText = reviewText;
        this.numLikes = numLikes;
        this.numComments = numComments;
        this.numShares = numShares;
        this.rating = rating;
        this.reviewCreatedOn = reviewCreatedOn;
        this.reviewCreatedOnDate = reviewCreatedOnDate;
        this.reviewCreatedOnTime = reviewCreatedOnTime;
        this.reviewerId = reviewerId;
        this.reviewerUrl = reviewerUrl;
        this.reviewerName = reviewerName;
        this.reviewerEmail = reviewerEmail;
        this.sourceType = sourceType;
        this.isVerified = isVerified;
        this.source = source;
        this.sourceName = sourceName;
        this.sourceId = sourceId;
        this.tags = tags;
        this.href = href;
        this.logoHref = logoHref;
        this.photos = photos;
    }

}


